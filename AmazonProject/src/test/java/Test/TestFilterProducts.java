package Test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Pages.HomePage;
import Pages.ResultsPage;
import utils.BaseTest;
import utils.ExtentManager;

public class TestFilterProducts extends BaseTest {

	HomePage home;
	ResultsPage resultat;



	@Test
	public void testFilterProducts() throws InterruptedException {
		
        extentTest = extent.createTest("Test de Filtrage des Produits");
       
        home = new HomePage(driver);
        resultat = new ResultsPage(driver);
        
       // home=new HomePage(driver);
      //  home.openHomePage();
     
        



	}



}
