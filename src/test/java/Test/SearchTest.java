package Test;

//Test Case #1: Search with a valid keyword
//•	Locate the search input field from the side menu or header
//” كيف تنضم إلى البنكkeyword:” Enter  •
//•	Click Search
//•	Assert The page title contains “البنك إلى تنضم كيف”

import Base.BaseTest;
import Pages.P01_HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    //initialization
    P01_HomePage homePage;

        @Test
        @Feature("Search Functionality Test")
        @Epic("Test Case #1: Search with a valid keyword")
        @Description("This test case verifies that searching for a valid keyword returns relevant results and the page title contains the expected keyword.")
        @Severity(SeverityLevel.CRITICAL)
        @Owner("Ahmad Hesham")
        @Step("1-Open E youth website 2-Enter valid keyword in search field 3-Click Search 4-Assert page title contains the keyword")

        public void SearchTesting()
        {
            //Installation
            homePage = new P01_HomePage(driver);
            //search method
            homePage.search("كيف تنضم إلى البنك");
            //Assertion
            boolean actual = homePage.isHeaderDisplayed();
            Assert.assertTrue(actual);
            Allure.step("1-Open E youth website 2-Enter valid keyword in search field 3-Click Search 4-Assert page title contains the keyword");
        }

}
