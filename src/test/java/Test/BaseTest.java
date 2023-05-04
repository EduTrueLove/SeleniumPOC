package Test;

import Pages.WelcomePage;
import Utils.Driver;
import Utils.LoadProperties;
import Utils.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public LoadProperties properties;
    public ScreenShot sc;

    @BeforeClass
    public void setUp(){
        properties = new LoadProperties();
        driver = new Driver(properties.getProperty("driver")).getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sc = new ScreenShot(driver);
    }

    @BeforeMethod
    public void testSetup(){
        driver.get(properties.getProperty("url"));
        WelcomePage onWelcomePage = new WelcomePage(driver);
        onWelcomePage.acceptDisclaimerAndAdvertisement();
    }

    @AfterMethod(alwaysRun = true)
    public void testTearDown(ITestResult result){
        sc.takeScreenShot(result);
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
