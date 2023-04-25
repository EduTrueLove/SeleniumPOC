package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultsPage extends BasePage{


    @FindBy(xpath = "//h3[@class='woocommerce-loop-product__title']")
    public List<WebElement> resultTitleList;

    @FindBy(css = ".woocommerce-info")
    public WebElement noResultLabel;


    public ResultsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


      public Boolean validateResultsMatchesWithTheSearchCriteria(String product){
        Boolean results = true;

        for (WebElement x: resultTitleList){
            if (!x.getText().toLowerCase().contains(product)){
                results = false;
                break;
            }
        }
        return results;
    }

    public Boolean noFoundResultsDisplayed(){
        return isDisplayed(noResultLabel);
    }

}
