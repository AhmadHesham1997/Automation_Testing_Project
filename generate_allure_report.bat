@echo off
echo ========================================
echo   Allure Report Generator
echo ========================================
echo.

echo Checking Java version...
java -version
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    pause
    exit /b 1
)
echo.

echo Checking Maven version...
mvn -version
if %errorlevel% neq 0 (
    echo ERROR: Maven is not installed or not in PATH
    pause
    exit /b 1
)
echo.

echo ========================================
echo   Step 1: Running Tests...
echo ========================================
mvn clean test
if %errorlevel% neq 0 (
    echo ERROR: Test execution failed
    pause
    exit /b 1
)
echo.

echo ========================================
echo   Step 2: Generating Allure Report...
echo ========================================
mvn allure:report
if %errorlevel% neq 0 (
    echo ERROR: Report generation failed
    pause
    exit /b 1
)
echo.

echo ========================================
echo   SUCCESS! Allure Report Generated
echo ========================================
echo.
echo 📁 DOWNLOADABLE HTML FILE LOCATION:
echo ========================================
echo target\site\allure-maven-plugin\index.html
echo ========================================
echo.
echo This HTML file contains:
echo ✅ Interactive test dashboard
echo ✅ Detailed test execution reports
echo ✅ Screenshots and attachments
echo ✅ Test timeline and statistics
echo ✅ Filterable test results
echo.
echo You can:
echo 📎 Attach this file to emails
echo 💾 Save it for documentation
echo 🌐 Open it in any web browser
echo 📊 Share with team members
echo.
pause
