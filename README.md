# 🎟️ Fawry Coupon API Microservice

A lightweight Spring Boot microservice to manage discount coupons. Built with MySQL, Docker, Swagger, and full test coverage.

---

## 🔧 Features

- Create coupons with expiry, usage limits, and discount types (fixed or percentage)
- Consume coupons, log usage, and return discount value for other services
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

### 📌 Endpoint Details

#### 1. **Create a Coupon**
- **URL:** `/api/coupons`
- **Method:** `POST`
- **Request Body:**
```json
{
  "code": "WELCOME10",
  "usageLimit": 5,
  "usedCount": 0,
  "expiryDate": "2025-12-31",
  "discountType": "PERCENTAGE",
  "discountValue": 10.0,
  "minOrder": 50
}
```
- **Response:**
```json
{
  "id": 1,
  "code": "WELCOME10",
  "usageLimit": 5,
  "usedCount": 0,
  "expiryDate": "2025-12-31",
  "discountType": "PERCENTAGE",
  "discountValue": 10.0,
  "minOrder": 50
}
```

#### 2. **Consume a Coupon**
- **URL:** `/api/coupons/consume`
- **Method:** `POST`
- **Query Parameters:**
    - `code` (string): The coupon code
    - `orderId` (string): The order ID
    - `orderTotal` (double): Total amount of the order

- **Example Request:**
```
POST /api/coupons/consume?code=WELCOME10&orderId=12345&orderTotal=100.0
```

- **Response:**
```json
{
  "message": "Coupon consumed successfully",
  "discount": 10.0
}
```

#### 3. **List All Coupons**
- **URL:** `/api/coupons`
- **Method:** `GET`
- **Response:**
```json
[
  {
    "id": 1,
    "code": "WELCOME10",
    "usageLimit": 5,
    "usedCount": 1,
    "expiryDate": "2025-12-31",
    "discountType": "PERCENTAGE",
    "discountValue": 10.0,
    "minOrder": 50
  }
]
```

#### 4. **Get Coupon Consumption History**
- **URL:** `/api/coupons/history`
- **Method:** `GET`
- **Response:**
```json
[
  {
    "id": 1,
    "orderId": "12345",
    "orderTotal": 100.0,
    "coupon": {
      "id": 1,
      "code": "WELCOME10",
      "usageLimit": 5,
      "usedCount": 1,
      "expiryDate": "2025-12-31",
      "discountType": "PERCENTAGE",
      "discountValue": 10.0,
      "minOrder": 50
    },
    "usedAt": "2025-07-29T23:45:00"
  }
]
```

---

## ⚙️ Config (application.properties)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/coupon_db
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.data.jdbc.dialect=mysql
```

---

## 📄 License

MIT License
