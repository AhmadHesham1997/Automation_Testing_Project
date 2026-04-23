package Test;

import Base.BaseTest;
import Pages.P04_SignupPageRouting;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

//Test Case #3: Open registration page
//•	Click on “لنا انضم”
//•	Assert the URL contains /signup
public class SignupPageRoutingTest extends BaseTest {
    //initialization
    P04_SignupPageRouting signupPage;

    @Test
    @Feature("Signup Page Routing")
    @Epic("Test Case #3: Open registration page")
    @Description("This test case verifies that clicking on the 'لنا انضم' button navigates to the signup page and the URL contains /signup.")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Ahmad Hesham")
    @Step("1-Open E Youth website 2-Click on join us 3-Assert that the URL contains /signup")
    //Test Method
    public void testOpenRegistrationPage() {
        //instantiation
        signupPage = new P04_SignupPageRouting(driver);
        //click on signup button
        signupPage.clickSignUp();
        //assert that the URL contains /signup
        Assert.assertTrue(signupPage.isSignUpPage(), "The URL does not contain /signup!");
        Allure.step("1-Open E Youth website 2-Click on join us 3-Assert that the URL contains /signup");
    }

}
