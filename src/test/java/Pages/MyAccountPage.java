package Pages;

import Utils.DataFactory.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static net.andreinc.mockneat.types.enums.NameType.FIRST_NAME_FEMALE;

public class MyAccountPage extends BasePage{

    private User user;

    @FindBy(name = "username")
    public WebElement emailLogInTextField;
    @FindBy(name = "password")
    public WebElement passwordLogInTextField;
    @FindBy(css = ".woocommerce-error")
    public WebElement invalidCredentialsLabel;
    @FindBy(name = "login")
    public WebElement logInButton;
    @FindBy(id = "reg_billing_first_name")
    public WebElement nameToBeRegisteredTextField;
    @FindBy(id = "reg_billing_last_name")
    public WebElement lastNameToBeRegisteredTextField;
    @FindBy(id = "reg_email")
    public WebElement emailToBeRegisteredTextField;
    @FindBy(css = "button[value='Registrarse']")
    public WebElement registerButton;


    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        user = new User();
    }

    public MyAccountPage loginWithInvalidCredentials(String email, String password){
        emailLogInTextField.sendKeys(email);
        passwordLogInTextField.sendKeys(password);
        logInButton.click();
        return PageFactory.initElements(driver, MyAccountPage.class);
    }

    public UserPage loginWithCredentials(String email, String password){
        emailLogInTextField.sendKeys(email);
        passwordLogInTextField.sendKeys(password);
        logInButton.click();
        return PageFactory.initElements(driver, UserPage.class);
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

    public UserPage tryToRegisterUser(){
        nameToBeRegisteredTextField.sendKeys(user.getName());
        lastNameToBeRegisteredTextField.sendKeys(user.getLastName());
        emailToBeRegisteredTextField.sendKeys(user.getEmail());
        registerButton.click();
        return PageFactory.initElements(driver,UserPage.class);
    }
}
