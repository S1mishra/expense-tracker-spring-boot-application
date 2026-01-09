# Expense Tracker - Command Reference

## Maven Commands

### Build & Compile

#### Clean Build (Recommended)
```bash
mvn clean install
```
Cleans all previous builds and compiles everything fresh.

#### Build without Tests
```bash
mvn clean install -DskipTests
```
Faster build when you only need the JAR file.

#### Compile Only
```bash
mvn clean compile
```
Compiles the source code without running tests.

#### Package Only
```bash
mvn package
```
Creates the JAR file from compiled code.

---

### Testing

#### Run All Tests
```bash
mvn test
```
Runs all 8 unit tests in ExpenseServiceTest.

#### Run Specific Test
```bash
mvn -Dtest=ExpenseServiceTest test
```
Runs only the specified test class.

#### Run Specific Test Method
```bash
mvn -Dtest=ExpenseServiceTest#testGetAllExpenses test
```
Runs a single test method.

#### Skip Test Compilation
```bash
mvn test -DskipTests
```
Runs the application skipping test execution.

#### View Test Results
```bash
mvn surefire-report:report
```
Generates a detailed test report in `target/site/surefire-report.html`

---

### Running the Application

#### Start with Spring Boot Maven Plugin
```bash
mvn spring-boot:run
```
Runs the application directly. Starts on `http://localhost:8080`

#### Run JAR File Directly (After Build)
```bash
java -jar target/expense-tracker-1.0.0.jar
```
Runs the compiled JAR file.

#### Run with Custom Port
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```
Starts the application on a different port.

#### Run with Production Profile
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=prod"
```
Requires `application-prod.yml` configuration file.

---

### Dependency Management

#### Show Dependency Tree
```bash
mvn dependency:tree
```
Displays the complete dependency hierarchy.

#### Check Dependency Updates
```bash
mvn versions:display-dependency-updates
```
Lists available updates for all dependencies.

#### Download Dependencies
```bash
mvn dependency:resolve
```
Downloads all dependencies to local cache.

#### Analyze Unused Dependencies
```bash
mvn dependency:analyze
```
Identifies unused and undeclared dependencies.

---

### Debugging

#### Run with Debug Mode
```bash
mvn -X spring-boot:run
```
Displays detailed debug information during build.

#### Run Tests with Debug Output
```bash
mvn -X test
```
Shows detailed information during test execution.

#### Run Specific Goal with Debug
```bash
mvn -X package
```
Packages with verbose output.

---

### Code Quality & Analysis

#### Check Potential Issues
```bash
mvn clean verify
```
Runs all verification including tests and analysis.

#### Show Plugin Information
```bash
mvn help:describe -Dplugin=org.apache.maven.plugins:maven-compiler-plugin
```
Displays details about the compiler plugin.

---

### Database Operations

#### Generate Database Schema
```bash
mvn sql:execute
```
Note: Requires additional configuration.

#### H2 Console (via URL)
Once application is running:
```
http://localhost:8080/h2-console
```

JDBC URL: `jdbc:h2:mem:testdb`
Username: `sa`
Password: (leave blank)

---

## Git Commands

### Initialize & Setup

#### Initialize Repository
```bash
git init
```

#### Clone Repository
```bash
git clone <repository-url>
```

#### Configure User
```bash
git config user.name "Your Name"
git config user.email "your.email@example.com"
```

#### Global Configuration
```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```

---

### Basic Operations

#### Check Status
```bash
git status
```

#### Add Files
```bash
git add .
```
Add all files.

```bash
git add src/main/java/com/example/expensetracker/
```
Add specific directory.

#### Commit Changes
```bash
git commit -m "Initial project setup"
```

#### View Commit History
```bash
git log
```

#### View Changes
```bash
git diff
```

---

### Branching

#### List Branches
```bash
git branch
```

#### Create New Branch
```bash
git branch feature/new-feature
```

#### Switch Branch
```bash
git checkout feature/new-feature
```

#### Create and Switch
```bash
git checkout -b feature/new-feature
```

#### Delete Branch
```bash
git branch -d feature/new-feature
```

#### Merge Branch
```bash
git merge feature/new-feature
```

---

### Remote Operations

#### Add Remote Repository
```bash
git remote add origin <repository-url>
```

#### Push to Remote
```bash
git push origin main
```

#### Pull from Remote
```bash
git pull origin main
```

