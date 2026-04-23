package Test;

import Base.BaseTest;
import Pages.P05_SocialPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

//Test Case #8: Verify Facebook link
//•	Scroll to the footer
//•	Click on the Facebook icon
//•	Assert URL contains facebook.com
public class SocialLinksTest extends BaseTest {
    //initialization
    P05_SocialPage socialPage;

    @Test
    @Feature("Social Links Test")
    @Epic("Test Case #8: Verify Social Media Links")
    @Description("This test case verifies that clicking on the social media icons in the footer navigates to the correct social media pages and the URLs contain the expected domain names.")
    @Severity(SeverityLevel.MINOR)
    @Owner("Ahmad Hesham")
    @Step("1-open E youth website 2-Scroll to the footer 3-Click on the Facebook icon 4-Assert URL contains facebook.com")
    //Test Method
    public void facebookLinksTest(){
        //creating object from social page to use its methods
        socialPage = new P05_SocialPage(driver);
        //clicking on facebook icon
        socialPage.clickFacebookIcon();
        //switching to facebook tab
        socialPage.switchToNewTab();
        //Assertion
        Assert.assertTrue(
                socialPage.isUrlContains("facebook.com"),
                "Facebook URL is incorrect"
        );
        Allure.step("1-open E youth website 2-Scroll to the footer 3-Click on the Facebook icon 4-Assert URL contains facebook.com");
    }

    @Test
    @Feature("Social Links Test")
    @Epic("Test Case #8: Verify Social Media Links")
    @Description("This test case verifies that clicking on the social media icons in the footer navigates to the correct social media pages and the URLs contain the expected domain names.")
    @Severity(SeverityLevel.MINOR)
    @Owner("Ahmad Hesham")
    @Step("1-open E youth website 2-Scroll to the footer 3-Click on the X icon 4-Assert URL contains x.com")
    //Test Method
    public void xLinksTest(){
        //creating object from social page to use its methods
        socialPage = new P05_SocialPage(driver);
        //clicking on x icon
        socialPage.clickXIcon();
        //switching to x tab
        socialPage.switchToNewTab();
        //Assertion
        Assert.assertTrue(
                socialPage.isUrlContains("x.com"),
                "X URL is incorrect"
        );
        Allure.step("1-open E youth website 2-Scroll to the footer 3-Click on the X icon 4-Assert URL contains x.com");
    }

    @Test
    @Feature("Social Links Test")
    @Epic("Test Case #8: Verify Social Media Links")
    @Description("This test case verifies that clicking on the social media icons in the footer navigates to the correct social media pages and the URLs contain the expected domain names.")
    @Severity(SeverityLevel.MINOR)
    @Owner("Ahmad Hesham")
    @Step("1-open E youth website 2-Scroll to the footer 3-Click on the LinkedIn icon 4-Assert URL contains linkedin.com")
    //Test Method
    public void linkedinLinksTest(){
        //creating object from social page to use its methods
        socialPage = new P05_SocialPage(driver);
        //clicking on LinkedIn icon
        socialPage.clickLinkedinIcon();
        //switching to LinkedIn tab
        socialPage.switchToNewTab();
        //Assertion
        Assert.assertTrue(
                socialPage.isUrlContains("linkedin.com"),
                "LinkedIn URL is incorrect"
        );
        Allure.step("1-open E youth website 2-Scroll to the footer 3-Click on the LinkedIn icon 4-Assert URL contains linkedin.com");
    }

}
