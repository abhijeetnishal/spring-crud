# **Stage 1: Build (gradle:latest as builder)**

FROM gradle:latest as builder

# Create a working directory for the application within the container
WORKDIR /gradle/project

# Copy Gradle build files
COPY build.gradle .
COPY settings.gradle .

# Copy the entire source code
COPY src src

# Build the application
RUN gradle build --no-daemon


# **Stage 2 & 3: Runner (eclipse-temurin:17-jre)**

FROM eclipse-temurin:17-jre

# Create a working directory for the application within the container
WORKDIR application

# Copy the JAR file from the builder stage to the runner stage
COPY --from=builder /gradle/project/build/libs/crud-0.0.1-SNAPSHOT.jar application.jar

# Expose port 8080 for the application to listen on
EXPOSE 8080

# Entrypoint: Execute the JAR file to start the application
ENTRYPOINT ["java", "-jar", "application.jar"]
