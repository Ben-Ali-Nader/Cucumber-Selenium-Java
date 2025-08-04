/*package StepsDefenitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Page_FC.LoginPageMyShop_PF;
import Pages.HomePageMyShop;
import Pages.LoginPageMyShop;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginMyshop_PF {
	WebDriver driver;
	LoginPageMyShop_PF login;
	
	
	
	@Given("user est sur la page de connexion")
	public void user_est_sur_la_page_de_connexion() {
		
		WebDriverManager.edgedriver().setup(); 
		driver= new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account"); 
		login= new LoginPageMyShop_PF(driver);
		System.out.println("==== je suis sur login my shop Factory page ===");
	}

	@When("^user entre un email valide (.*)$")
	public void user_entre_un_email_valide(String email) {
		
		login.enterUsername(email);
	   
	}

	@When("^user entre un mot de passe valide (.*)$")
	public void user_entre_un_mot_de_passe_valide(String password) {
	    login.enterPassword(password);
	}

	@When("user clique sur le bouton Sign In")
	public void user_clique_sur_le_bouton() {
		
	    login.clickLogin();
	}

	@Then("user est redirigé vers la page daccueil de son compte")
	public void user_est_redirigé_vers_la_page_d_accueil_de_son_compte() throws InterruptedException {
	    login.clickDashboardHome();
	    login.quit();
	
}
}*/
