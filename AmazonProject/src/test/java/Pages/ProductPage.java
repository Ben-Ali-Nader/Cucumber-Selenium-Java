package Pages;

import java.time.Duration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ProductPage {
	
	WebDriver driver;
	HomePage home;
	HomePage produits;
	@FindBy(xpath="//*[@aria-label=\"Nostalgic-Art Tasse à café rétro, 330 ml, Official License Product (OLP), BMW – Drivers Only – Idée de cadeau pour fans de BMW, mug en céramique, design vintage\"]")
	WebElement produitCible;
	@FindBy(id="add-to-cart-button")
	WebElement ajPanier;
	@FindBy(id="sw-gtc")
    WebElement allerPanier;
	@FindBy(id="desktop-ptc-button-celWidget")
	WebElement passerCommande;
	@FindBy(id="sc-subtotal-label-buybox")
	WebElement totalPanier;
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBar;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		

	}
	
	public void enterRecherche() {
		String filePath = "src/main/resources/credentials.xml";       
		String produit = HomePage.GetProduitRechercher(filePath);
		
		if (searchBar.isDisplayed()) {
			searchBar.sendKeys(produit);
			searchBar.sendKeys(Keys.ENTER); 
			System.out.println("Produit inséré dans la barre de recherche et recherche lancée.");
		} else {
			System.out.println("La barre de recherche n'est pas affichée. Impossible d'insérer le produit.");
		}
		System.out.println("je suis la encore");
	}
	
	public void ajoutProduitDansLePanier() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Attente explicite avec un timeout de 10 secondes

        try {
            // Attendre et cliquer sur le produit cible
            wait.until(ExpectedConditions.visibilityOf(produitCible));
            System.out.println("Le produit cible est visible, prêt à être cliqué.");
            produitCible.click();

            // Attendre et cliquer sur "Ajouter au panier"
            wait.until(ExpectedConditions.visibilityOf(ajPanier));
            System.out.println("Le bouton 'Ajouter au panier' est visible, prêt à être cliqué.");
            ajPanier.click();

            // Attendre et cliquer sur "Aller au panier"
            wait.until(ExpectedConditions.visibilityOf(allerPanier));
            System.out.println("Le bouton 'Aller au panier' est visible, prêt à être cliqué.");
            allerPanier.click();

          

        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de l'ajout du produit au panier : " + e.getMessage());
            e.printStackTrace();
        }
		}
	
	
	public void assertionPanier() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Attente explicite avec un timeout de 10 secondes

	        try {
	           
	            // Attendre et cliquer sur "Ajouter au panier"
	            wait.until(ExpectedConditions.visibilityOf(totalPanier));
	            String panier = totalPanier.getText();
	            System.out.println("le panier est visible est contient un "+panier);
	         

	        } catch (Exception e) {
	            System.out.println("Une erreur s'est produite lors verification du panier : " + e.getMessage());
	            e.printStackTrace();
	        }
		
	}
	
	
	public static String GetProduitRechercher(String filePath) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(filePath);
			Element root = document.getDocumentElement();
			return root.getElementsByTagName("rechercheAmazon").item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void ajouterproduisaupanier() throws InterruptedException {
		
		enterRecherche();
		ajoutProduitDansLePanier();
		assertionPanier();
		
	}
	
	
	
	
	
}
