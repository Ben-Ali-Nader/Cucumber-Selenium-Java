package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ConfigManager;
import utils.BaseTest;
import utils.ExtentManager;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.ValidationPage;

public class TestValidationPanier extends BaseTest {

	WebDriver driver;
	ExtentTest test;
	ExtentReports extent;

	ProductPage produits;
	LoginPage login;
	ValidationPage val;



	@Test
	public void InvalidationPanier() throws InterruptedException {
		extent = ExtentManager.getInstance();
		test = extent.createTest("Invalidation Panier", "Vérifie l'ajout d'un produit au panier et l'invalidation d'achat.");

		try {
			// Étape 1 : Recherche d'un produit
			produits.enterRecherche();
			test.info("Recherche d'un produit effectuée.");

			// Étape 2 : Ajouter le produit au panier
			produits.ajouterproduisaupanier();
			test.pass("Produit ajouté au panier avec succès.");

			// Étape 3 : Connexion utilisateur
			login.LoginPourPasserCommande();
			test.pass("Connexion validée.");

			// Étape 4 : Remplissage du formulaire avec des fausses informations
			val.remplisageFormulaire_FauseInformation();
			test.pass("Formulaire rempli avec des fausses informations.");

			// Étape 5 : Confirmation de l'adresse
			val.confirmeAdresse();
			test.pass("Message d'erreur affiché avec succès.");
		} catch (Exception e) {
			test.fail("Erreur : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
