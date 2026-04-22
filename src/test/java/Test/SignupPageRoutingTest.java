package Test;

import Base.BaseTest;
import Pages.P04_SignupPageRouting;
import org.testng.Assert;
import org.testng.annotations.Test;

//Test Case #3: Open registration page
//•	Click on “لنا انضم”
//•	Assert the URL contains /signup
public class SignupPageRoutingTest extends BaseTest {
    P04_SignupPageRouting signupPage;

    @Test
    public void testOpenRegistrationPage() {
        //instantiation
        signupPage = new P04_SignupPageRouting(driver);
        //click on signup button
        signupPage.clickSignUp();
        //assert that the URL contains /signup
       Assert.assertEquals(signupPage.isSignUpPage(), true, "The URL does not contain /signup!");
    }
}
