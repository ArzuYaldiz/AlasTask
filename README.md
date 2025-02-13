**Overview**
-

Shopping Website API is a Spring Boot-based e-commerce API that manages products, categories, shopping carts, and product details using MySQL and JPA. The project follows a layered architecture and utilizes Spring Data JPA, and Spring Security.

**Project Structure**

The application is organized into five main packages:

Entity: Defines database entities with @Entity annotations, relationships, and cascade types.

DTO (Data Transfer Objects): Used for data encapsulation and reducing API complexity.

Repository: Interfaces extending JpaRepository for database interactions.

Service: Contains business logic with interface definitions and their implementations in the impl subpackage.

Controller: REST API endpoints, using @RestController to handle requests and return ResponseEntity objects.

**Features**

✅ Add, retrieve, and delete products with details and categories.

✅ Manage shopping carts and associate multiple products.

✅ Use FetchType.LAZY for optimized entity loading.

✅ Automatically create missing product details or categories when adding new products.

✅ Secure authentication using Spring Security & JWT.

✅ Custom queries for efficient product removal from shopping carts.

**Technologies Used**

Spring Boot 3.3.2

Spring Data JPA

MySQL

Spring Security & JWT

Docker & Liquibase

3- Build and run the application:

./gradlew bootRun

4- Access API endpoints via Postman or your frontend.
