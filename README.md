# 💰 Expense Tracker Manager - Backend (Spring Boot)

A RESTful backend service for an Expense Tracking application built with Java and Spring Boot. The API supports secure user authentication and CRUD operations on expense records, providing structured endpoints for building a full-featured financial tracker.

---

## 🚀 Features

- 🔐 User Authentication (JWT)
- 📦 CRUD operations for expense records
- 📊 Filter expenses by date, category, or amount
- 🗃️ MySQL-based persistent storage
- 🔧 Built with layered architecture: Controller, Service, Repository
- 🌐 RESTful APIs for easy frontend integration

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## 📬 API Endpoints

| Method | Endpoint            | Description               |
|--------|---------------------|---------------------------|
| POST   | /api/expenses       | Add a new expense         |
| GET    | /api/expenses       | Get all expenses          |
| GET    | /api/expenses/{id}  | Get a specific expense    |
| PUT    | /api/expenses/{id}  | Update an expense         |
| DELETE | /api/expenses/{id}  | Delete an expense         |

---
