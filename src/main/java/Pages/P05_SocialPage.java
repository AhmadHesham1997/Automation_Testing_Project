package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//Test Case #8: Verify Facebook link
//•	Scroll to the footer
//•	Click on the Facebook icon
//•	Assert URL contains facebook.com
public class P05_SocialPage {
    WebDriver driver;
    WebDriverWait wait;

    //Locators
    final private By facebookIcon = By.xpath("//footer//a[contains(@href,'facebook')]");
    final private By twitterIcon = By.xpath("//footer//a[contains(@href,'twitter')]");
    final private By linkedinIcon = By.xpath("//footer//a[contains(@href,'linkedin')]");

    //construct
    public P05_SocialPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    //Method to click on Facebook icon
    // Method to scroll + click Facebook icon
    public void clickFacebookIcon() {

        WebElement facebook = wait.until(
                ExpectedConditions.presenceOfElementLocated(facebookIcon)
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", facebook);

        wait.until(ExpectedConditions.visibilityOf(facebook));

        js.executeScript("arguments[0].click();", facebook);
    }
    //Switch tab
    public void switchToNewTab() {

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }
    //Assertion
    public boolean isFacebookUrlCorrect() {
        return driver.getCurrentUrl().contains("facebook.com");
    }

}
