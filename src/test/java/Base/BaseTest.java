package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    //This class is for putting common methods related to setup and tear down of the project
    //intialize webdriver
   public WebDriver driver;
    @BeforeMethod
     public void setUp() {
        //code to initialize the webdriver and open the browser
         driver = new ChromeDriver();
         //maximize the window
         driver.manage().window().maximize();
         //go to website
         driver.get("https://eyouthlearning.com/ar");
         //wait method
        waitForPageLoad();
    }
    //Wait until page to fully load
    public void waitForPageLoad() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    //tear down
    @AfterMethod
     public void tearDown() {
        //code to close the browser
         driver.quit();
    }



}
