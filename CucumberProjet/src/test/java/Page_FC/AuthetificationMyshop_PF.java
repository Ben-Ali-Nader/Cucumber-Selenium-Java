package Page_FC;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthetificationMyshop_PF {
	WebDriver driver;
	 private String randomEmail;
	
	
    
    @FindBy(id="APjFqb")
    WebElement txt_browser;
    @FindBy(xpath="//*[@title='Log in to your customer account']")
    WebElement btn_SingIn;
    @FindBy(xpath="//*[@class='alert alert-success']")
    WebElement txt_asertdashbord;
    @FindBy(id="email_create")
    WebElement txt_email;
    @FindBy(id="SubmitCreate")
    WebElement btn_submit;
    @FindBy(xpath="//*[@class='page-heading']")
    WebElement txt_assertformulaire;
    @FindBy(id="id_gender1")
    WebElement chx_gender;
    @FindBy(id="customer_firstname")
    WebElement txt_firstname;
    @FindBy(id="customer_lastname")
    WebElement txt_lasttname;
    @FindBy(id="passwd")
    WebElement txt_paswword;
    @FindBy(id="months")
    WebElement val_months;
    @FindBy(id="days")
    WebElement val_day;
    @FindBy(id="years")
    WebElement val_years;
    @FindBy(id="submitAccount")
    WebElement btn_register;
    
    
    
    
    
    
	
	
	public AuthetificationMyshop_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		
	}
	
	public void lunchbrowser(String browser) {
		 txt_browser.sendKeys(browser);
		
	}
	public void clickbouttonsing() {
		btn_SingIn.click();
		
	}
	
	public void userenteremail(String email) {
		 txt_email.sendKeys(email);
	}
	
	public void userclickcreateaccount() {
		btn_submit.click();
       
	}
	public void setup() {
        randomEmail = generateRandomEmail(); // Appel à la méthode pour générer un email unique
    }

    private String generateRandomEmail() {
        Random rand = new Random();
        return "user" + rand.nextInt(10000) + "@gmail.com"; // Format de l'email unique
    }

    public String getRandomEmail() {
        return randomEmail; // Retourne l'email généré
    }
    public void assertionpageformulaire() {
    	WebElement assertion= txt_assertformulaire;
		String actuelleText = assertion.getText();
		System.out.println(actuelleText);
		Assert.assertEquals("AUTHENTICATION", actuelleText);
    }
    public void remplissageformulaire(DataTable dataTable) {
    	List<Map<String, String>> userDetails = dataTable.asMaps(String.class, String.class);
		Map<String, String> user = userDetails.get(0);
		
		 chx_gender.click();
		 txt_firstname.sendKeys(user.get("First Name"));
		 txt_lasttname.sendKeys(user.get("Last Name"));
		 txt_paswword.sendKeys(user.get("Password"));
		 
		 Select dayDropdown = new Select(val_day); 
	     dayDropdown.selectByValue("31"); 
	     
	     Select monthDropdown = new Select(val_months);
	     monthDropdown.selectByValue("8"); 
	     
	     Select yearDropdown = new Select(val_years);
	     yearDropdown.selectByValue("1991");
    }
    public void register() {
    	btn_register.click();
    }
    public void asserdashbord() {
    	txt_asertdashbord.isDisplayed();
    	WebElement assertion= txt_asertdashbord;
		String actuelleText = assertion.getText();
		System.out.println(actuelleText);
		Assert.assertEquals("Your account has been created.", actuelleText);
    }
    
    public void quit() throws InterruptedException {
		  Thread.sleep(2000);
		  if (driver != null) {
	            driver.quit();  // Ferme la session uniquement à la fin
	        }
	  }

}
