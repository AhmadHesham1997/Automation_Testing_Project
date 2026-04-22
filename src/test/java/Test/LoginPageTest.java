package Test;

import Base.BaseTest;
import Pages.P03_LoginPage;
import Util.DataDriven;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Test Case #5: Login with invalid credentials
//•	Open the login page
//•	Enter an invalid username and password
//•	Click Login
//•	Assert error message is displayed
//Test Case #6: Login with empty fields
//•	Leave username and password empty
//•	Click Login
//•	Assert that the required fields' validation messages appear
public class LoginPageTest extends BaseTest {
    P03_LoginPage loginPage;

    @Test(dataProvider = "invalidLoginData", dataProviderClass = DataDriven.class)
    public void testInvalidLogin(String email, String password,String scenario) {
        loginPage = new P03_LoginPage(driver);
        loginPage.clickLogin();
        loginPage.enterLoginData(email, password);
        loginPage.clickLoginButton();
        switch (scenario) {

            case "invalidCredentials":
                Assert.assertTrue(
                        loginPage.isInvalidCredentialsMessageDisplayed(),
                        "Invalid credentials message should appear"
                );
                break;

            case "emptyPassword":
                Assert.assertTrue(
                        loginPage.isEmptyPasswordErrorDisplayed(),
                        "Empty password validation should appear"
                );
                break;

            default:
                Assert.fail("Unknown scenario: " + scenario);
        }
    }
}

