package Test;

import Pages.WelcomePage;
import Utils.LoadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public LoadProperties properties;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        properties = new LoadProperties();
    }

    @BeforeMethod
    public void testSetup(){
        driver.get(properties.getProperty("url"));
        WelcomePage onWelcomePage = new WelcomePage(driver);
        onWelcomePage.acceptDisclaimerAndAdvertisement();
    }

    @AfterMethod
    public void testTearDown(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
