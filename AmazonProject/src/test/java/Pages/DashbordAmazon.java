package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DashbordAmazon {
	@FindBy(id="nav-logo-sprites")
	WebElement logo;
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBar;
	@FindBy(id="nav-link-accountList")
	WebElement CompteEtListes;
	@FindBy(id="nav-flyout-ya-newCust")
	WebElement NouvCompte; 
	@FindBy(id="sp-cc-accept")
	WebElement accepte_Cookies;
	@FindBy(xpath="//*[@onclick=\"window.location.reload()\"]")
	WebElement avant_cockies;
	@FindBy(id="twotabsearchtextbox")
	WebElement rechere;


	WebDriver driver;

	public DashbordAmazon(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

	}

	public void Cookies() {
		try {
			if( avant_cockies.isDisplayed()) {
				avant_cockies.click();
				accepte_Cookies.click();
				System.out.println("les avant cockies et les cokies sont bien accepté");

			}
				accepte_Cookies.click();
				System.out.println("les Cookies sont bien accepté");
			}catch (Exception e) {
				e.printStackTrace();
			} 

		}
	public void enterbarerecherche() {
		System.out.println("je suis dans la barre de recherche ");
		rechere.sendKeys("nader");
	}
		public void TestGraphique() {
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

				Actions actions = new Actions(driver);

				actions.moveToElement(CompteEtListes).perform();

				if (NouvCompte.isDisplayed()) {
					System.out.println("Sous-menu affiché après le hover.");
				} else {
					System.out.println("Sous-menu non affiché.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}



	}
