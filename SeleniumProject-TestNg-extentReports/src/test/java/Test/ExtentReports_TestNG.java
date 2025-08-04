package Test;

import java.io.IOException;

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
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Pages.SIngInPage;
import Pages.invalidemail;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ExtentReports_TestNG {
	WebDriver driver;
	ExtentReports extent; 
	ExtentHtmlReporter htmlReporter;

	String email;

	@BeforeSuite
	public void setup() {
		extent = ExtentManager.createInstance("extent.html");
		htmlReporter = new ExtentHtmlReporter("extent.html");
	    
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

	}
	@AfterSuite
	public void getreporters () {
        // Finaliser le rapport Extent
        extent.flush();
    }


	@BeforeTest
	public void lunchbrowser() {

		WebDriverManager.edgedriver().setup(); 
		driver = new EdgeDriver(); 
		driver.manage().window().maximize();

	}


	@Test
	public void test1() throws InterruptedException, IOException {

		ExtentTest test1 = extent.createTest("MyFirstTest1", "Sample description");

		driver.get("https://api.cogmento.com/register/?lang=en-GB");
		test1.log(Status.INFO, "test whit singin invalid email");
		test1.pass("user et sur home page du site ");
		SIngInPage page = new SIngInPage(driver);

		page.assert_pagehome();

		page.setupemail();
		test1.pass("generation du email");
		email = page.getRandomEmail();
		page.enter_email(email);
		test1.pass("user enter email invalid");
		page.checkbooxagree();
		test1.pass("user click check box agree");
		page.checkrobot();
		test1.fail("user click check je suis pas un robot ");
		test1.addScreenCaptureFromPath("screnn.png");
		page.login();
		test1.pass("user click login ");
		page.AssertionRegistre();
		test1.info("user recoi un message erreur  ");

	}

	@Test
	public  void RegistreinValidEmail() throws InterruptedException {
		ExtentTest test2 = extent.createTest("MyFirstTest2", "Sample description");
		driver.get("https://www.freecrm.com/fr");
		test2.log(Status.INFO, "test whit login invalid email");
		test2.pass("user et sur home page du site ");
		invalidemail invalid = new invalidemail(driver);       
		invalid.clickConnexion();
		test2.pass("user click sur btn conenxion");
		invalid.assert_pageinscription();       
		String filePath = "src/main/resources/credentials.xml";       
		String email = invalid.getEmail(filePath);
		invalid.enter_email(email); 
		test2.pass("user enter email invalid");
		String pwd = invalid.getPassword(filePath);
		invalid.enter_pasword(pwd);  
		test2.pass("user enter mdw invalid");
		invalid.login();
		test2.pass("user click login");
		invalid.asserInvalidCompte();

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