package Pages;

import java.time.Duration;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SIngInPage {

	WebDriver driver;
	String randomEmail;

	By txt_assertRegisterPage = By.xpath("//*[@aria-label='register']");
	By txt_champemail = By.id("email-input");
	By btn_checkbox_agree = By.id("ageree");
	By btn_checkrobot = By.cssSelector(".recaptcha-checkbox-border");
	By btn_signin = By.id("sign-in-btn");
	By iframe = By.xpath("//iframe[@title='reCAPTCHA']");
	By btn_Sendingit = By.id("sign-in-btn");

	public SIngInPage(WebDriver driver) {
		this.driver = driver;
	}

	public void assert_pagehome() {
		WebElement asser = driver.findElement(txt_assertRegisterPage);
		asser.isDisplayed();
		String assertion = asser.getText();
		System.out.println(assertion);
		Assert.assertEquals("Register", assertion);
	}

	public void enter_email(String email) {
		driver.findElement(txt_champemail).sendKeys(email);
	}

	public void setupemail() {
		randomEmail = generateRandomEmail(); // Appel à la méthode pour générer un email unique
	}

	private String generateRandomEmail() {
		Random rand = new Random();
		return "user" + rand.nextInt(10000) + "@gmail.com"; // Format de l'email unique
	}

	public String getRandomEmail() {
		return randomEmail; // Retourne l'email généré
	}

	public void checkbooxagree() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(btn_checkbox_agree));
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
		Thread.sleep(2000);
	}

	public void checkrobot() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(iframe));
		driver.switchTo().frame(driver.findElement(iframe));
		checkbox = driver.findElement(btn_checkrobot);
		checkbox.click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);

	}

	public void login() {
	
		driver.findElement(btn_signin).click();
	}
	
	public void AssertionRegistre() throws InterruptedException {
		
		WebElement asser = driver.findElement(btn_Sendingit);
		asser.isDisplayed();
		String assertion = asser.getText();
		System.out.println(assertion);
		Assert.assertEquals("[[RESEND_EMAIL]]", assertion);
		asser.click();
		
		Thread.sleep(2000);
		driver.close();
		
	}
}
