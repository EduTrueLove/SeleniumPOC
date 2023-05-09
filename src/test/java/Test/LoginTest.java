package Test;

import Pages.LandingPage;
import Pages.MyAccountPage;
import Pages.UserPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void invalidCredentialsTest(){
        LandingPage onLandingPage = new LandingPage(driver);
        MyAccountPage onMyAccountPage =  onLandingPage.goToMyAccount().loginWithInvalidCredentials("test@test.com","Pass1234");

        Assert.assertTrue(onMyAccountPage.invalidCredentialsMessageDisplayed(),"The corresponding error message is not displayed");
    }

    @Test
    public void validLogin(){
        LandingPage onLandingPage = new LandingPage(driver);
        UserPage onUserPage = onLandingPage.goToMyAccount().loginWithCredentials(properties.getProperty("email"), properties.getProperty("password"));

        Assert.assertTrue(onUserPage.userPanelDisplayed(), "Unable to login successfully");
    }

}
