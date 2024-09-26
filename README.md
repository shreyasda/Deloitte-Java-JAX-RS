
# Java-JAX-RS Project

## Overview

Java-JAX-RS is a project that implements a RESTful web service using the Java API for RESTful Web Services (JAX-RS). This project demonstrates how to build a simple RESTful API that communicates with a MySQL database.

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

### 6. Testing the API

You can test the API endpoints using Insomnia or any other API testing tool. Below are the sample endpoints:

- **GET /api/items** - Retrieve all items
- **POST /api/items** - Create a new item
- **GET /api/items/{id}** - Retrieve a specific item by ID
- **PUT /api/items/{id}** - Update an item by ID
- **DELETE /api/items/{id}** - Delete an item by ID

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.


