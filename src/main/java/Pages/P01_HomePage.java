package Pages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage {
    WebDriver driver;

    //locators
    final private By searchField =  By.cssSelector("input[type='search']");

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }


}
