package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Pages.CreationCompte;
import Pages.DashbordAmazon;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentManager;

public class TestRechercheProduit {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	HomePage recherche;


	@BeforeTest
	public void setupReporter() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		

		extent = ExtentManager.getInstance();




	}

	@AfterTest
	public void tearDownReporter() {
	if (driver != null) {
	driver.quit();
		}
		if (extent != null) {
			extent.flush(); // Finaliser le rapport
		}
	}

	@Test
	public void TestRechercheProduit() throws InterruptedException {

		test = extent.createTest("Test de Recherche de Produit", "Vérifier que la fonctionnalité de recherche renvoie des résultats pertinents.");
		recherche = new HomePage(driver);
		
		
		String filePath = "src/main/resources/credentials.xml";       
		String produit = recherche.GetProduitRechercher(filePath);
		
		test.info("user navigue vers le site amazon fr");
		driver.get("https://www.amazon.fr/");
		test.pass("user et site dashbord amazon fr");
		//recherche.avantCookies();
		recherche.acceptCookies();
		test.pass("user acepte les cockies");
		recherche.dashbordAmazon();
		test.pass("user tcheck le dashbord");
		recherche.SoumettreRecherche(produit);
		test.pass("user enter le produit a rechercher");
		recherche.VérifierResultats();
		Thread.sleep(2000);



	}



}
