package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    //This class is for putting common methods related to setup and tear down of the project
    //intialize webdriver
    WebDriver driver;
    @BeforeMethod
     public void setUp() {
        //code to initialize the webdriver and open the browser
         driver = new ChromeDriver();
         //maximize the window
         driver.manage().window().maximize();
         //go to website
         driver.get("https://eyouthlearning.com/ar");
    }

    //tear down
    @AfterMethod
     public void tearDown() {
        //code to close the browser
         driver.quit();
    }



}
