package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.Authentification;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAuthetification {
	WebDriver driver;
	Authentification auth;
	ExtentReports extent; 
	ExtentHtmlReporter htmlReporter;
	
	public TestAuthetification() {
		this.driver=driver;
	}

	@BeforeClass
	public void setup() {
		
		extent = ExtentManager.createInstance("extent.html");
		htmlReporter = new ExtentHtmlReporter("extent.html");
	    
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

	}
	
	@AfterClass
	public void getreporters () {
        // Finaliser le rapport Extent
        extent.flush();
    }
	
	@BeforeSuite
	public void setupdriver() {
		WebDriverManager.edgedriver().setup(); 
		driver = new EdgeDriver(); 
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void teardowndriver() {
	
		driver.quit();
	}
	@BeforeTest
	public void lunchbrowser() {
		auth = new Authentification(driver);
		driver.get("https://www.facebook.com/login");
		auth.accpte_cockies();
	}
	@AfterTest
	public void teardowntest() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void auth_validemail() {
		
		ExtentTest test1 = extent.createTest("authetification valid ", "Sample description");
		test1.log(Status.INFO, "test whit valid email et valid password");
		auth.enter_email("20977552");
	    test1.pass("user entre email");
		auth.enter_passwd("");
		test1.pass("user entre paswword");
		auth.SeConnecter();
		test1.pass("user click se connecter");
	}
	@Test
	public void auth_invalidemail() {
		
		ExtentTest test2 = extent.createTest("authetification valid ", "Sample description");
		test2.log(Status.INFO, "test whit invalid email et invalid password");

		auth.enter_email("");
		test2.pass("user entre email invalid ");
		auth.enter_passwd("");
		test2.pass("user entre paswword invalid");

		auth.SeConnecter();
		test2.pass("user click se connecter");

		auth.isErrorDisplayed();
		test2.fail("messaeg d'erreur");
	}

}
