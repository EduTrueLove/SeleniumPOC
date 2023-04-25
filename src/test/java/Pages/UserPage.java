package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserPage extends BasePage{

    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']//p[1]")
    public WebElement welcomeUserMessageLabel;

    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean userPanelDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOf(welcomeUserMessageLabel));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
