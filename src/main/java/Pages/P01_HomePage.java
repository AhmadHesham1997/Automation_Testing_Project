package Pages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_HomePage {
    WebDriver driver;
    WebDriverWait wait;

    //locators
    final private By searchField =  By.xpath("//input[@type='search']");
    final private By searchResult = By.xpath("//img[@alt=\"How to Join a Bank? / كيف تنضم إلى البنك؟\"]");
    final private By header = By.xpath("//h1[text()='كيف تنضم إلى البنك؟']");

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void search(String text) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchField));

        field.clear();
        field.sendKeys(text);

        WebElement result = wait.until(
                ExpectedConditions.elementToBeClickable(searchResult));

        result.click();
    }

    public boolean isHeaderDisplayed() {
        WebElement headerElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(header));

        return headerElement.isDisplayed();
    }
}
