package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CreationCompte;
import Pages.DashbordAmazon;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentManager;

public class TestDashAmazon {

	WebDriver driver;
	DashbordAmazon dash;
	ExtentReports extent;
	CreationCompte compte;
	ExtentTest test;

	@BeforeTest
	public void setupReporter() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.fr/");

		// Initialiser le rapport avec ExtentManager
		extent = ExtentManager.getInstance();
		dash = new DashbordAmazon(driver);
		
		dash.Cookies();
		
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
	
	@Test(priority = 1)
	public void testtest() {
		// Créer un test dans le rapport
		test = extent.createTest("Test test", "Vérification ");

		
			
			dash.enterbarerecherche();

		
	}

	@Test(priority = 3)
	public void testGraphique() {
		// Créer un test dans le rapport
		test = extent.createTest("Test Graphique", "Vérification de l'affichage graphique sur Amazon");

		try {
			
			dash.TestGraphique(); // Test graphique

			test.pass("Les éléments graphiques sont affichés correctement.");
		} catch (Exception e) {
			test.fail("Erreur lors de l'exécution : " + e.getMessage());
		}
	}
	@Test(priority = 2)
	public void testCreationDuCompteValid() {
		// Créer un test dans le rapport
		test = extent.createTest("Test Creation Compte ", "Vérification de la creation du compte avec un email valid sur Amazon");
		
		try {

			CreationCompte compte = new CreationCompte(driver);

			String filePath = "src/main/resources/credentials.xml";       
			String nomPrenom = compte.getNomPrenom(filePath);
			String email=compte.getEmail(filePath);
			String pwd=compte.getPassword(filePath);
			String pwdConf=compte.getPasswordConfir(filePath);

			compte.nouveauCompte();
			compte.assert_page_inscription();
			compte.remplire_formulaire_inscription(nomPrenom,email ,pwd,pwdConf);
			compte.submit(email);
			test.pass("L'inscrption est terminé");
		} catch (Exception e) {
			test.fail("Erreur lors de l'exécution : " + e.getMessage());
		}
	}

}
