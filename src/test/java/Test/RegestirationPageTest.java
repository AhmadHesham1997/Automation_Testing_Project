package Test;
//Test Case #4: Register with an empty username field
//•	Enter all data except the username field
//•	Click “انشاء”
//•	Assert validation error message are displayed “مطلوب المستخدم اسم”
import Base.BaseTest;
import Pages.P06_RegistrationPage;
import org.testng.annotations.Test;

public class RegestirationPageTest extends BaseTest {
    P06_RegistrationPage registrationPage;

    @Test
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
        boolean actual = registrationPage.isValidationErrorMessageDisplayed();
        assert actual : "Validation error message is not displayed!";
    }


}
