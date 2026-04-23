package Test;
//Test Case #4: Register with an empty username field
//•	Enter all data except the username field
//•	Click “انشاء”
//•	Assert validation error message are displayed “مطلوب المستخدم اسم”
import Base.BaseTest;
import Pages.P06_RegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {
    //initialize registration page object
    P06_RegistrationPage registrationPage;

    @Test
    @Feature("Registration Page Test")
    @Epic("Test Case #4: Register with an empty username field")
    @Description("This test case verifies that when the username field is left empty during registration, a validation error message is displayed indicating that the username is required.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ahmad Hesham")
    @Step("1-Open E youth website 2-Enter all data except the username field 3-Click on the create button 4-Assert that the validation error message is displayed")
    //Test Method
    public void testRegistrationPage()
    {    registrationPage = new P06_RegistrationPage(driver);
        //click signup button to navigate to registration page
        registrationPage.clickSignUp();
        //Entering data fields except the username field
        registrationPage.enterRegistrationData("", "test@example.com", "مصر", "القاهرة", "ذكر","123456789", "Password123*", "Password123*");
        //click create button
        registrationPage.clickCreateButton();
        //Assert that the validation error message is displayed when username field is empty
        Assert.assertTrue(registrationPage.isValidationErrorMessageDisplayed(), "Validation error message should be displayed when username field is empty");
        Allure.step("1-Open E youth website 2-Enter all data except the username field 3-Click on the create button 4-Assert that the validation error message is displayed");
    }
}
