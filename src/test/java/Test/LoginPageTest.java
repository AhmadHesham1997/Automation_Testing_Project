package Test;

import Base.BaseTest;
import Pages.P03_LoginPage;
import Util.DataDriven;
import io.qameta.allure.*;
import org.testng.Assert;
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
    //initialization
    P03_LoginPage loginPage;

    @Test(dataProvider = "invalidLoginData", dataProviderClass = DataDriven.class)
    @Feature("Login Page Tests")
    @Epic("Test Case #5: Login with invalid credentials and Test Case #6: Login with empty fields")
    @Description("This test case verifies that when a user attempts to log in with invalid credentials or leaves the username and password fields empty, appropriate error messages are displayed.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ahmad Hesham")
    @Step("1-Open E Youth website 2-Open the login page 3-Enter invalid username and password or leave fields empty " +
            "4-Click Login 5-Assert error message is displayed 6-Leave username and password empty " +
            "7-Click Login 8-Assert that the required fields' validation messages appear")
    //Testing Method
    public void testInvalidLogin(String email, String password,String scenario) {
        //instantiation
        loginPage = new P03_LoginPage(driver);
        //click on login button from home page to open login page
        loginPage.clickLoginButtonHomePage();
        //enter login credentials
        loginPage.enterLoginData(email, password);
        //click on login button to attempt login
        loginPage.clickLoginButton();
        //Assertion
        switch (scenario) {

            case "invalidCredentials":
                Assert.assertTrue(
                        loginPage.isInvalidCredentialsMessageDisplayed(),
                        "Invalid credentials message should appear"
                );
                break;

            case "emptyPasswordAndEmail":
                Assert.assertTrue(
                        loginPage.isEmptyPasswordErrorDisplayed(),
                        "Empty password validation should appear"
                );
                Assert.assertTrue(
                        loginPage.isEmptyEmailErrorDisplayed(),
                        "Empty email validation should appear"
                );
                break;

            default:
                Assert.fail("Unknown scenario: " + scenario);
        }

        Allure.step("1-Open E Youth website 2-Open the login page 3-Enter invalid username and password or leave fields empty \" +\n" +
                "            \"4-Click Login 5-Assert error message is displayed 6-Leave username and password empty \" +\n" +
                "            \"7-Click Login 8-Assert that the required fields' validation messages appear");
    }
}

