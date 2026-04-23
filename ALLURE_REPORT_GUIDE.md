# Allure Report Generation Guide

## 🚀 Quick Start (After JDK Installation)

### Step 1: Install JDK 11+
```bash
# Download from: https://adoptium.net/temurin/releases/
# Install JDK 17 or 21
# Set JAVA_HOME and PATH environment variables
```

### Step 2: Verify JDK Installation
```bash
java -version     # Should show JDK 11+
javac -version    # Should show JDK compiler
```

### Step 3: Run Tests & Generate Report
```bash
# Run all tests and generate Allure report
mvn clean test allure:report

# Or run in two separate steps:
mvn clean test                    # Generate test results
mvn allure:report                 # Generate HTML report
```

### Step 4: View Report
- Open: `target/site/allure-maven-plugin/index.html`
- Or serve report: `mvn allure:serve`

## 📊 Allure Report Features

Your project includes:
- ✅ **Allure TestNG Adapter** (v2.30.0)
- ✅ **AspectJ Weaver** for @Step processing
- ✅ **Results Directory**: `target/allure-results/`
- ✅ **HTML Reports**: `target/site/allure-maven-plugin/`

## 🎯 Test Classes Included
1. CoursesTest - Course functionality
2. LoginPageTest - Login validation
3. RegestirationPageTest - Registration
4. SearchTest - Search functionality
5. SignupPageRoutingTest - Signup routing
6. SocialLinksTest - Social media links

## 🔧 Alternative Approaches

### Option A: IDE Integration
1. Install JDK 11+ in your IDE
2. Right-click `testng.xml` → Run
3. Use IDE's Allure plugin to view reports

### Option B: Docker (If JDK Installation Fails)
```bash
# Use Maven with OpenJDK Docker image
docker run -it --rm -v $(pwd):/app -w /app maven:3.9.4-openjdk-17 mvn clean test allure:report
```

### Option C: CI/CD Pipeline
- Use GitHub Actions, Jenkins, or similar
- Configure JDK 17+ in pipeline
- Automatic report generation on each commit

## 📈 Report Contents
- Test execution timeline
- Step-by-step test details
- Screenshots and attachments
- Test categories and severity
- Historical trends
- Environment information

---
**Note**: Allure reports provide beautiful, interactive dashboards for test analysis and debugging.
