package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Authentification {

    WebDriver driver;

    @FindBy(xpath = "//*[@class=\"x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft\" and contains (text(),'Refuser les cookies optionnels')]")
    WebElement accpt_cockies;

    @FindBy(id = "email")
    WebElement txt_enteremail;

    @FindBy(id = "pass")
    WebElement txt_password;

    @FindBy(name = "login") // Remplacement de l'ID dynamique par une recherche via "name"
    WebElement Se_Connecter;

    @FindBy(xpath = "//*[@class='_9ay7' and contains(text(),'L’e-mail ou le numéro de mobile entré n’est pas associé à un compte.')]")
    WebElement message_erreur;

    public Authentification(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void accpte_cockies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(accpt_cockies));
            accpt_cockies.click();
        } catch (Exception e) {
            System.out.println("Erreur lors de l'acceptation des cookies : " + e.getMessage());
        }
    }

    public void enter_email(String email) {
        txt_enteremail.sendKeys(email);
    }

    public void enter_passwd(String pwd) {
        txt_password.sendKeys(pwd); // Correction de l'élément
    }

    public void SeConnecter() {
        Se_Connecter.click();
    }

    public boolean isErrorDisplayed() {
        try {
            return message_erreur.isDisplayed();
        } catch (Exception e) {
            System.out.println("Erreur lors de la vérification du message d'erreur : " + e.getMessage());
            return false;
        }
    }
}
