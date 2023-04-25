package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage{

    @FindBy(name = "username")
    public WebElement emailLogInTextField;

    @FindBy(name = "password")
    public WebElement passwordLogInTextField;

    @FindBy(css = ".woocommerce-error")
    public WebElement invalidCredentialsLabel;

    @FindBy(name = "login")
    public WebElement logInButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void loginWithCredentials(String email, String password){
        emailLogInTextField.sendKeys(email);
        passwordLogInTextField.sendKeys(password);
        logInButton.click();
    }

    public boolean invalidCredentialsMessageDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOf(invalidCredentialsLabel));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
