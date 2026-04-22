package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Test Case #3: Open registration page
//•	Click on “لنا انضم”
//•	Assert the URL contains /signup
public class P04_SignupPageRouting {
    WebDriver driver;
    WebDriverWait wait;

    //locators
    private final By signUpButton = By.xpath("//a[text()='حساب جديد']");

    //constructor
    public P04_SignupPageRouting(WebDriver driver) {
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


    //Assertion method to verify that the URL contains /auth/register
    public boolean isSignUpPage() {
        return driver.getCurrentUrl().contains("/auth/register");
     }

}