#### View Remote URLs
```bash
git remote -v
```

#### Remove Remote
```bash
git remote remove origin
```

---

## Java Commands

### Compilation & Execution

#### Compile Java File
```bash
javac src/main/java/com/example/expensetracker/model/Expense.java
```

#### Run Class
```bash
java -cp target/classes com.example.expensetracker.ExpenseTrackerApplication
```

#### Show Java Version
```bash
java -version
```

#### Show Installed JRE
```bash
java -version
```

---

## cURL Commands for API Testing

### Test Endpoints

#### Get All Expenses
```bash
curl -X GET http://localhost:8080/api/expenses \
  -H "Content-Type: application/json"
```

#### Get Specific Expense
```bash
curl -X GET http://localhost:8080/api/expenses/1 \
  -H "Content-Type: application/json"
```

#### Create Expense
```bash
curl -X POST http://localhost:8080/api/expenses \
  -H "Content-Type: application/json" \
  -d '{
    "description": "Lunch",
    "amount": 15.50,
    "category": "Food",
    "userId": "user1"
  }'
```

#### Update Expense
```bash
curl -X PUT http://localhost:8080/api/expenses/1 \
  -H "Content-Type: application/json" \
  -d '{
    "description": "Dinner",
    "amount": 25.00,
    "category": "Food"
  }'
```

#### Delete Expense
```bash
curl -X DELETE http://localhost:8080/api/expenses/1 \
  -H "Content-Type: application/json"
```

#### Get by User ID
```bash
curl -X GET http://localhost:8080/api/expenses/user/user1 \
  -H "Content-Type: application/json"
```

#### Get by Category
```bash
curl -X GET http://localhost:8080/api/expenses/category/Food \
  -H "Content-Type: application/json"
```

---

## IDE Shortcuts (VS Code)

### Useful Shortcuts

| Shortcut | Action |
|----------|--------|
| `Ctrl+Shift+P` | Command Palette |
| `Ctrl+Shift+M` | Show Problems |
| `Ctrl+K Ctrl+S` | Keyboard Shortcuts |
| `Ctrl+` (backtick) | Toggle Terminal |
| `Ctrl+B` | Toggle Sidebar |
| `F5` | Debug |
| `Ctrl+F5` | Run without Debug |

---

## Project Maintenance

### Regular Commands

#### Weekly Build Check
```bash
mvn clean install
```

#### Before Commit
```bash
mvn clean test
```

#### Before Deployment
```bash
mvn clean package
```

#### Check for Issues
```bash
mvn clean verify
```

---

## Docker Commands (For Future Use)

### Build Docker Image
```bash
docker build -t expense-tracker:latest .
```

### Run Container
```bash
docker run -p 8080:8080 expense-tracker:latest
```

### Stop Container
```bash
docker stop <container-id>
```

---

## Troubleshooting Commands

### Clear Maven Cache
```bash
rmdir /s /q C:\Users\DELL\.m2\repository
```
Then run `mvn clean install` to redownload all dependencies.

### Force Update Dependencies
```bash
mvn clean install -U
```

### Offline Mode (Use Cached Dependencies)
```bash
mvn install -o
```

### Verbose Output
```bash
mvn -e install
```

### Very Verbose Output
```bash
mvn -X install
```

---

## Performance Tips

### Parallel Build
```bash
mvn -T 1C clean install
```
Uses 1 thread per core (faster on multi-core systems).

### Skip Documentation Generation
```bash
mvn install -Dmaven.javadoc.skip=true
```

### Skip Tests (Not Recommended)
```bash
mvn install -DskipTests
```

---

## Useful Resources

- Maven Official: https://maven.apache.org/
- Spring Boot Docs: https://spring.io/projects/spring-boot
- Git Documentation: https://git-scm.com/doc
- Java Documentation: https://docs.oracle.com/javase/11/

---

## Quick Command Sequences

### New Development Cycle
```bash
git checkout -b feature/new-feature
mvn clean install
mvn test
# Make changes...
mvn clean test
git add .
git commit -m "Add new feature"
git push origin feature/new-feature
```

### Prepare for Deployment
```bash
mvn clean install
mvn test
mvn package
java -jar target/expense-tracker-1.0.0.jar
```

### Daily Development
```bash
git pull origin main
mvn clean test
# Write code...
mvn test
git add .
git commit -m "Update feature"
```

---

Last Updated: January 9, 2026
