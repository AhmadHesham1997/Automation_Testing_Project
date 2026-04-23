package Test;

import Base.BaseTest;
import Pages.P05_SocialPage;
import org.testng.Assert;
import org.testng.annotations.Test;

//Test Case #8: Verify Facebook link
//•	Scroll to the footer
//•	Click on the Facebook icon
//•	Assert URL contains facebook.com
public class SocialLinksTest extends BaseTest {
    P05_SocialPage socialPage;

    @Test
    public void facebookLinksTest(){
        socialPage = new P05_SocialPage(driver);
        socialPage.clickFacebookIcon();
        socialPage.switchToNewTab();

        Assert.assertTrue(
                socialPage.isFacebookUrlCorrect(),
                "Facebook URL is incorrect"
        );
    }


}
