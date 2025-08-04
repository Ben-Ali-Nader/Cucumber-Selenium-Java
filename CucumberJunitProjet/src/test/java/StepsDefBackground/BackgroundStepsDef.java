package StepsDefBackground;
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

public class BackgroundStepsDef {
	
	WebDriver driver;
	LoginPageMyShop_PF login;
	HomePageMyShop_PF home;
	AuthetificationMyshop_PF auth;
	String randomEmail;
	
	@Before
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        login = new LoginPageMyShop_PF(driver);
        home = new HomePageMyShop_PF(driver);
        auth = new AuthetificationMyshop_PF(driver);
		
	}
	 @After
	 public void closeDriver() throws InterruptedException {
		 
		 auth.quit();
		 login.quit();
		 
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
	 
	 
	///////////////////////////////////////////////////////////////// 
	 
	 
	 
	
	@Given("the browser is open")
	public void the_browser_is_open() {
        
		
		
        driver.get("https://www.google.com/");
        
        home.lunchbrowsser();
        
	}

	@Given("the user is on the Google search page")
	public void the_user_is_on_the_google_search_page() {
	   home.Googlesearch();
	}

	@When("the user enters site of My shop in the search box")
	public void the_user_enters_site_of_my_shop_in_the_search_box() {
	   home.enterChoixSearch1();
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
	public void the_user_scrolls_to_the_my_shop_site_and_clicks_enter() {
	    home.entermyshop();
	}

	@Then("the user is navigated to the home page")
	public void the_user_is_navigated_to_the_home_page() {
	    home.assertpagehome();
	}

	@Then("the user clicks on the Sign Up button")
	public void the_user_clicks_on_the_sign_up_button() {
	   auth.clickbouttonsing();
	   System.out.println("===========background executé avec succés=============== ");
	}

	
	//////////////////////////////////////////////////////////////////
	
	
	
	
	
	@Given("the user enters email")
	public void the_user_enters_email() {
		
		auth.setup();
		randomEmail =	auth.getRandomEmail();
	    auth.userenteremail(randomEmail);
	}

	@Given("the user clicks create account")
	public void the_user_clicks_create_account() {
	    auth.userclickcreateaccount();
	}

	@Then("the user receives the registration form")
	public void the_user_receives_the_registration_form() {
	   auth.assertionpageformulaire();
	}

	@Then("the user fills out the form:")
	public void the_user_fills_out_the_form(io.cucumber.datatable.DataTable dataTable) {
	  auth.remplissageformulaire(dataTable);
	}

	@Then("the user clicks on the Register button")
	public void the_user_clicks_on_the_register_button() {
	    auth.register();
	}

	@Then("the user is navigated to the dashboard")
	public void the_user_is_navigated_to_the_dashboard(){
	  auth.asserdashbord();
	  System.out.println("===========Authetification executé avec succés=============== ");
	 
	  
	}
    
	///////////////////////////////////////////////////////////////////
	
	
	@Given("^the user enters a valid email (.*)$")
	public void the_user_enters_a_valid_email_nadbenali_it_gmail_com(String email) {
	    login.enterUsername(email);
	    
	}

	@Given("^the user enters a valid password (.*)$")
	public void the_user_enters_a_valid_password_nader123(String pwd) {
	    login.enterPassword(pwd);
	}

	@Given("the user clicks on the Sign In button")
	public void the_user_clicks_on_the_sign_in_button() {
	    login.clickLogin();
	}

	@Then("the user is redirected to their account homepage")
	public void the_user_is_redirected_to_their_account_homepage()  {
	   login.isDashboardDisplayed();
	   login.clickDashboardHome();
	   System.out.println("===========Login executé avec succés=============== ");
	   
	}


}
