package Test;

import Base.BaseTest;
import Pages.P02_CoursesPage;
import Pages.P03_LoginPage;
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
    public void CoursesDetailsTest() {
        //instantiation
        coursesPage = new P02_CoursesPage(driver);
        //Clicking pm dropdown menu
        coursesPage.gettingCourses();
       //select course
        coursesPage.selectCourse();
        //assert that the about section is displayed
        Assert.assertTrue(coursesPage.isAboutSectionDisplayed(), "The about section is not displayed!");
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
    }

}
