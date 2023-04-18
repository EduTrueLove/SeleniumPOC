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
        //Ventana de bienvenida y aceptacion de ventanas
         WelcomePage onWelcomePage = new WelcomePage(driver);
         onWelcomePage.acceptDisclaimerAndAdvertisement();

         // busqueda de un prodcuto
        LandingPage onLandingPage = new LandingPage(driver);
        onLandingPage.searchProduct(product);

        //validacion de que los productos encontrados coincidan con la busqueda
        ResultsPage onResultsPage = new ResultsPage(driver);
        Assert.assertTrue(onResultsPage.validateResultsMatchesWithTheSearchCriteria(product),"No contiene la palabra pito");
    }
}
