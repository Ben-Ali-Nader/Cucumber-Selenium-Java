package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashbord {


	WebDriver driver;

	@FindBy(xpath="//*[@class='item-text' and contains (text(),'Accueil')]")
	WebElement Accueil;

	@FindBy(xpath="//*[@class=\"calendar icon\"]")
	WebElement calendrier;

	@FindBy(xpath="//*[@class='rbc-day-bg rbc-today']")
	WebElement date_calend;

	@FindBy(xpath="//*[@id=\"downloadFrame\"]")
	WebElement frame_calend;

	public dashbord(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

	}

	public void click_accueil() {
		Accueil.isDisplayed();

		WebElement accueilButton = Accueil; 
		Actions actions = new Actions(driver);
		actions.moveToElement(accueilButton).perform();
		System.out.println("accueil est la ");
	}

	public void check_calendrier() {
		calendrier.isDisplayed();
		calendrier.click();
	}
	public void ajouter_un_evenement_a_un_date_precis() {

		 try {
	            System.out.println("Tentative de sélection d'une date dans le calendrier...");

	          
	            if (frame_calend.isDisplayed()) {
	                driver.switchTo().frame(frame_calend);
	                System.out.println("Basculé dans le frame du calendrier.");
	            }
	            
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(date_calend));

	         
	           
	            dateElement.click();
	            System.out.println("La date a été sélectionnée avec succès.");

	            
	            driver.switchTo().defaultContent();
	        
	        } catch (Exception e) {
	        	ajouter_un_evenement_a_un_date_precis();
	            System.out.println("Erreur lors de la sélection de la date : " + e.getMessage());
	        }
	    }


	}



