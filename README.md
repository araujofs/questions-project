# 🏆 Eureka

> A competitive web platform where participants race through challenges and accumulate points.

---

## 📋 Table of Contents

- [About](#about)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Contributing](#contributing)

---

## About

**Eureka** is a Spring Boot web application designed for competitive learning. Participants join task "races" — fast-paced, challenge-style events — and earn points based on their performance. The platform tracks scores and rankings, making it ideal for educational competitions or team-based quiz sessions.

---

## Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| **Java** | 21 | Core language |
| **Spring Boot** | 4.0.3 | Application framework |
| **Spring Web MVC** | — | REST & web layer |
| **Spring Data JPA** | — | ORM & data access |
| **Spring Validation** | — | Bean validation |
| **Thymeleaf** | — | Server-side HTML templating |
| **H2** | — | In-memory relational database (dev) |
| **MapStruct** | 1.6.3 | DTO mapping |
| **Lombok** | — | Boilerplate reduction |
| **Tailwind CSS** | 4.x | Utility-first CSS framework |
| **Node.js / pnpm** | 24 / 10 | Frontend tooling |
| **Maven** | — | Build & dependency management |

---

## Prerequisites

Before running the project, make sure you have the following installed:

- [JDK 21+](https://openjdk.org/)
- [Maven 3.9+](https://maven.apache.org/)
- [Node.js 24+](https://nodejs.org/) (for CSS builds)

---

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/araujofs/eureka.git
cd eureka
```

### 2. Build and run

The application uses an H2 in-memory database in development — no database setup required.

```bash
./mvnw spring-boot:run
```

The application will start on [http://localhost:8080](http://localhost:8080).

### 3. Running tests

```bash
./mvnw test
```

### 4. Docker (production)

A `Dockerfile` and `compose.yml` are provided for containerised deployments.

```bash
docker compose --profile pro up --build
```

---

## Project Structure

```
src/
├── main/
│   ├── java/br/edu/ifpb/pweb2/eureka/
│   │   ├── EurekaApplication.java      # Application entry point
│   │   ├── auth/                       # Authentication (session-based)
│   │   ├── config/                     # Spring configuration
│   │   ├── question/                   # Question entity, repository & DTOs
│   │   ├── race/                       # Race entity, service, controller & DTOs
│   │   ├── result/                     # Result & answered question entities
│   │   └── user/                       # User entity & repository
│   └── resources/
│       ├── static/css/                 # Tailwind CSS (input/output)
│       └── templates/                  # Thymeleaf HTML templates
└── test/
    └── java/br/edu/ifpb/pweb2/eureka/  # Unit & integration tests
```

---

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/my-feature`)
3. Commit your changes (`git commit -m 'Add my feature'`)
4. Push to the branch (`git push origin feature/my-feature`)
5. Open a Pull Request
