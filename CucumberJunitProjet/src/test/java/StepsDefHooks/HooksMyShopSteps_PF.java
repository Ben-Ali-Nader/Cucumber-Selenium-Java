/*package StepsDefHooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Page_FC.AuthetificationMyshop_PF;
import Page_FC.HomePageMyShop_PF;
import Page_FC.LoginPageMyShop_PF;
import io.cucumber.core.gherkin.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksMyShopSteps_PF {
	WebDriver driver;
	HomePageMyShop_PF home;
	AuthetificationMyshop_PF singup ;
	LoginPageMyShop_PF login;
	String randomEmail;
	
	
	
	@Before
	public void setupBrowser() {
       
		WebDriverManager.chromedriver().setup();
        
		
		
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        home = new HomePageMyShop_PF(driver);
        singup = new AuthetificationMyshop_PF(driver);
        login = new LoginPageMyShop_PF(driver);
	    home.lunchbrowsser();
        
		
	}
	
	
	@After
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		
		System.out.println("le navigateur est fermé ");
	}
	
	 @BeforeStep
	    public void beforeStep(Scenario scenario) {
	        takeScreenshot(scenario, "Before Step");
	    }

	    @AfterStep
	    public void afterStep(Scenario scenario) {
	        takeScreenshot(scenario, "After Step");
	    }

	    private void takeScreenshot(Scenario scenario, String stepPosition) {
	        try {
	            if (driver != null) {
	                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	                scenario.attach(screenshot, "image/png", stepPosition);
	            }
	        } catch (Exception e) {
	            System.out.println("Exception lors de la capture d'écran : " + e.getMessage());
	        }
	    }
	
	
	
	@Given("the browser is open")
	public void the_browser_is_open() {
		
        System.out.println("=== Premiere scenario  ====");
	}
	

	@Given("the user is on the Google search page")
	public void the_user_is_on_the_Google_search_page() {
		   
		    home.Googlesearch();
	       
	}

	@When("^the user enters (.*) in the search box$")
	public void the_user_enters_automationpractice_in_the_search_box(String siteWeb) {
	   home.enterChoixSearch(siteWeb);
	   
	}

	@When("clicks enter")
	public void clicks_enter() {
	    home.clickEnter();
	}

	@Then("the user is navigated to the search results page")
	public void the_user_is_navigated_to_the_search_results_page() {
	    home.pageGooglesearch();
	}

	@Then("the user scrolls to the My Shop site and clicks enter")
	public void the_user_scrolls_to_the_My_Shop_site_and_clicks_enter() {
	   home.entermyshop();
	}

	@Then("the user is navigated to the home page")
	public void the_user_is_navigated_to_the_home_page() {
	   home.assertpagehome();
	}
	
	

	
	
	
	@Given("^the brow (.*) is open$")
	public void the_browser_is_open(String Browser) {
		
		singup.lunchbrowser(Browser);
		home.clickEnter();
		home.entermyshop();
		home.assertpagehome();
		
	System.out.println("=== deuxieme scenario  ====");
	    
	}
	
	@And("user clicks on the Sign Up button")
	public void user_clicks_on_the_Sign_Up_button() {
		singup.clickbouttonsing();	
	    
	}

	@When("user enters email")
	public void user_enters_email() {
		singup.setup();
		randomEmail = singup.getRandomEmail();
	    singup.userenteremail(randomEmail);
       
  
}
		
	

	@When("user clicks create account")
	public void user_clicks_create_account() {
	   singup.userclickcreateaccount();
	}

	@Then("user receives the registration form")
	public void user_receives_the_registration_form() {
	   singup.assertionpageformulaire();
	}

	@Then("user fills out the form:")
	public void user_fills_out_the_form(io.cucumber.datatable.DataTable dataTable) {
	    singup.remplissageformulaire(dataTable);
	}

	@Then("user click sur button Register")
	public void user_click_sur_button_Register() {
	   singup.register();
	}

	@Then("user is navigated to the dashboard")
	public void user_is_navigated_to_the_dashboard() {
	   singup.asserdashbord();
	}
     
	
	
	@Given("^user est sur la (.*)$")
	public void user_est_sur_la_page_de_connexion(String PConnexion) {
		System.out.println("=== troisiemme scenario  ====");
		singup.lunchbrowser(PConnexion);
		home.clickEnter();
		home.entermyshop();
		home.assertpagehome();
		singup.clickbouttonsing();
	}

	@When("^user entre un email valide (.*)$")
	public void user_entre_un_email_valide_nadbenali_it_gmail_com(String username) {
	   login.enterUsername(username);
	}

	@When("^user entre un mot de passe valide (.*)$")
	public void user_entre_un_mot_de_passe_valide_nader123(String pswd) {
		login.enterPassword(pswd);
	    
	}

	@When("user clique sur le bouton Sign In")
	public void user_clique_sur_le_bouton_Sign_In() {
	   login.clickLogin();
	}

	@Then("user est redirigé vers la page daccueil de son compte")
	public void user_est_redirigé_vers_la_page_daccueil_de_son_compte() {
	   login.isDashboardDisplayed();
	   login.clickDashboardHome();
	}
	
	
    }
*/

