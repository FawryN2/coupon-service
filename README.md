# 🎟️ Fawry Coupon API Microservice

A lightweight Spring Boot microservice to manage discount coupons. Built with MySQL, Docker, Swagger, and full test coverage.

---

## 🔧 Features

- Create coupons with expiry, usage limits, and discount types (fixed or percentage)
- Consume coupons and log usage
- View all coupons and their history
- RESTful API with Swagger documentation
- MySQL-based persistence
- Unit and integration tests
- Docker-ready

---

## 📦 Tech Stack

- Java 17
- Spring Boot
- Spring Web, Data JPA, Validation, Lombok
- MySQL 8
- Swagger (Springdoc OpenAPI)
- Docker & Docker Compose
- JUnit 5

---

## 🚀 Quick Start

### 1. Build the app

```bash
./mvnw clean package
```

### 2. Start with Docker

```bash
docker-compose up --build
```

Services:
- MySQL: `localhost:3306`
- API: `localhost:8080`

---

## 🌐 Swagger UI

Visit:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🧪 Run Tests

```bash
./mvnw test
```

---

## 📂 API Endpoints

| Method | Endpoint               | Description                |
|--------|------------------------|----------------------------|
| POST   | `/api/coupons`         | Create a new coupon        |
| POST   | `/api/coupons/consume` | Consume a coupon           |
| GET    | `/api/coupons`         | List all coupons           |
| GET    | `/api/coupons/history` | Get usage history          |

---

## ⚙️ Config (application.properties)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/coupon_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 📄 License

MIT License
