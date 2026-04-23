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
    private final By courseImg = By.xpath("//img[@alt='إدارة التغيير والعمل الجماعي']");
    private final By courseTitle = By.xpath("//h3[text()='إدارة التغيير والعمل الجماعي']");
    private final By instructorName = By.xpath("//h6[text()='ريمون عوض']");
    private final By subscribeButton = By.xpath("(//button[text()='اشترك الآن'])[3]");
    private final By aboutSection = By.id("overview");
    private final By myCardCourseTitle = By.xpath("//a[text()='إدارة التغيير والعمل الجماعي']");

    //Constructor to initialize the WebDriver instance that will be passed from the test class (Features.F02_Courses)
    public P02_CoursesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
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
                ExpectedConditions.elementToBeClickable(courseTitle)
        );
        course.click();
    }
    //Asserting the about section

    public boolean isAboutSectionDisplayed() {
        WebElement about = wait.until(
                ExpectedConditions.visibilityOfElementLocated(aboutSection)
        );
        return about.isDisplayed();
    }

    /******************************************************************************/
    //Test Case #7: end-to-end
    //•	log in to the website
    //•	From the side menu or header, click all courses
    //•	Subscribe to any course
    //•	Assert that your card will contain the selected course
    //Note that:
    //-	The user must be logged in with valid credentials
    //-	Data can be hardcoded or read from config


    //Clicking on subcribe button Method
    public void clickSubscribeButton() {
        WebElement subscribeBtn = wait.until(
                ExpectedConditions.elementToBeClickable(subscribeButton)
        );
       subscribeBtn.click();
    }
    //Asserting that my card contains the selected course by validating course title
    public boolean isCourseInMyCard() {
        WebElement courseInCard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(myCardCourseTitle)
        );
        return courseInCard.isDisplayed();
    }

    /************************************************************/
    //Test Case #11: Verify course cards UI
    //•	Open Courses page
    //•	Assert that the course card contains (only one card):
    //o	Course image
    //o	Course title
    //o	Instructor name
    //o	subscribe button

    public boolean isCourseCardUIElementsDisplayed() {
        WebElement courseImage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(courseImg)
        );
        WebElement courseTitleElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(courseTitle)
        );
        WebElement instructorNameElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(instructorName)
        );
        WebElement subscribeBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(subscribeButton)
        );

        return courseImage.isDisplayed() && courseTitleElement.isDisplayed() &&
                instructorNameElement.isDisplayed() && subscribeBtn.isDisplayed();
    }
}
