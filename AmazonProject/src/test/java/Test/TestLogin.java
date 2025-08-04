package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ConfigManager;
import utils.ExtentManager;

public class TestLogin {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    LoginPage login;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        login = new LoginPage(driver);
        extent = ExtentManager.getInstance(); // Créez l'instance de ExtentReports
    }

    @AfterMethod
    public void tearDown() {
    	if (driver != null) {
    		driver.quit();
    			}
    			if (extent != null) {
    				extent.flush(); // Finaliser le rapport
    			}
    }

    @Test
    public void LoginCompteValid() {
        test = extent.createTest("Test de login avec compte valide", "Vérifier que les utilisateurs peuvent se connecter avec des identifiants valides.");

        String username = ConfigManager.getProperty("username");
        String password = ConfigManager.getProperty("password");

        test.info("User navigue vers la page d'identification");
        driver.get(ConfigManager.getProperty("baseUrl1"));
        test.pass("User et la page d'identification");

        login.gererCookies();
        test.pass("User gère les cookies");

        login.enter_username_continuer();
        test.pass("User entre le username et presse continuer");

        login.enter_password_signInSubmit();
        test.pass("User entre le password et presse identifier");

        login.skip_num();
        test.pass("User saute l'ajout du numéro de téléphone");

        login.assertiondashbord();
        test.pass("User est sur le dashboard d'accueil");
    }

    @Test
    public void LoginCompteinValid() {
        test = extent.createTest("Test de login avec compte invalide", "Vérifier que les utilisateurs peuvent se connecter avec des identifiants invalides.");

        String username1 = ConfigManager.getProperty("username1");
        String password1 = ConfigManager.getProperty("password1");

        test.info("User navigue vers la page d'identification");
        driver.get(ConfigManager.getProperty("baseUrl1"));
        test.pass("User et la page d'identification");
        
        login.gererCookies();
        test.pass("User gère les cookies");

        login.enter_usernameInvalid_continuer();
        test.fail("User entre le username et presse continuer");
         
        login.erreurCreationCompte();
        test.fail("user enter email invalid");

        // Supprimer ou désactiver les étapes supplémentaires si non nécessaires
    }
}
