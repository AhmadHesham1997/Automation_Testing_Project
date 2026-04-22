package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//Test Case #2: Open course details
//•	From the side menu or header, select all courses “الدورات جميع”
//•	From the Courses page, select any course
//•	Click on the course card
//•	Assert the course details page opens
//•	Assert the section “التدريبية الدورة حول” is displayed

public class P02_CoursesPage {
    WebDriver driver;
    WebDriverWait wait;

    //locators
    private final By dropDownTitle = By.xpath("//a[text()='الدورات التدريبية']");
    private final By courseTitle = By.xpath("//h3[text()='تحليل البيانات عبر Power BI']");
    private final By aboutSection = By.id("overview");

    //Constructor to initialize the WebDriver instance that will be passed from the test class (Features.F02_Courses)
    public P02_CoursesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void gettingCourses()
    {

        //driver.findElements(dropDownTitle).get(0).click();

        WebElement dropDown = wait.until(
                ExpectedConditions.elementToBeClickable(dropDownTitle)
        );
        dropDown.click();
    }

    public void selectCourse()
    {
        WebElement course = wait.until(
                ExpectedConditions.visibilityOfElementLocated(courseTitle)
        );
        course.click();
        //driver.findElement(courseTitle).click();
    }
    //Asserting the about section

    public boolean isAboutSectionDisplayed() {
        WebElement about = wait.until(
                ExpectedConditions.visibilityOfElementLocated(aboutSection)
        );
        return about.isDisplayed();
    }


}
