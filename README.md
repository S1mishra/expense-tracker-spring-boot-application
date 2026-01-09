# Expense Tracker Spring Boot Application

A simple and efficient expense tracking application built with Spring Boot 2.7.15, Java 11, and Maven.

## Features

- Track and manage expenses
- User authentication with JWT
- RESTful API endpoints
- Database persistence with H2 (can be switched to MySQL/PostgreSQL)
- Input validation
- Exception handling
- Unit testing

## Technology Stack

- **Framework**: Spring Boot 2.7.15
- **Language**: Java 11
- **Build Tool**: Maven 3.9.4
- **Database**: H2 (Default)
- **Security**: Spring Security with JWT
- **Mapping**: MapStruct
- **Annotations**: Lombok

## Project Structure

```
springboot-expense-tracker/
├── src/
│   ├── main/
│   │   ├── java/com/example/expensetracker/
│   │   │   ├── config/          # Configuration classes
│   │   │   ├── security/        # Security configuration
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── dto/             # Data Transfer Objects
│   │   │   ├── exception/       # Custom exceptions
│   │   │   ├── model/           # JPA entities
│   │   │   ├── repository/      # Data access layer
│   │   │   ├── service/         # Business logic
│   │   │   ├── util/            # Utility classes
│   │   │   ├── mapper/          # Entity to DTO mappers
│   │   │   └── ExpenseTrackerApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── data.sql
│   └── test/
│       └── java/com/example/expensetracker/
│           └── service/
│               └── ExpenseServiceTest.java
├── pom.xml
├── .gitignore
└── README.md
```

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.9.4 or higher
- Git 2.41.0 or higher

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd expense-tracker-spring-boot-application
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

- **GET** `/api/expenses` - Get all expenses
- **GET** `/api/expenses/{id}` - Get expense by ID
- **POST** `/api/expenses` - Create new expense
- **PUT** `/api/expenses/{id}` - Update expense
- **DELETE** `/api/expenses/{id}` - Delete expense

## Configuration

Edit `src/main/resources/application.yml` to configure:
- Server port
- Database settings
- JWT secret key
- Logging levels

## Database

By default, the application uses H2 in-memory database. To switch to a persistent database:

### MySQL
Add the following dependency to `pom.xml`:
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

Update `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/expense_tracker
    username: root
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    dialect: org.hibernate.dialect.MySQL8Dialect
```

## Testing

Run tests with:
```bash
mvn test
```

## Contributing

1. Create a new branch: `git checkout -b feature/your-feature`
2. Commit your changes: `git commit -am 'Add new feature'`
3. Push to the branch: `git push origin feature/your-feature`
4. Submit a pull request

## License

This project is open source and available under the MIT License.

## Support

For support, email support@example.com or open an issue on the repository.
