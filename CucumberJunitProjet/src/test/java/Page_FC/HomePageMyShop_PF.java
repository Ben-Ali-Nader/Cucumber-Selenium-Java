package Page_FC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageMyShop_PF {
WebDriver driver;



@FindBy(xpath="//*[@class='k1zIA rSk4se']")
WebElement txt_home;
@FindBy(id="APjFqb")
WebElement txt_choix ;
@FindBy(id="logo")
WebElement txt_searchpage;
@FindBy(partialLinkText="My Shop")
WebElement link_myshop;
@FindBy(id="header_logo")
WebElement logo_myshop;
@FindBy(xpath="//*[@class='QS5gu sy4vM' and contains (text(),'Tout accepter')]")
WebElement btn_accept;



public HomePageMyShop_PF(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	
		
	}

     public void lunchbrowsser() {
    	 
        btn_accept.click();
        }

	  public void Googlesearch() {
	    	txt_home.isDisplayed();
	    }
	  
	  public void enterChoixSearch1() {
			 txt_choix.sendKeys("automationpractice");
		  }
	  
	  
	  public void enterChoixSearch(String siteWeb) {
		 txt_choix.sendKeys(siteWeb);
	  }
	  
	  public void clickEnter() {
		 txt_choix.sendKeys(Keys.ENTER);
	  }
	  public void pageGooglesearch() {
	    	txt_searchpage.isDisplayed();
	    }
	  public void entermyshop() {
	    	link_myshop.click();
	    
	    }
	  public void assertpagehome() {
		 logo_myshop.isDisplayed();
		  
	  }
	  
	  public void conenxionHomePageMyShop(String siteWeb) {
		  txt_home.isDisplayed();
	      txt_choix.sendKeys(siteWeb);
		  txt_choix.sendKeys(Keys.ENTER);
		  txt_searchpage.isDisplayed();
		  txt_searchpage.isDisplayed();
		  link_myshop.click();
		  logo_myshop.isDisplayed();
		  
	  }
	  public void quit() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.close();
		  driver.quit();
	  }
	  
}
