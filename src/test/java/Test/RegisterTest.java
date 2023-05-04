package Test;

import Pages.LandingPage;
import Pages.MyAccountPage;
import Pages.UserPage;
import Utils.ScreenShot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Test
    public void userRegisteredSuccessfully(){
        LandingPage onLandingPage = new LandingPage(driver);
        onLandingPage.goToMyAccount();

        MyAccountPage onMyAccountPage = new MyAccountPage(driver);
        onMyAccountPage.tryToRegisterUser();

        UserPage onUserPage = new UserPage(driver);
        Assert.assertTrue(onUserPage.userPanelDisplayed(), "Unable to be registered successfully");
    }

}
