package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.SIngInPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReports_TestNG {
	WebDriver driver;
	 ExtentReports extent; // Déclaration d'ExtentReports
     ExtentTest test; 
	String email;
	
	@BeforeSuite
	public void setup() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");

        // Initialiser ExtentReports et attacher le Spark reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Ajouter des informations système au rapport
        extent.setSystemInfo("Tester", "Nader Ben Ali");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");
		
	}
	
	
	@BeforeTest
	public void lunchbrowser() {
		
		WebDriverManager.edgedriver().setup(); 
		driver = new EdgeDriver(); 
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void test1() throws InterruptedException {
		    test = extent.createTest("Sample Test Case");
		    
		    driver.get("https://api.cogmento.com/register/?lang=en-GB");
		    test.log(Status.INFO, "test whit invalid email");
		    test.pass("user et sur home page du site ");
			SIngInPage page = new SIngInPage(driver);
			
			page.assert_pagehome();
			
			page.setupemail();
			test.pass("generation du email");
			email = page.getRandomEmail();
			page.enter_email(email);
			test.pass("user enter email invalid");
			page.checkbooxagree();
			test.pass("user click check box agree");
			page.checkrobot();
			test.fail("user click check je suis pas un robot ");
			test.addScreenCaptureFromPath("screnn.png");
			page.login();
			test.pass("user click login ");
			page.AssertionRegistre();
			test.info("user recoi un message erreur  ");

	}
	
	
	
	
	
	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		
		
	}
	
	@AfterSuite
	public void getreporter() {
		 extent.flush();
		
	}
	

}
