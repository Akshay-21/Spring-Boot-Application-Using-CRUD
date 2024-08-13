# Spring-Boot-Application-Using-CRUD

## Project Structure

### Spring Boot Application

        Model Class: Defines the entity.
        Repository Interface: Extends JpaRepository for database operations.
        Service Layer: Contains business logic.
        Controller Layer: Handles HTTP requests.
        Database Configuration: Uses H2 in-memory database for simplicity.

### Step 1: Set up Your Spring Boot Project

    Initialize a Spring Boot Project:
        Go to Spring Initializr.
        Project: Maven Project.
        Language: Java.
        Spring Boot: Choose the latest stable version.
        Dependencies: Add the following:
            Spring Web
            Spring Data JPA
            H2 Database
            Lombok (optional but recommended)
        Group: com.example
        Artifact: crud-demo
        Packaging: Jar
        Java Version: 17 or the latest supported version.
        Click "Generate" to download the project and unzip it.

### Project Structure

Here’s a suggested package structure for the Spring Boot application:

```
src/main/java/com/example/demo/
├── controller/
│   └── UserController.java
├── model/
│   └── User.java
├── repository/
│   └── UserRepository.java
├── service/
│   └── UserService.java
└── DemoApplication.java
```

### Summary

```
*  controller: Manages HTTP requests and responses.
*  model: Defines the entity classes that represent the data.
*  repository: Handles data access and CRUD operations.
*  service: Contains business logic and interacts with the repository layer.
*  Root Package: Contains the main application entry point.
```

### Start Your Spring Boot Application:

    Run your application from your IDE or use `mvn spring-boot:run` from the command line.

### Open Postman and Test Endpoints:

    Create a User:
        Method: POST
        URL: http://localhost:8080/api/users
        Body (raw JSON):

        json

    {
        "name": "John Doe",
        "email": "john.doe@example.com"
    }

    Send the request.

Get All Users:

    Method: GET
    URL: http://localhost:8080/api/users
    Send the request.

Get a User by ID:

    Method: GET
    URL: http://localhost:8080/api/users/{id}
    Replace {id} with the actual user ID.
    Send the request.

Update a User:

    Method: PUT
    URL: http://localhost:8080/api/users/{id}
    Body (raw JSON):

    json

    {
        "name": "Jane Doe",
        "email": "jane.doe@example.com"
    }

    Replace {id} with the actual user ID.
    Send the request.

Delete a User:

    Method: DELETE
    URL: http://localhost:8080/api/users/{id}
    Replace {id} with the actual user ID.
    Send the request.

### Ensure Correct Content-Type Header

#### When sending a POST request to create a user, you need to set the Content-Type header to application/json. This tells the server that the request body is in JSON format.

In Postman:

    Select the POST method.
    Enter the URL, e.g., http://localhost:8080/users.
    Go to the Headers tab and make sure you add:

```
    plaintext

    Key: Content-Type
    Value: application/json
```    

<p>Go to the Body tab, select raw, and ensure that JSON is selected from the dropdown menu.
Enter your JSON payload in the body.</p>

#### Example JSON body:

```
json

{
"name": "John Doe",
"email": "john.doe@example.com"
}
```

## Steps to Access the H2 Database Console:
<p>In a Spring Boot CRUD operation project, if you're using an H2 in-memory database (as configured in the example), you can view the data stored in the database using the H2 Console. The H2 Console is a web-based interface that allows you to execute SQL queries and view the data in your database.</p>


### 1. Enable the H2 Console:
*   Ensure that the H2 Console is enabled in your application.properties file. It should look like this:

```
properties

spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```

### 2. Run Your Spring Boot Application:
        Start your Spring Boot application as you normally would.

### 3. Access the H2 Console:
        Open your web browser and go to http://localhost:8080/h2-console.
        You should see the H2 Console login page.

### 4. Login to the H2 Console:
        JDBC URL: jdbc:h2:mem:testdb (this should match the spring.datasource.url in your application.properties)
        Username: sa (default username configured in application.properties)
        Password: password (default password configured in application.properties)
        Click on "Connect."

### 5. View Your Data:
        Once connected, you'll be able to see a list of tables in your database.
        You can execute SQL queries to view, insert, update, or delete data.
        For example, you can run SELECT * FROM PRODUCT; to see all entries in the Product table if you followed the example project structure.

### Note:
*   The H2 database in this configuration is in-memory, meaning that it is temporary and will be lost when the application is stopped. If you need a persistent database, you would configure a different database (e.g., MySQL, PostgreSQL) in your application.properties.


#### Example: SQL Query in H2 Console

```
sql
SELECT * FROM PRODUCT;
```

<p>This query will display all records in the PRODUCT table, showing you the data you've inserted through your CRUD operations.</p>

### Alternative: Persistent Database

<p>If you prefer using a persistent database like MySQL, you would change your application.properties to point to your MySQL database, and you can then access your data using any MySQL client (like MySQL Workbench).</p>
