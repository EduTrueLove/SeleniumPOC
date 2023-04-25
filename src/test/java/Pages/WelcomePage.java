package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WelcomePage extends BasePage{


    @FindBy(xpath = "//img[@alt='Cerrar']")
    public WebElement closeAdvertisement;

    @FindBy(xpath = "//button[@class='yes']")
    public WebElement acceptDisclamer;

    public WelcomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void acceptDisclaimerAndAdvertisement(){
        waitUntilElementBeClickeable(closeAdvertisement);
        closeAdvertisement.click();
        acceptDisclamer.click();
    }

}
