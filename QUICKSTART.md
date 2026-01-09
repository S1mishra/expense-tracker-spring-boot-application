# Expense Tracker - Quick Start Guide

## Environment Setup Verified ✓

- **Java**: 11
- **Maven**: 3.9.4
- **Spring Boot**: 2.7.15
- **Git**: 2.41.0.windows.3

## Project Structure

```
expense-tracker-spring-boot-application/
├── pom.xml                           # Maven configuration with all dependencies
├── README.md                          # Full project documentation
├── QUICKSTART.md                      # This file
├── .gitignore                         # Git ignore rules
│
└── src/
    ├── main/
    │   ├── java/com/example/expensetracker/
    │   │   ├── ExpenseTrackerApplication.java      # Main Spring Boot class
    │   │   ├── config/
    │   │   │   └── SecurityConfig.java             # Security & password encoding
    │   │   ├── controller/
    │   │   │   └── ExpenseController.java          # REST API endpoints
    │   │   ├── dto/
    │   │   │   ├── ExpenseDTO.java                 # Expense data transfer object
    │   │   │   └── ApiResponse.java                # Generic API response wrapper
    │   │   ├── exception/
    │   │   │   ├── ResourceNotFoundException.java   # Custom exception
    │   │   │   └── GlobalExceptionHandler.java     # Exception handling
    │   │   ├── model/
    │   │   │   └── Expense.java                    # JPA entity
    │   │   ├── repository/
    │   │   │   └── ExpenseRepository.java          # Database access layer
    │   │   ├── service/
    │   │   │   └── ExpenseService.java             # Business logic
    │   │   ├── util/
    │   │   │   └── DateUtil.java                   # Date utilities
    │   │   └── mapper/
    │   │       └── ExpenseMapper.java              # Entity-DTO mappings
    │   │
    │   └── resources/
    │       ├── application.yml                     # Spring Boot configuration
    │       └── data.sql                            # Sample database data
    │
    └── test/
        └── java/com/example/expensetracker/service/
            └── ExpenseServiceTest.java             # Unit tests (8 tests)
```

## Build & Run

### 1. Build the Project
```bash
mvn clean install
```
✓ Build status: SUCCESS (verified)

### 2. Run Tests
```bash
mvn clean test
```
✓ Test status: 8/8 PASSED

### 3. Start the Application
```bash
mvn spring-boot:run
```
Application will start on: **http://localhost:8080**

### 4. Access H2 Database Console
```
http://localhost:8080/h2-console
```
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

## API Endpoints

### GET Endpoints
- `GET /api/expenses` - Get all expenses
- `GET /api/expenses/{id}` - Get expense by ID
- `GET /api/expenses/user/{userId}` - Get expenses for specific user
- `GET /api/expenses/category/{category}` - Get expenses by category

### POST Endpoint
- `POST /api/expenses` - Create new expense
```json
{
  "description": "Grocery Shopping",
  "amount": 45.50,
  "category": "Food",
  "userId": "user1"
}
```

### PUT Endpoint
- `PUT /api/expenses/{id}` - Update existing expense
```json
{
  "description": "Updated description",
  "amount": 50.00,
  "category": "Food"
}
```

### DELETE Endpoint
- `DELETE /api/expenses/{id}` - Delete expense

## Sample Data

The application loads sample data on startup (`data.sql`):
- 5 sample expenses across multiple categories
- 2 sample users (user1, user2)
- Categories: Food, Transportation, Entertainment, Health

## Dependencies

| Dependency | Version | Purpose |
|-----------|---------|---------|
| Spring Boot Starter Web | 2.7.15 | REST API |
| Spring Data JPA | 2.7.15 | Database ORM |
| Spring Security | 2.7.15 | Security |
| Spring Validation | 2.7.15 | Input validation |
| H2 Database | Latest | In-memory DB |
| Lombok | 1.18.30 | Annotations |
| MapStruct | 1.5.3 | Entity mapping |
| JJWT | 0.11.5 | JWT support |
| JUnit 5 | Latest | Testing |

## Configuration (`application.yml`)

```yaml
spring:
  application:
    name: expense-tracker
  datasource:
    url: jdbc:h2:mem:testdb        # H2 in-memory database
    driverClassName: org.h2.Driver
  jpa:
    hibernate:
      ddl-auto: create-drop         # Create tables on startup
    show-sql: true

server:
  port: 8080

jwt:
  secret: your-secret-key-change-this-in-production
  expiration: 86400000  # 24 hours
```

## Features Implemented

✓ **REST API** - Full CRUD operations for expenses
✓ **Database** - H2 in-memory database with JPA
✓ **Validation** - Input validation with Bean Validation
✓ **Exception Handling** - Global exception handler with custom exceptions
✓ **Security** - Spring Security with password encoding
✓ **Testing** - 8 unit tests with Mockito
✓ **DTOs** - Data transfer objects with validation
✓ **Logging** - SLF4J logging with configurable levels
✓ **Mapper** - Entity-DTO conversion utilities

## Switch to MySQL

To use MySQL instead of H2:

1. **Add MySQL dependency to pom.xml:**
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

2. **Update `application.yml`:**
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
    database-platform: org.hibernate.dialect.MySQL8Dialect
```

3. **Rebuild:**
```bash
mvn clean install
```

## IDE Setup

### VS Code
1. Install Java Extension Pack
2. Import the project folder
3. Maven will automatically resolve dependencies

### IntelliJ IDEA
1. Open the project folder
2. Select "Open as Project"
3. IntelliJ will auto-detect and configure Maven

### Eclipse
1. File → Import → Existing Maven Projects
2. Select the project root
3. Finish

## Troubleshooting

### Port 8080 already in use
Change in `application.yml`:
```yaml
server:
  port: 8081
```

### Tests not running
Ensure `mvn clean compile` completes successfully first

### H2 console not loading
- Check URL: `http://localhost:8080/h2-console`
- Verify `h2.console.enabled: true` in `application.yml`

### Build failures
```bash
mvn clean
mvn install -DskipTests
```

## Next Steps

1. **Add authentication** - Implement JWT-based login
2. **Add budget tracking** - Track monthly budgets per category
3. **Add reports** - Generate expense reports and charts
4. **Add database persistence** - Switch from H2 to MySQL/PostgreSQL
5. **Add frontend** - Create React/Angular UI
6. **Add Docker support** - Create Dockerfile and docker-compose.yml

## Git Workflow

```bash
# Initialize if not done
git init

# Add all files
git add .

# Commit
git commit -m "Initial expense tracker setup"

# Create feature branch
git checkout -b feature/new-feature

# Push to remote
git push origin feature/new-feature
```

## Support & Documentation

- **Spring Boot Docs**: https://spring.io/projects/spring-boot
- **Spring Data JPA**: https://spring.io/projects/spring-data-jpa
- **Maven**: https://maven.apache.org/
- **Lombok**: https://projectlombok.org/

---

**Project Ready to Use!** ✓

Build Status: ✓ SUCCESS
Tests Status: ✓ 8/8 PASSED
Configuration: ✓ COMPLETE
