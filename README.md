# Student Management System

A RESTful Student Management System built using Spring Boot. This project demonstrates backend development concepts such as CRUD operations, layered architecture, DTOs, manual mapping, Spring Data JPA, and PostgreSQL.

## Project Overview

The Student Management System provides REST APIs to manage student records. It follows a clean layered architecture with Controller, Service, Repository, DTO, and Entity layers.

This project was developed to practice Spring Boot backend development and will be enhanced with additional enterprise-level features.

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- REST APIs
- DTO (Data Transfer Object)
- Manual Entity-DTO Mapping
- ResponseEntity
- IntelliJ IDEA
- Git & GitHub

---

## Features

- Create Student
- Get Student by ID
- Get All Students
- Update Student
- Delete Student
- Layered Architecture
- DTO Implementation
- Manual Mapper
- Spring Data JPA Repository
- PostgreSQL Database Integration
- ResponseEntity for HTTP Responses

---

## Project Structure

```
src
 ├── controller
 ├── service
 ├── serviceImpl
 ├── repository
 ├── entity
 ├── dto
 ├── mapper
 └── exception
```

---

## API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/students` | Create a new student |
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get student by ID |
| PUT | `/students/{id}` | Update student |
| DELETE | `/students/{id}` | Delete student |

> Update the endpoint paths if your project uses different URLs.

---

## Database

- PostgreSQL
- Spring Data JPA
- Hibernate ORM

---

## Future Enhancements

The following features will be implemented as part of this learning project:

- Logging (SLF4J / Logback)
- Swagger / OpenAPI Documentation
- Spring Security
- JWT Authentication
- Role-Based Authorization
- Unit Testing (JUnit & Mockito)
- Integration Testing
- Docker Support
- CI/CD Pipeline
- Deployment

---

## Completed Features

- ✅ CRUD Operations
- ✅ DTO
- ✅ Manual Mapper
- ✅ ResponseEntity
- ✅ Bean Validation
- ⏳ Spring Security
- ⏳ JWT Authentication

## Author

**Humera Parveen**

Backend Developer | Java | Spring Boot | PostgreSQL

---

## License

This project is developed for learning and portfolio purposes.
