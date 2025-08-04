/*package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageMyShop {
WebDriver driver;

By txt_home = By.xpath("//*[@class='k1zIA rSk4se']");
By txt_choix = By.id("APjFqb");
By txt_searchpage = By.id("logo");
By link_myshop = By.partialLinkText("My Shop");
By logo_myshop = By.id("header_logo");
By btn_accept = By.xpath("//*[@class='QS5gu sy4vM' and contains (text(),'Tout accepter')]");



public HomePageMyShop(WebDriver driver) {
	
	this.driver=driver;
	
		
	}

     public void lunchbrowsser() {
    	 WebDriverManager.chromedriver().setup();
         
 		 driver = new EdgeDriver();
 		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.manage().window().maximize(); 
         driver.get("https://www.google.com/");
         driver.findElement(btn_accept).click();
         }

	  public void Googlesearch() {
	    	driver.findElement(txt_home).isDisplayed();
	    }
	  
	  public void enterChoixSearch(String siteWeb) {
		  driver.findElement(txt_choix).sendKeys(siteWeb);
	  }
	  
	  public void clickEnter() {
		  driver.findElement(txt_choix).sendKeys(Keys.ENTER);
	  }
	  public void pageGooglesearch() {
	    	driver.findElement(txt_searchpage).isDisplayed();
	    }
	  public void entermyshop() {
	    	driver.findElement(link_myshop).click();
	    
	    }
	  public void assertpagehome() {
		  driver.findElement(logo_myshop).isDisplayed();
		  
	  }
	  
	  public void conenxionHomePageMyShop(String siteWeb) {
		  driver.findElement(txt_home).isDisplayed();
		  driver.findElement(txt_choix).sendKeys(siteWeb);
		  driver.findElement(txt_choix).sendKeys(Keys.ENTER);
		  driver.findElement(txt_searchpage).isDisplayed();
		  driver.findElement(txt_searchpage).isDisplayed();
		  driver.findElement(link_myshop).click();
		  driver.findElement(logo_myshop).isDisplayed();
		  
	  }
	  public void quit() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.close();
		  driver.quit();
	  }
	  
}*/
