/*package StepsDefenitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePageMyShop;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyShopHomePageSteps {
	
	 WebDriver driver;
	HomePageMyShop home;
	
	@Given("the browser is open")
	public void browser_is_open() {
		home = new HomePageMyShop(driver);
        home.lunchbrowsser();
	}

	@And("the user is on the Google search page")
	public void user_is_in_google_searsh() {
		home.Googlesearch();
	}
	
	
	@When("^the user enters (.*) in the search box$")
	public void user_enter_a_text_ins_search_box(String siteWeb) {
		home.enterChoixSearch(siteWeb);
	}

	@Then("clicks enter")
	public void click_enter() {
		 home.clickEnter();
	}
	
	@Then("the user is navigated to the search results page")
	public void user_is_navigated_to_page_search() {
		home.pageGooglesearch();
	}

	@Then("the user scrolls to the My Shop site and clicks enter")
	public void user_scroll_vers_le_site_Myshop_and_click_enter() {
		home.entermyshop();
	}


	@Then("the user is navigated to the home page")
	public void user_is_navigated_to_home_page() throws InterruptedException {
		home.assertpagehome();
		home.quit();
		}
	
	
}*/
