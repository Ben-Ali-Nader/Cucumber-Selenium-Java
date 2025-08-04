package Pages;

import java.time.Duration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import net.bytebuddy.asm.Advice.Enter;

public class HomePage {

	WebDriver driver;
	@FindBy(id="nav-logo-sprites")
	WebElement logo;
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBar;
	@FindBy(id="sp-cc-accept")
	WebElement accepte_Cookies;
	@FindBy(xpath="//*[@onclick=\"window.location.reload()\"]")
	WebElement avant_cockies;
	@FindBy(xpath="//*[@aria-label=\"Nostalgic-Art Tasse à café rétro, 330 ml, Official License Product (OLP), BMW – Drivers Only – Idée de cadeau pour fans de BMW, mug en céramique, design vintage\"]")
	WebElement produitCible;
	
	@FindBy(xpath="//*[@type=\"submit\"]")
	WebElement infoCookies;


	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

	}
	public void acceptCookies() throws InterruptedException {
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			WebElement accepteCookies = wait.until(ExpectedConditions.elementToBeClickable(accepte_Cookies));

			if (accepteCookies.isDisplayed()) {
				accepteCookies.click();
				System.out.println("L'élément 'accepteCookies' a été cliqué.");
			}
		} catch (Exception e) {
			// Si l'élément 'avant cookies' n'est pas visible, il n'y a rien à faire
			System.out.println("'accepteCookies' n'est pas visible.");

		}*/
		
		accepte_Cookies.click();
		Thread.sleep(2000);


	}
	/*public void avantCookies() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			WebElement avantcockies = wait.until(ExpectedConditions.elementToBeClickable(avant_cockies));

			if (infoCookies.isDisplayed()) {
				
				System.out.println("message"+infoCookies);
				Thread.sleep(2000);
				
				avantcockies.click();
				System.out.println("L'élément 'avantcockies' a été cliqué.");
			}
		} catch (Exception e) {
			// Si l'élément 'avant cookies' n'est pas visible, il n'y a rien à faire
			System.out.println("'avantcockies' n'est pas visible.");
			accepte_Cookies.click();

		}

	}*/

	public void dashbordAmazon() {

		try {

			if (logo.isDisplayed()) {
				System.out.println("Le logo Amazon est affiché correctement.");
			} else {
				System.out.println("Le logo Amazon n'est pas affiché.");
			}

			if (searchBar.isDisplayed()) {
				System.out.println("La barre de recherche est affichée correctement.");
			} else {
				System.out.println("La barre de recherche n'est pas affichée.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}


	public void SoumettreRecherche (String produitRechercher) {
		
		if (searchBar.isDisplayed()) {
			searchBar.sendKeys(produitRechercher);
			searchBar.sendKeys(Keys.ENTER); 
			System.out.println("Produit inséré dans la barre de recherche et recherche lancée.");
		} else {
			System.out.println("La barre de recherche n'est pas affichée. Impossible d'insérer le produit.");
		}
		System.out.println("je suis la encore");

	}
	
	public void enterchoixrecherche(String Produit) {
		if (searchBar.isDisplayed()) {
			searchBar.sendKeys(Produit);
			searchBar.sendKeys(Keys.ENTER); 
			System.out.println("Produit inséré dans la barre de recherche et recherche lancée.");
		} else {
			System.out.println("La barre de recherche n'est pas affichée. Impossible d'insérer le produit.");
		}
		System.out.println("je suis la encore");
		
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
	public void VérifierResultats() {
		try {
			// Vérifier si le produit cible est affiché
			if (produitCible.isDisplayed()) {
				// Faire défiler jusqu'à l'élément
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", produitCible);
				System.out.println("Le produit que je cherche sur Amazon est affiché correctement.");
			} else {
				System.out.println("Le produit que je cherche sur Amazon n'est pas affiché.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openHomePage() throws InterruptedException {
		
		accepte_Cookies.click();
		dashbordAmazon();
		
	}


}

