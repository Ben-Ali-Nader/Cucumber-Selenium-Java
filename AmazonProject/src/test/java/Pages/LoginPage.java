package Pages;

import java.time.Duration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import utility.ConfigManager;

public class LoginPage {

	WebDriver driver;
	@FindBy(xpath="//*[@onclick=\"window.location.reload()\"]")
	WebElement avant_cockies;
	@FindBy(id="ap_email")
	WebElement username;
	@FindBy(id="continue")
	WebElement Continuer;
	@FindBy(id="ap_password")
	WebElement password;
	@FindBy(id="signInSubmit")
	WebElement signInSubmit;
	@FindBy(id="ap-account-fixup-phone-skip-link")
	WebElement pas_maintenant;
	@FindBy(id="nav-logo-sprites")
	WebElement logo;
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBar;
	@FindBy(id="auth-error-message-box")
	WebElement erreur;
	@FindBy(id="desktop-ptc-button-celWidget")
	WebElement passerCommande;
	@FindBy(id="add-new-address-popover-link")
	WebElement newadresse;
	@FindBy(id="address-ui-widgets-enterAddressFullName")
	WebElement message_ajouternouvelleadreesee;
	@FindBy(xpath="//*[@name=\"__tcfapiLocator\"]")
	WebElement iframe;

	public LoginPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

	}

	public void gererCookies() {
		try {
			// Vérification si l'élément est affiché
			if (avant_cockies != null && avant_cockies.isDisplayed()) {
				avant_cockies.click();
				System.out.println("L'élément avant cookies a été cliqué.");
			} else {
				System.out.println("L'élément avant cookies n'est pas affiché ou est null.");
			}
		} catch (Exception e) {
			// Gestion des exceptions avec message d'erreur détaillé
			System.err.println("Erreur lors de la gestion des cookies : " + e.getMessage());
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

	public void enter_usernameInvalid_continuer(){
		String email = ConfigManager.getProperty("username1");
		username.sendKeys(email);
		Continuer.click();

	}
	public void enter_username_continuer(){
		String email = ConfigManager.getProperty("username");
		username.sendKeys(email);
		Continuer.click();

	}
	public void enter_password_signInSubmit(){
		String pwd = ConfigManager.getProperty("password");
		password.sendKeys(pwd);
		signInSubmit.click();

	}

	public void skip_num() {

		try {
			// Vérification si l'élément est affiché
			if (pas_maintenant != null && pas_maintenant.isDisplayed()) {
				pas_maintenant.click();
				System.out.println("L'élément pas_maintenant a été cliqué.");
			} else {
				System.out.println("L'élément pas_maintenant n'est pas affiché ou est null.");
			}
		} catch (Exception e) {
			// Gestion des exceptions avec message d'erreur détaillé
			System.err.println("Erreur lors de la gestion des cookies : " + e.getMessage());
		}

	}

	public void assertiondashbord() {

		try {

			if (logo.isDisplayed()) {
				System.out.println("vous ete sur votre dashbord amazon.");
			} else {
				System.out.println("votre dashbord ne se charge pas.");
			}
		} catch (Exception e) {

			System.err.println("Erreur lors de la page d'acueil : " + e.getMessage());
		}
	}
	public void erreurCreationCompte() {

		try {

			if (erreur.isDisplayed()) {
				System.out.println("Impossible de trouver un compte correspondant à cette adresse e-mail");
			} 
		} catch (Exception e) {

			System.err.println("Erreur lors de la creation du compte : " + e.getMessage());
		}
	}
public void passerCommande() {
	passerCommande.click();
}


public void newadresse() {
	newadresse.click();
    try {
        
        // Vérifier si le formulaire est bien affiché dans l'iframe
        if (message_ajouternouvelleadreesee.isDisplayed()) {
            System.out.println("Formulaire d'ajout nouvelle adresse est affiché");
        } else {
            System.out.println("Le formulaire d'ajout de nouvelle adresse ne s'affiche pas");
        }
    } catch (Exception e) {
        System.err.println("Erreur lors de l'interaction avec l'iframe : " + e.getMessage());
    }
    
}


public void LoginPourPasserCommande() {
	passerCommande();
	enter_username_continuer();
	enter_password_signInSubmit();
	newadresse();
}


}
