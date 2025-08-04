package Pages;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreationCompte {
	
	WebDriver driver;
	
	@FindBy(id="nav-link-accountList")
	WebElement CompteEtListes;
	@FindBy(xpath="//*[@class=\"nav-a\"]")
	WebElement NouvCompte; 
	@FindBy(id="ap_customer_name")
	WebElement input_nomEtprenom;
	@FindBy(id="ap_email")
	WebElement input_email;
	@FindBy(id="ap_password")
	WebElement input_password;
	@FindBy(id="ap_password_check")
	WebElement input_conf_password;
	@FindBy(id="continue")
	WebElement submit;
	@FindBy(xpath="//*[@class=\"a-alert-content\" and contains (text(),' Il existe déjà un compte associé à cette adresse e-mail. ')]")
	WebElement Errur_compteExisteDeja;
	

	public CreationCompte(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

	}
	
	public void assert_page_inscription() {
		
	        String actualHref = driver.getCurrentUrl();
	        System.out.println(actualHref);// 
	        String expectedHref = "https://www.amazon.fr/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.fr%2F%3F_encoding%3DUTF8%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=frflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0"; // Remplacez par l'URL attendue
	        Assert.assertEquals(actualHref, expectedHref);

	        // Message en cas de succès
	        System.out.println("Le lien d'inscription est visible et correspond à l'URL attendue.");
	    
    }
	
	public void remplire_formulaire_inscription(String nomPrenom,String email,String pwd,String pwdConfirm) {
		input_nomEtprenom.sendKeys(nomPrenom);
		input_email.sendKeys(email);
		input_password.sendKeys(pwd);
		input_conf_password.sendKeys(pwdConfirm);
	   
	}
	
	public void submit(String email) {
		submit.click();
		try {
	        if (Errur_compteExisteDeja.isDisplayed()) {
	            System.out.println("Le compte existe déjà pour l'adresse e-mail: "+email );
	            
	        }
	    } catch (Exception e) {
	        // Si aucune exception n'est lancée, cela signifie probablement que l'utilisateur a été redirigé vers la page suivante
	        System.out.println("Le compte a été créé avec succès pour l'adresse e-mail: "+email);
	    }
	}
		
	
	
	public void nouveauCompte() {
		try {
		Actions actions = new Actions(driver);

		actions.moveToElement(CompteEtListes).perform();

		if (NouvCompte.isDisplayed()) {
			NouvCompte.click();
			Thread.sleep(5000);
		} else {
			System.out.println("Sous-menu non affiché.");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} 
		

	}
	public static String getNomPrenom(String filePath) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(filePath);
			Element root = document.getDocumentElement();
			return root.getElementsByTagName("nomPrenom").item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String getEmail(String filePath) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(filePath);
			Element root = document.getDocumentElement();
			return root.getElementsByTagName("email").item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getPassword(String filePath) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(filePath);
			Element root = document.getDocumentElement();
			return root.getElementsByTagName("pwd").item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String getPasswordConfir(String filePath) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(filePath);
			Element root = document.getDocumentElement();
			return root.getElementsByTagName("pwdConfirm").item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
