package Pages;

import java.util.Random;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class invalidemail {

	WebDriver driver;
	

	@FindBy(xpath="//*[@class='background']")
	WebElement txt_pagehome;

	@FindBy(xpath="//*[@rel=\"noopener noreferrer\" and contains (text(),'Connexion')]")
	WebElement btn_conenxion;

	@FindBy(xpath="//*[@class='ui stacked segment']")
	WebElement iframe_email_password_connexion;

	@FindBy(xpath="//*[@placeholder='e-mail']")
	WebElement txt_enteremail;

	@FindBy(xpath="//*[@placeholder='mot de passe']")
	WebElement txt_password;

	@FindBy(xpath="//*[@class='ui fluid large blue submit button']")
	WebElement login_connexion;

	@FindBy(xpath="//*[@class='ui negative message']")
	WebElement assert_invalid_compte;


	public invalidemail(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}


	public void assert_pagehome() {
		btn_conenxion.isDisplayed();
		String assertion = btn_conenxion.getText();
		System.out.println(assertion);
		Assert.assertEquals("CONNEXION", assertion);
	}


	public void assert_pageinscription() {
		String titre = driver.getTitle();
		System.out.println(titre);
		Assert.assertEquals("Cogmento CRM", titre);
	}


	public void clickConnexion() {
		String mainWindowHandle = driver.getWindowHandle();
		btn_conenxion.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(driver -> driver.getWindowHandles().size() > 1);
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle); 
				break;
			}
		}

		wait.until(ExpectedConditions.titleContains("Cogmento CRM"));

	}



	public static String getEmail(String filePath) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(filePath);
			Element root = document.getDocumentElement();
			return root.getElementsByTagName("emailInvalid").item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getPassword(String filePath) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(filePath);
			Element root = document.getDocumentElement();
			return root.getElementsByTagName("passwordinvalid").item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void enter_email(String email) {

		txt_enteremail.sendKeys(email);

	}

	public void enter_pasword(String pwd) {

		txt_password.sendKeys(pwd);

	}
	public void login() {
		String mainWindowHandle = driver.getWindowHandle();
		login_connexion.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(driver -> driver.getWindowHandles().size() > 1);
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle); 
				driver.close();
				driver.switchTo().window(mainWindowHandle);
				break;
			}
			

	}}

	public void asserInvalidCompte() {
		assert_invalid_compte.isDisplayed();
		String title = assert_invalid_compte.getText();
		System.out.println(title);

	}

}


