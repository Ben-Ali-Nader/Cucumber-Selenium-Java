/*package Pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthetificationMyshop {
	WebDriver driver;
	 private String randomEmail;
	
	By btn_SingIn = By.xpath("//*[@title='Log in to your customer account']");
	By txt_email = By.id("email_create");
	By btn_submit = By.id("SubmitCreate");
	By txt_assertformulaire = By.xpath("//*[@class='page-heading']");
	By chx_gender = By.id("id_gender1");
	By txt_firstname = By.id("customer_firstname");
    By txt_lasttname =By.id("customer_lastname");
    By txt_paswword =By.id("passwd");
    By val_day = By.id("days");
    By val_months = By.id("months");
    By val_years = By.id("years");
    By btn_register = By.id("submitAccount");
    By txt_asertdashbord = By.xpath("//*[@class='alert alert-success']");
    
    
    
	
	
	
	public AuthetificationMyshop(WebDriver driver) {
		this.driver = driver;
		
	}
	public void lunchBrowsser() {
		  WebDriverManager.chromedriver().setup();
	        
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize(); 
	        driver.get("http://www.automationpractice.pl/index.php");
		    driver.findElement(btn_SingIn).click();
	}
	
	public void userenteremail(String email) {
		 driver.findElement(txt_email).sendKeys(email);
	}
	
	public void userclickcreateaccount() {
		driver.findElement(btn_submit).click();
       
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
    	WebElement assertion= driver.findElement(txt_assertformulaire);
		String actuelleText = assertion.getText();
		System.out.println(actuelleText);
		Assert.assertEquals("AUTHENTICATION", actuelleText);
    }
    public void remplissageformulaire(DataTable dataTable) {
    	List<Map<String, String>> userDetails = dataTable.asMaps(String.class, String.class);
		Map<String, String> user = userDetails.get(0);
		
		 driver.findElement(chx_gender).click();
		 driver.findElement(txt_firstname).sendKeys(user.get("First Name"));
		 driver.findElement(txt_lasttname).sendKeys(user.get("Last Name"));
		 driver.findElement(txt_paswword).sendKeys(user.get("Password"));
		 
		 Select dayDropdown = new Select(driver.findElement(val_day)); 
	     dayDropdown.selectByValue("31"); 
	     
	     Select monthDropdown = new Select(driver.findElement(val_months));
	     monthDropdown.selectByValue("8"); 
	     
	     Select yearDropdown = new Select(driver.findElement(val_years));
	     yearDropdown.selectByValue("1991");
    }
    public void register() {
    	driver.findElement(btn_register).click();
    }
    public void asserdashbord() {
    	WebElement assertion= driver.findElement(txt_asertdashbord);
		String actuelleText = assertion.getText();
		System.out.println(actuelleText);
		Assert.assertEquals("Your account has been created.", actuelleText);
    }
    
    public void quit() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.close();
		  driver.quit();
	  }

}*/
