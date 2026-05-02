package Test;

import Base.BaseTest;
import Pages.P02_CoursesPage;
import Pages.P03_LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoursesTest extends BaseTest {
    //Test Case #2: Open course details
    //•	From the side menu or header, select all courses “الدورات جميع”
    //•	From the Courses page, select any course
    //•	Click on the course card
    //•	Assert the course details page opens
    //•	Assert the section “التدريبية الدورة حول” is displayed
    P02_CoursesPage coursesPage;
    P03_LoginPage  loginPage;
    @Test
    @Feature("Courses Page Tests")
    @Epic("Test Case #2: Open course details")
    @Description("This test case verifies that when a user selects a course from the Courses page, the course details page opens and the 'About the course' section is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Ahmad Hesham")
    @Step("1-From the side menu or header, select all courses 2-From the Courses page, select any course 3-Click on the course card 4-Assert the course details page opens 5-Assert the section 'About the course' is displayed")
    //Testing Method
    public void CoursesDetailsTest() {
        //instantiation
        coursesPage = new P02_CoursesPage(driver);
        //Clicking pm dropdown menu
        coursesPage.gettingCourses();
       //select course
        coursesPage.selectCourse();
        //assert that the about section is displayed
        Assert.assertTrue(coursesPage.isAboutSectionDisplayed(), "The about section is not displayed!");
        Allure.step("1-From the side menu or header, select all courses 2-From the Courses page, select any course 3-Click on the course card 4-Assert the course details page opens 5-Assert the section 'About the course' is displayed");
    }

    /***********************************************/
    //Test Case #7: end-to-end
    //•	log in to the website
    //•	From the side menu or header, click all courses
    //•	Subscribe to any course
    //•	Assert that your card will contain the selected course
    //Note that:
    //-	The user must be logged in with valid credentials
    //-	Data can be hardcoded or read from config

    @Test
    @Feature("Courses Page Tests")
    @Epic("Test Case #7: End-to-end test for course subscription")
    @Description("This test case verifies the end-to-end flow of logging in, navigating to the Courses page, subscribing to a course, and confirming that the course is added to the user's card.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ahmad Hesham")
    @Step("1-Log in to the website with valid credentials 2-From the side menu or header, click all courses 3-Subscribe to any course 4-Assert that your card will contain the selected course")
    //Testing Method
    public void EndToEndTest() {
        // Test implementation for end-to-end test case
        //click on login button in homepage
        loginPage = new P03_LoginPage(driver);
        coursesPage = new P02_CoursesPage(driver);

        loginPage.clickLoginButtonHomePage();
        //Enter login credentials
        loginPage.enterLoginData("test2005@qa.team", "Password123*");
        //click on login button
        loginPage.clickLoginButton();
        //Click on drop down menu to get all courses
        coursesPage.gettingCourses();
        //select course
        coursesPage.selectCourse();
        //Subscribe to course
        coursesPage.clickSubscribeButton();
        //Assertion
        Assert.assertTrue(coursesPage.isCourseInMyCard(), "The course is not in the user's card!");
        Allure.step("1-Log in to the website with valid credentials 2-From the side menu or header, click all courses 3-Subscribe to any course 4-Assert that your card will contain the selected course");
    }

    /******************************************************************/
    //Test Case #11: Verify course cards UI
    //•	Open Courses page
    //•	Assert that the course card contains (only one card):
    //o	Course image
    //o	Course title
    //o	Instructor name
    //o	subscribe button

     @Test
     @Feature("Courses Page Tests")
     @Epic("Test Case #11: Verify course cards UI")
     @Description("This test case verifies that the course card on the Courses page contains the expected UI elements, including the course image, course title, instructor name, and subscribe button.")
     @Severity(SeverityLevel.MINOR)
     @Owner("Ahmad Hesham")
     @Step("1-Open Courses page 2-Assert that the course card contains course image, course title, instructor name, and subscribe button")
//Testin Method
    public void verifyCourseCardUI() {
         // Test implementation for verifying course card UI elements
         coursesPage = new P02_CoursesPage(driver);
         // Step 1: Navigate to Courses page by clicking the dropdown menu
         coursesPage.gettingCourses();
         // Step 2: Assert that the course card UI elements are displayed
         Assert.assertTrue(coursesPage.isCourseCardUIElementsDisplayed(),
             "One or more course card UI elements are not displayed! Expected: Course image, Course title, Instructor name, and Subscribe button");
         Allure.step("1-Open Courses page 2-Assert that the course card contains course image, course title, instructor name, and subscribe button");
     }
}
