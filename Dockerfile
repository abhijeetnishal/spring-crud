# **Stage 1: Build (eclipse-temurin:17-jre)**

FROM eclipse-temurin:17-jre as builder

# Create a working directory for the application within the container
WORKDIR application

# Define a build argument for the JAR file path
ARG JAR_FILE=build/libs/crud-0.0.1-SNAPSHOT.jar

# Copy the Spring Boot application JAR file
COPY ${JAR_FILE} application.jar

# Extract layered dependencies for efficient image building (Spring Boot 2.3+ feature)
RUN java -Djarmode=layertools -jar application.jar extract


# **Stage 2: Runner (eclipse-temurin:17-jre)**

FROM eclipse-temurin:17-jre

# Set the same working directory as the build stage
WORKDIR application

# Copy extracted dependencies from the build stage
COPY --from=builder application/dependencies/ ./

# Copy Spring Boot loader from the build stage
COPY --from=builder application/spring-boot-loader/ ./

# Copy snapshot dependencies from the build stage (if applicable)
COPY --from=builder application/snapshot-dependencies/ ./

# Copy the application itself from the build stage
COPY --from=builder application/application/ ./

# Expose port 8080 for the application to listen on
EXPOSE 8080

# Entrypoint: Execute the JAR launcher to start the application
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
