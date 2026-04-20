package Test;

//Test Case #1: Search with a valid keyword
//•	Locate the search input field from the side menu or header
//” كيف تنضم إلى البنكkeyword:” Enter  •
//•	Click Search
//•	Assert The page title contains “البنك إلى تنضم كيف”

import Base.BaseTest;
import Pages.P01_HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test
    public void SearchTest()
    {
        P01_HomePage homePage = new P01_HomePage(driver);
        //search method
        homePage.search("كيف تنضم إلى البنك");
        //Assertion
        boolean actual = homePage.isHeaderDisplayed();
        Assert.assertTrue(actual);
    }

}
