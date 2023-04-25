package Test;

import Pages.LandingPage;
import Pages.ResultsPage;
import Pages.WelcomePage;


import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest extends BaseTest{

    @Test
    public void correctSearch(){
        String product = "bong";

        // busqueda de un prodcuto
        LandingPage onLandingPage = new LandingPage(driver);
        onLandingPage.searchProduct(product);

        //validacion de que los productos encontrados coincidan con la busqueda
        ResultsPage onResultsPage = new ResultsPage(driver);
        Assert.assertTrue(onResultsPage.validateResultsMatchesWithTheSearchCriteria(product),"The products displayed do not match with the search criteria");
    }

    @Test
    public void noResultSearch(){
        String product = "mop";

        // busqueda de un prodcuto
        LandingPage onLandingPage = new LandingPage(driver);
        onLandingPage.searchProduct(product);

        //validacion de que los productos encontrados coincidan con la busqueda
        ResultsPage onResultsPage = new ResultsPage(driver);

        Assert.assertTrue(onResultsPage.noFoundResultsDisplayed(), "The no result label is not present");
    }

}
