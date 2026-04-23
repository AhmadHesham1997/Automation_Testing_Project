# Test Execution Guide

This project contains automated tests for the eYouth Learning website. You can run all tests using either of the following methods:

## ⚠️ IMPORTANT: JDK Requirement

**Current Issue:** The project requires Java 11+ (JDK 11 or higher) but the system currently has Java 8.

**Solution:** Install JDK 11 or higher and update your JAVA_HOME environment variable.

### Installing JDK:
1. Download JDK 11+ from: https://adoptium.net/temurin/releases/
2. Install JDK
3. Set JAVA_HOME environment variable to JDK installation path
4. Add JDK/bin to PATH

## Method 1: Using TestNG XML File (Recommended)

### Via Maven Command Line:
```bash
mvn clean test
```
This will automatically use the `testng.xml` file in the project root.

### Via IDE:
- Right-click on `testng.xml` file
- Select "Run" or "Run testng.xml"

## Method 2: Using TestRunner Class

### Via IDE:
- Right-click on `TestRunner.java` class
- Select "Run TestRunner.main()"

### Via Command Line:
```bash
mvn exec:java -Dexec.mainClass="Test.TestRunner" -Dexec.classpathScope=test
```

## Test Configuration

### Parallel Execution:
- Tests run in parallel at method level
- Thread count: 3

### Included Test Classes:
1. **CoursesTest** - Course-related functionality tests
2. **LoginPageTest** - Login page validation tests
3. **RegestirationPageTest** - Registration page tests
4. **SearchTest** - Search functionality tests
5. **SignupPageRoutingTest** - Signup routing tests
6. **SocialLinksTest** - Social media links tests

### Base Setup:
- All tests extend `BaseTest` class
- Browser: Chrome (headless mode can be configured)
- Base URL: https://eyouthlearning.com/ar
- Implicit wait: 15 seconds

## Reporting

### 📊 Allure Reports (Recommended)

Allure provides beautiful, interactive test reports with detailed insights.

#### Generate Allure Report:
```bash
# One-command: Run tests and generate report
mvn clean test allure:report

# Or separate steps:
mvn clean test        # Run tests (generates results)
mvn allure:report     # Generate HTML report
```

#### View Allure Report:
```bash
# Serve report in browser (recommended)
mvn allure:serve

# Or open static HTML file:
# Open: target/site/allure-maven-plugin/index.html
```

#### Allure Report Features:
- ✅ **Test Timeline** - Execution timeline with duration
- ✅ **Step Details** - Detailed step-by-step execution
- ✅ **Screenshots** - Automatic screenshot capture on failures
- ✅ **Categories** - Test categorization and filtering
- ✅ **History** - Test execution trends
- ✅ **Environment** - System and browser information

#### Report Locations:
- **Results Data**: `target/allure-results/`
- **HTML Report**: `target/site/allure-maven-plugin/`

### 📁 Downloadable HTML Report:
```bash
# After JDK installation, generate HTML file:
mvn clean test allure:report

# HTML file location:
target/site/allure-maven-plugin/index.html
```
- **Self-contained** - No external dependencies
- **Interactive** - Full dashboard functionality
- **Shareable** - Email, documentation, team sharing
- **Browser compatible** - Works in any modern browser

### TestNG Reports:
- Default TestNG HTML reports in `target/surefire-reports/`

## Troubleshooting

### Java Version Issues:
- Ensure JDK 11+ is installed
- Check JAVA_HOME points to JDK (not JRE)
- Run `java -version` and `javac -version` to verify

### Maven Issues:
- Ensure Maven is installed and in PATH
- Run `mvn -version` to verify Maven installation

### Browser Driver Issues:
- ChromeDriver is managed by WebDriverManager in BaseTest
- Ensure Chrome browser is installed
