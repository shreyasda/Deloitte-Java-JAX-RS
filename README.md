
# Java-JAX-RS Employee Management System

## Overview

This Java-JAX-RS project implements a RESTful web service for managing employees and departments in a simple employee management system. It showcases fundamental RESTful API principles, including CRUD (Create, Read, Update, Delete) operations for both entities, and integrates with a MySQL database for data storage and retrieval.

## Features

- RESTful API endpoints
- Integration with MySQL database
- Basic CRUD operations
- Simple JSON responses
- Testing with Insomnia

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- MySQL Database
- IDE (e.g., IntelliJ IDEA, Eclipse)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/java-jax-rs.git
cd java-jax-rs
```

### 2. Set Up MySQL Database

- Create a MySQL database and user.
- Run the SQL script located in the `sql` folder to set up the database schema.

### 3. Configure Database Connection

- Update the database connection settings in the `src/main/resources/application.properties` file:

```properties
db.url=jdbc:mysql://localhost:3306/your_database
db.username=your_username
db.password=your_password
```

### 4. Build the Project

Use Maven to build the project:

```bash
mvn clean install
```

### 5. Run the Application

Run the application using your IDE or by executing the following command:

```bash
mvn spring-boot:run
```

### 6. Testing the API using Insomnia/Postman

You can test the API endpoints using Insomnia or any other API testing tool. Below are the sample endpoints:

#### Department Endpoints
- **GET /departments** - Retrieves a list of all departments.
- **POST /departments** - Creates a new department.
- **GET /departments/{id}** - Retrieves a specific department by its unique ID.
- **PUT /departments/{id}** - Updates the details of a specific department.
- **DELETE /departments/{id}** - Deletes a specific department by its unique ID.

#### Employee Endpoints
- **GET /employees** - Retrieves a list of all employees.
- **POST /employees** - Creates a new employee.
- **GET /employees/{id}** - Retrieves a specific employee by their unique ID.
- **PUT /employees/{id}** - Updates the details of a specific employee.
- **DELETE /employees/{id}** - Deletes a specific employee by their unique ID.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.


