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

    // Locators
    private final By facebookIcon = By.xpath("//footer//a[contains(@href,'facebook')]");
    private final By xIcon = By.xpath("//footer//a[contains(@href,'x')]");
    private final By linkedinIcon = By.xpath("//footer//a[contains(@href,'linkedin')]");

    // Constructor
    public P05_SocialPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Generic click method
    private void clickSocialIcon(By locator) {

        WebElement icon = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", icon);

        wait.until(ExpectedConditions.visibilityOf(icon));

        js.executeScript("arguments[0].click();", icon);
    }

    // Generic URL validation
    public boolean isUrlContains(String expectedUrl) {
        return driver.getCurrentUrl().contains(expectedUrl);
    }

    // Switch tab
    public void switchToNewTab() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }

    // Public actions
    public void clickFacebookIcon() {
        clickSocialIcon(facebookIcon);
    }

    public void clickXIcon() {
        clickSocialIcon(xIcon);
    }

    public void clickLinkedinIcon() {
        clickSocialIcon(linkedinIcon);
    }

}
