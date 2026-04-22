package Test;

import Base.BaseTest;
import Pages.P02_CoursesPage;
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
    @Test
    public void CoursesTest() {
        //instantiation
        coursesPage = new P02_CoursesPage(driver);
        //select course
        coursesPage.selectCourse();
        //assert that the about section is displayed
        Assert.assertTrue(coursesPage.isAboutSectionDisplayed(), "The about section is not displayed!");
    }
}
