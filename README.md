# 🌱 AgriLoop AI – Backend

AgriLoop AI is an agriculture-focused platform designed to connect farmers and customers, helping improve access to fresh fruits and vegetables. The backend provides REST APIs for managing products, orders, and application health.

## 🚀 Features

- **Product Management:** Retrieve and manage product information.
- **Order Management:** Handle order-related operations.
- **Health Check API:** Check whether the backend application is running.
- **Database Integration:** Store application data using MySQL.
- **REST API Architecture:** Communicate with the frontend through HTTP APIs.
- **Cross-Origin Support:** Configure frontend access using CORS.

## 🛠️ Technologies Used

- Java 21
- Spring Boot 3.3.5
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- REST APIs
- Docker

## 📁 Project Structure

```text
AgriLoop-AI-Backend/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/agriloop/
│       │       ├── AgriLoopApplication.java
│       │       ├── HealthController.java
│       │       ├── config/
│       │       │   └── CorsConfig.java
│       │       ├── product/
│       │       │   ├── Product.java
│       │       │   ├── ProductController.java
│       │       │   └── ProductRepository.java
│       │       └── order/
│       │           ├── Order.java
│       │           ├── OrderController.java
│       │           └── OrderRepository.java
│       └── resources/
│           └── application.properties
├── Dockerfile
├── pom.xml
├── .gitignore
└── README.md
```

## ⚙️ Prerequisites

Install the following software before running the project:

- Java JDK 21
- Maven
- MySQL Server
- Git

## 🗄️ Database Setup

1. Start your MySQL server.
2. Create the database:

```sql
CREATE DATABASE agriloop_ai;
```

3. Configure the database connection using environment variables.

For local development in PowerShell:

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/agriloop_ai"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="root"
```

Replace the example password with your own MySQL password if it differs.

**Security:** Never commit actual database passwords or other secrets to a public GitHub repository.

## ▶️ Run the Application

Open PowerShell in the backend project directory.

### 1. Check Java

```powershell
java -version
```

### 2. Validate the Maven project

```powershell
mvn validate
```

### 3. Start the backend

```powershell
mvn spring-boot:run
```

The application is configured to run at:

`http://localhost:8080`

## 🔌 API Endpoints

The backend contains health-check, product, and order controllers.

| Module | Purpose |
|---|---|
| Health | Check backend availability |
| Products | Product-related operations |
| Orders | Order-related operations |

The exact routes and supported HTTP methods are defined in the corresponding controller classes under `src/main/java/com/agriloop/`.

## 🐳 Docker

A `Dockerfile` is included for containerizing the backend. Configure the required database environment variables and ensure the MySQL database is reachable from the container before running the application.

## 🔗 Related Project

**Frontend Repository:**  
https://github.com/snehitha123456/AgriLoop-AI

## 🎯 Project Goal

AgriLoop AI aims to support an agriculture-focused digital ecosystem by connecting farmers and customers through technology.

## 👩‍💻 Development Status

This project is under development. Features and API endpoints may change as development continues.

## 📄 License

No license has been specified yet. All rights are reserved by the project owner unless a license is added.
