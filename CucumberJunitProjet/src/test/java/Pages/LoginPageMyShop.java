/*package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageMyShop {
	WebDriver driver;
	
	
	
	
	By txt_username = By.id("email");
	By txt_password = By.id("passwd");
	By btn_login = By.id("SubmitLogin");
	By txt_home = By.xpath("//*[@class='page-heading']");
	By btn_home = By.xpath("//*[@title='Return to Home']");
	
	public LoginPageMyShop(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public void lunchBrowserMyShop() {
		WebDriverManager.chromedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		if(!driver.getTitle().equals("Login - My Shop")) {
		throw new IllegalStateException("this is not page My Shop Login , la page courante est "+ driver.getCurrentUrl());
				
	}}
	public void enterusername(String username) {
		
		driver.findElement(txt_username).sendKeys(username);
		
	}
	
    public void enterpassword(String password) {
		
		driver.findElement(txt_password).sendKeys(password);
		
	}
    
    public void clicklogin() {
		
		driver.findElement(btn_login).click();
		
	}
    
    public void dashbordIsDisp() {
    	driver.findElement(txt_home).isDisplayed();
    	driver.findElement(btn_home).click();
    
    }
    public void loginValidUser(String username , String password) {
    	driver.findElement(txt_username).sendKeys(username);
    	driver.findElement(txt_password).sendKeys(password);
    	driver.findElement(btn_login).click();
    	
    }
    public void quit() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.close();
		  driver.quit();
	  }
   

}*/
