package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.SIngInPage;
import Pages.Validemail;
import Pages.dashbord;
import Pages.invalidemail;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SigUpTest {
	 WebDriver driver;
	 String email;

	
	@BeforeTest
	public void setup() {
		
		WebDriverManager.edgedriver().setup(); 
		driver = new EdgeDriver(); 
		driver.manage().window().maximize();
		
	}

	
	@Test(priority = 3)
	public  void SIngInValidEmail() throws InterruptedException {

		
		driver.get("https://api.cogmento.com/register/?lang=en-GB");
		SIngInPage page = new SIngInPage(driver);
		page.assert_pagehome();
		page.setupemail();
		email = page.getRandomEmail();
		page.enter_email(email);
		page.checkbooxagree();
		page.checkrobot();
		page.login();
		page.AssertionRegistre();
		 
	}

@Test(priority = 1)
	public  void RegistreinValidEmail() throws InterruptedException {

		driver.get("https://www.freecrm.com/fr");
		invalidemail invalid = new invalidemail(driver);       
		invalid.clickConnexion();
		invalid.assert_pageinscription();       
		String filePath = "src/main/resources/credentials.xml";       
		String email = invalid.getEmail(filePath);
		invalid.enter_email(email); 
		String pwd = invalid.getEmail(filePath);
		invalid.enter_pasword(pwd);        
		invalid.login();
		invalid.asserInvalidCompte();
	
	}

@Test(priority = 1)
	public  void RegistreValidEmail() throws InterruptedException {

		
		driver.get("https://www.freecrm.com/fr");
		invalidemail invalid = new invalidemail(driver);  
		Validemail valid = new Validemail(driver);
		invalid.clickConnexion();
		invalid.assert_pageinscription();       
		String filePath = "src/main/resources/credentials.xml";       
		String email = valid.getEmail(filePath);
		valid.enter_v_email(email);
		String pwd = valid.getPassword(filePath);
		valid.enter_v_pasword(pwd);        
		invalid.login();
		valid.assert_dashbord();
		System.out.println("je suis la");

	}
@Test(priority = 4)
	public void Creer_un_nouvel_evenement() throws InterruptedException {

	driver.get("https://www.freecrm.com/fr");
	invalidemail invalid = new invalidemail(driver);  
	Validemail valid = new Validemail(driver);
	invalid.clickConnexion();
	invalid.assert_pageinscription();       
	String filePath = "src/main/resources/credentials.xml";       
	String email = valid.getEmail(filePath);
	valid.enter_v_email(email);
	String pwd = valid.getPassword(filePath);
	valid.enter_v_pasword(pwd);        
	invalid.login();
	valid.assert_dashbord();
	System.out.println("je suis la");

		dashbord dash =new dashbord(driver);
		dash.click_accueil();
		dash.check_calendrier();
		dash.ajouter_un_evenement_a_un_date_precis();
		 

	

	}

@AfterTest
	public void tirdown() {
	   
	   //driver.close();
		
		
		
	}












}
