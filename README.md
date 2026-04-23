# 📚 Bookstore API

API REST desarrollada con Spring Boot para la gestión de una librería en línea.
Este proyecto implementa arquitectura por capas, seguridad con JWT, relaciones JPA y un flujo de trabajo colaborativo con Git.

---

## 🚀 Características

### 🔐 Autenticación y Seguridad

* Registro de usuarios (`/auth/register`)
* Inicio de sesión con JWT (`/auth/login`)
* Autenticación stateless con tokens
* Control de acceso basado en roles (`ADMIN` y `USER`)

### 📚 Gestión de Libros

* CRUD completo de libros
* Paginación en consultas
* Filtro por autor y categoría
* Acceso público para consulta

### 👤 Gestión de Usuarios

* Registro de nuevos usuarios
* Validación de datos
* Roles (`USER`, `ADMIN`)

### 🧑‍🎨 Autores y Categorías

* CRUD completo de autores
* CRUD completo de categorías
* Consulta de libros por autor y categoría
* Validaciones con DTOs

### 🛒 Gestión de Órdenes

* Creación de pedidos con múltiples libros
* Cálculo automático del total en el service
* Estados del pedido (`PENDING`, `CONFIRMED`, `CANCELLED`)
* Consulta de pedidos propios y globales

### ⚠️ Manejo de Errores

* Manejo global de excepciones (`@RestControllerAdvice`)
* Respuestas estandarizadas:

  * `ApiResponse`
  * `ApiErrorResponse`

### 🔄 Flujo Git

* Uso de ramas:

  * `develop`
  * `feature/auth-module`
  * `feature/book-catalog`
  * `feature/order-management`
  * `feature/author-category`
* Pull Requests con revisión, aprobación y merge

---

## 🛠️ Tecnologías Utilizadas

* **Java 17**
* **Spring Boot**
* **Spring Security**
* **JWT (JSON Web Tokens)**
* **Spring Data JPA**
* **H2 Database (desarrollo)**
* **Swagger / OpenAPI**
* **Maven**

---

## 🧱 Arquitectura

El proyecto sigue arquitectura por capas:

```
controller → service → repository → entity
        ↕
      mapper
        ↕
        dto
```

Separación de responsabilidades:

* Controllers → Exponen endpoints
* Services → Lógica de negocio
* Repositories → Acceso a datos
* DTOs → Contratos de entrada y salida
* Mappers → Conversión de datos

---

## 🗂️ Estructura del Proyecto

```
com.taller.bookstore
│
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── exception
│   ├── custom
│   └── handler
├── mapper
├── repository
├── security
├── service
│   └── impl
```

---

## 📊 Diagrama ER

El modelo de datos del sistema se representa en el siguiente diagrama:

![Diagrama ER](docs/er/bookstore_er_diagram.png)

Este diagrama muestra las relaciones entre las entidades principales:
**User, Book, Author, Category, Order y OrderItem.**

---

## ⚙️ Configuración

Ejemplo de configuración en `application.yml`:

```yml
spring:
  datasource:
    url: jdbc:h2:mem:bookstoredb
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

app:
  jwt:
    secret: ${JWT_SECRET}
    expiration: 86400000

server:
  servlet:
    context-path: /api/v1
```

---

##  Ejecución del Proyecto

### 1. Clonar repositorio

```bash
git clone https://github.com/steveenbaez1-collab/bookstore-api.git
```

### 2. Entrar al proyecto

```bash
cd bookstore-api
```

### 3. Ejecutar

```bash
mvn spring-boot:run
```

---

##  Pruebas de API

Puedes probar los endpoints con:

* Postman (colección incluida en el proyecto)
* Swagger UI:

```
http://localhost:8080/api/v1/swagger-ui.html
```

---

##  Endpoints Principales

###  Auth

* `POST /auth/register`
* `POST /auth/login`

###  Books

* `GET /books`
* `POST /books`
* `PUT /books/{id}`
* `DELETE /books/{id}`

###  Orders

* `POST /orders`
* `GET /orders`
* `GET /orders/my`

---
### 
##  Entregables

* ✔ API REST funcional
* ✔ Arquitectura por capas
* ✔ Seguridad JWT
* ✔ Manejo de errores global
* ✔ Mappers manuales
* ✔ Pull Requests con flujo Git
* ✔ Colección Postman
* ✔ Diagrama ER

---

## 👨‍💻 Autor

**Steveen Baez**
