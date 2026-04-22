package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//Test Case #4: Register with an empty username field
//•	Enter all data except the username field
//•	Click “انشاء”
//•	Assert validation error message are displayed “مطلوب المستخدم اسم”
public class P06_RegistrationPage {
    WebDriver driver;
    WebDriverWait wait;

    //Locators


    //constructor
    public P06_RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }
}
