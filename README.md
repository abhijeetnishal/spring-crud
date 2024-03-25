# Spring Boot CRUD Application

## Table of Contents
- [About](#about)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation Guide](#installation-guide)
- [Running Using Docker](#running-using-docker)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## About
This is a Spring Boot application that performs CRUD (Create, Read, Update, Delete) operations. It provides a RESTful API to interact with a MySQL database for managing resources.

## Features
- Create, Read, Update, and Delete operations on resources.
- RESTful API for easy integration with front-end applications.
- Data validation and error handling.
- Docker support for easy deployment.

## Technologies Used
- Spring Boot
- MySQL
- Docker

## Installation Guide
Follow these steps to set up the project locally:

1. **Clone the repository:**
    ```bash
    git clone https://github.com/abhijeetnishal/spring-crud.git
    cd spring-crud
    ```

2. **Configure MySQL:**
    - Install MySQL if not already installed.
    - Create a new database and configure its connection details in `application.properties`.

3. **Build and Run the Application**

## Running Using Docker
To run the application using Docker, follow these steps:

1. **Build the Docker Image:**
    ```bash
    docker build -t yourproject .
    ```

2. **Run the Docker Container:**
    ```bash
    docker run -d -p 8080:8080 --name yourcontainer yourproject
    ```

## Usage
Once the application is up and running, you can interact with it using any HTTP client (e.g., Postman). Here are some sample API endpoints:

- `GET /api/users`: Retrieve all users.
- `GET /api/users/{id}`: Retrieve a specific user.
- `POST /api/users`: Create a new user.
- `PUT /api/users/{id}`: Update an existing user.
- `DELETE /api/users/{id}`: Delete a user.

Make sure to replace `{id}` with the actual ID of the resource.

## Contributing
Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request.