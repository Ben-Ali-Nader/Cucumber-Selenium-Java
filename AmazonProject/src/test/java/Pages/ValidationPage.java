package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import utility.ConfigManager;

public class ValidationPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id="address-ui-widgets-countryCode-dropdown-nativeId")
	WebElement adressePays;

	@FindBy(id = "address-ui-widgets-countryCode-dropdown-nativeId_112")
	WebElement italie;

	@FindBy(id="address-ui-widgets-enterAddressFullName")
	WebElement nomPrenom;

	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber")
	WebElement numPhone;

	@FindBy(id = "address-ui-widgets-enterAddressLine1")
	WebElement adreese1;

	@FindBy(id = "address-ui-widgets-enterAddressLine2")
	WebElement adreese2;

	@FindBy(id = "address-ui-widgets-enterAddressPostalCode")
	WebElement codePostal;

	@FindBy(id = "address-ui-widgets-enterAddressCity")
	WebElement ville;

	@FindBy(id = "address-ui-widgets-use-as-my-default")
	WebElement checkboxMemoriserAdresse;

	@FindBy(id = "address-ui-widgets-form-submit-button")
	WebElement confirmeAdresse;

	@FindBy(name="address-ui-widgets-saveOriginalOrSuggestedAddress")
	WebElement sauvAdresse;
	@FindBy(xpath="//*[@class=\"displayAddressUL\"]")
	WebElement assertionInformation;

	public ValidationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	public void remplisageFormulaire_FauseInformation() {
		
		try { 
			String nom_Prenom_f = ConfigManager.getProperty("nom_Prenom_f");
			String num_phone_f = ConfigManager.getProperty("num_phone_f");
			String adreese_1_f = ConfigManager.getProperty("adreese_1_f");
			
			String code_Postal_f = ConfigManager.getProperty("code_Postal_f");
			String ville_residance_f = ConfigManager.getProperty("ville_residance_f");


			if (adreese1.isDisplayed()) {
				adreese1.clear();
				adreese1.sendKeys(adreese_1_f);
			}
			Thread.sleep(500);

			if (numPhone.isDisplayed()) {
				numPhone.clear();
				numPhone.sendKeys(num_phone_f);
			}
			Thread.sleep(500);

			if (codePostal.isDisplayed()) {
				codePostal.clear();
				codePostal.sendKeys(code_Postal_f);
			}
			Thread.sleep(500);

			if (ville.isDisplayed()) {
				ville.clear();
				ville.sendKeys(ville_residance_f);
			}            Thread.sleep(500);
			if (nomPrenom.isDisplayed()) {
				nomPrenom.clear();
				nomPrenom.sendKeys(nom_Prenom_f);
			}            Thread.sleep(500);

		} catch (Exception e) {
			System.err.println("Erreur lors du remplissage du formulaire : " + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("formulaire rempli avec fausse information");
		
	}


public void remplisageFormulaire() {
	try { 
		String nom_Prenom = ConfigManager.getProperty("nom_Prenom");
		String num_phone = ConfigManager.getProperty("num_phone");
		String adreese_1 = ConfigManager.getProperty("adreese_1");
		
		String code_Postal = ConfigManager.getProperty("code_Postal");
		String ville_residance = ConfigManager.getProperty("ville_residance");


		if (adreese1.isDisplayed()) {
			adreese1.clear();
			adreese1.sendKeys(adreese_1);
		}
		Thread.sleep(500);

		if (numPhone.isDisplayed()) {
			numPhone.clear();
			numPhone.sendKeys(num_phone);
		}
		Thread.sleep(500);

		if (codePostal.isDisplayed()) {
			codePostal.clear();
			codePostal.sendKeys(code_Postal);
		}
		Thread.sleep(500);

		if (ville.isDisplayed()) {
			ville.clear();
			ville.sendKeys(ville_residance);
		}            Thread.sleep(500);
		if (nomPrenom.isDisplayed()) {
			nomPrenom.clear();
			nomPrenom.sendKeys(nom_Prenom);
		}            Thread.sleep(500);

	} catch (Exception e) {
		System.err.println("Erreur lors du remplissage du formulaire : " + e.getMessage());
		e.printStackTrace();
	}
	
	System.out.println("formulaire rempli avec succes");
}

public void confirmeAdresse() throws InterruptedException {
	if(confirmeAdresse.isDisplayed()) {
		confirmeAdresse.click();
	}
	Thread.sleep(1000);
	if(assertionInformation.isDisplayed()) {
		String info = assertionInformation.getText();
		System.out.println("user confirme leur adreesse de livraison"+info);
		
	}
	
}

}