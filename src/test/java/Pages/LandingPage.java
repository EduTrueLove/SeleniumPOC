package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage{


    @FindBy(xpath = "(//div[@id='mini-cart']/following-sibling::div//i)[1]")
    public WebElement searchIcon;
    @FindBy(xpath = "(//input[@name='s'])[1]")
    public WebElement searchBar;
    @FindBy(xpath = "(//div[@id='mini-cart']/following-sibling::div//i)[2]")
    public WebElement seachIconBar;


    public LandingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void searchProduct(String product){
        searchIcon.click();
        searchBar.sendKeys(product);
        seachIconBar.click();
    }

    public void searchProductDos(String product){
        searchIcon.click();
        searchBar.sendKeys(product);
        seachIconBar.click();
    }


}
