package Test;

import Pages.LandingPage;
import Pages.ResultsPage;
import Pages.WelcomePage;


import Utils.LoadDataProvider;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class SearchTest extends BaseTest{

    @DataProvider(name = "dp")
    public Object[][] dataProvider(Method method){
        LoadDataProvider data = new LoadDataProvider();
        return data.readXMLFile(method.getName());
    }

    @Test(dataProvider = "dp")
    public void correctSearch(String productName, String errorMessage){

        LandingPage onLandingPage = new LandingPage(driver);
        ResultsPage onResultsPage = onLandingPage.searchProduct(productName);

        Assert.assertTrue(onResultsPage.validateResultsMatchesWithTheSearchCriteria(productName),errorMessage);
    }

    @Test(dataProvider = "dp")
    public void noResultSearch(String productName, String errorMessage){
        LandingPage onLandingPage = new LandingPage(driver);
        ResultsPage onResultsPage = onLandingPage.searchProduct(productName);

        Assert.assertTrue(onResultsPage.noFoundResultsDisplayed(), errorMessage);
    }

}
