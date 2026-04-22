package Util;
//Test Case #5: Login with invalid credentials
//•	Open the login page
//•	Enter an invalid username and password
//•	Click Login
//•	Assert error message is displayed
//Test Case #6: Login with empty fields
//•	Leave username and password empty
//•	Click Login
//•	Assert that the required fields' validation messages appear

import org.testng.annotations.DataProvider;

public class DataDriven {
    @DataProvider(name = "invalidLoginData")
    public String[][] getInvalidLoginData() {
        String[][] data = {
                {"invalid@example.com", "invalidpassword", "invalidCredentials"},
               {"", "","emptyPasswordAndEmail"}};
        return data;
        };
    }


