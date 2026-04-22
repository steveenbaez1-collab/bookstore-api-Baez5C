# Online Bookstore API

This project implements a Spring Boot REST API for an online bookstore. The API provides functionalities for managing books, users, and orders with a focus on security and authentication.

## Features
- **Authentication:** Users can register and log in to access the features of the API.
- **Authorization:** Role-based access control to ensure that only authorized users can perform certain actions.
- **Book Management:** Create, read, update, and delete books.
- **User Management:** Register new users and manage user accounts.
- **Order Management:** Place and manage orders for books.
- **API Documentation:** Comprehensive API documentation provided using Swagger.

## Technologies Used
- **Java 17** - Programming language
- **Spring Boot** - Framework for building the REST API
- **Spring Security** - Authentication and authorization
- **JWT (JSON Web Tokens)** - Token-based authentication
- **MySQL** - Database for storing user and book information
- **Swagger** - API documentation

## Getting Started
1. **Clone the repository:**
   ```bash
   git clone https://github.com/steveenbaez1-collab/bookstore-api.git
   ```
2. **Navigate to the project directory:**
   ```bash
   cd bookstore-api
   ```
3. **Set up the database:**
   - Create a MySQL database named `bookstore`
   - Update the application.properties file with your database credentials
4. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```
5. **Access the API documentation:**
   - Visit `http://localhost:8080/swagger-ui/` to view the API documentation.

## Contributing
Contributions are welcome! Please submit a pull request or create an issue for any changes you'd like to suggest.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.