package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//Test Case #4: Register with an empty username field
//•	Enter all data except the username field
//•	Click “انشاء”
//•	Assert validation error message are displayed “مطلوب المستخدم اسم”
public class P06_RegistrationPage {
    WebDriver driver;
    WebDriverWait wait;

    //Locators
    private final By signUpButton = By.xpath("//a[text()='حساب جديد']");
    private final By usernameField = By.id("name");
    private final By emailField = By.id("email");
    private final By countryDropdown = By.xpath("(//select[@aria-hidden='true'])[1]");
    private final By cityDropdown = By.xpath("(//select[@aria-hidden='true'])[2]");
    private final By genderDropdown = By.xpath("(//select[@aria-hidden='true'])[3]");
    private final By phoneNumberField = By.id("phone");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("confirm_password");
    private final By checkBox = By.id("terms");
   // private final By checkBox = By.xpath("//input[@type='checkbox']");
    private final By createButton = By.xpath("//button[@type='submit']");
    private final By validationErrorMessage = By.xpath("//p[contains(text(),'الاسم مطلوب')]");

    //constructor
    public P06_RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    //Method to click on signupButton
    public void clickSignUp() {
        WebElement signUpBtn = wait.until(
                ExpectedConditions.elementToBeClickable(signUpButton)
        );
        signUpBtn.click();
        wait.until(ExpectedConditions.urlContains("/auth/register"));
        //we didnt use driver.getwindowhandles because the signup page opens in the same tab it didnt switch to new tab,
        // so we just wait until the URL contains /auth/register to ensure that we are on the signup page
    }

    //Entering data fields method using parameters
    public void enterRegistrationData(String username, String email, String country, String city, String gender,  String phone, String password, String confirmPassword) {
        driver.findElement(usernameField).sendKeys(username);

        driver.findElement(emailField).sendKeys(email);

        WebElement countryDropdownElement = driver.findElement(countryDropdown);
        Select countrySelect = new Select(countryDropdownElement);
        countrySelect.selectByVisibleText(country);

        WebElement cityDropdownElement = driver.findElement(cityDropdown);
        Select citySelect = new Select(cityDropdownElement);
        citySelect.selectByVisibleText(city);

        WebElement genderDropdownElement = driver.findElement(genderDropdown);
        Select genderSelect = new Select(genderDropdownElement);
        genderSelect.selectByVisibleText(gender);

        driver.findElement(phoneNumberField).sendKeys(phone);

        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }
    //Clicking terms and create button
    public void clickCreateButton() {
        driver.findElement(checkBox).click();
        WebElement createBtn = wait.until(
                ExpectedConditions.elementToBeClickable(createButton)
        );
        createBtn.click();
    }

    //Assert that the validation error message is displayed when username field is empty
    public boolean isValidationErrorMessageDisplayed() {
        return driver.findElement(validationErrorMessage).isDisplayed();
    }

}
