package Pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Validemail {
	
	
	WebDriver driver;
	

	@FindBy(xpath="//*[@placeholder='e-mail']")
	WebElement txt_enteremail;

	@FindBy(xpath="//*[@placeholder='mot de passe']")
	WebElement txt_password;
	
	@FindBy(xpath="//*[@class='user-display']")
	WebElement user;
	
	public Validemail(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	public static String getEmail(String filePath) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(filePath);
			Element root = document.getDocumentElement();
			return root.getElementsByTagName("emailvalid").item(0).getTextContent();
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
			return root.getElementsByTagName("passwordvalid").item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void enter_v_email(String email) throws InterruptedException {

		txt_enteremail.sendKeys(email);
		Thread.sleep(2000);

	}

	public void enter_v_pasword(String pwd) throws InterruptedException {

		txt_password.sendKeys(pwd);
		Thread.sleep(2000);

	}
	public void assert_dashbord(){
		user.isDisplayed();
	String message = user.getText();
	System.out.println(message);
	Assert.assertEquals("nader ben ali", message);
	}

}
