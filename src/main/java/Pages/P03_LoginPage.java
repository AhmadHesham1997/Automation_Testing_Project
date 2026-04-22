package Pages;
//Test Case #5: Login with invalid credentials
//•	Open the login page
//•	Enter an invalid username and password
//•	Click Login
//•	Assert error message is displayed
//Test Case #6: Login with empty fields
//•	Leave username and password empty
//•	Click Login
//•	Assert that the required fields' validation messages appear

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class P03_LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    //Locators
    private final By loginButonHomePage = By.xpath("//a[text()='تسجيل الدخول']");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By invalidCredentialsMessage = By.xpath("//p[contains(text(),'لم يتم العثور على حساب نشط للبيانات المقدمة')]");
    private final By emptyPasswordErrorMessage = By.xpath("//p[contains(text(),'كلمة المرور مطلوبة')]");
    private final By emptyEmailErrorMessage = By.xpath("//p[contains(text(),'البريد الإلكتروني مطلوب')]");

    //constructor
    public P03_LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(100));
    }
    //Method to click on login button in home page
    public void clickLogin() {
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(loginButonHomePage)
        );
        loginBtn.click();
      wait.until(ExpectedConditions.urlContains("/auth/login"));
    }
    //Method to enter email and password using parameters
    public void enterLoginData(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }
    //Method to click on login Button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isInvalidCredentialsMessageDisplayed() {
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(invalidCredentialsMessage)
        );

       return errorMessage.isDisplayed();
    }
    public boolean isEmptyPasswordErrorDisplayed() {
       return driver.findElement(emptyPasswordErrorMessage).isDisplayed();
    }
    public boolean isEmptyEmailErrorDisplayed() {
        return driver.findElement(emptyEmailErrorMessage).isDisplayed();
    }




}
