package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashbord {
    WebDriver driver;

    @FindBy(xpath = "//*[@class='x1lliihq x1plvlek xryxfnj x1n2onr6 x1ji0vk5 x18bv5gf x193iq5w xeuugli x1fj9vlw x13faqbe x1vvkbs x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x1i8mgoa x163i06a x1kwtg5e x188k2y4 xzsf02u x1yc453h x1ill7wo x41vudc']")
    WebElement assertionSecuriteCompte;
    
    @FindBy(xpath="//*[@class=\"x1lliihq x1plvlek xryxfnj x1n2onr6 x1ji0vk5 x18bv5gf x193iq5w xeuugli x1fj9vlw x13faqbe x1vvkbs x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x1i8mgoa x163i06a x1kwtg5e x188k2y4 xzsf02u x1yc453h x1ill7wo x41vudc\"]")
    WebElement assertionvalidé;

    public dashbord(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public void verifyAccountSecurity() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(assertionSecuriteCompte));
            wait.until(ExpectedConditions.textToBePresentInElement(assertionSecuriteCompte, "Vérifiez vos notifications sur un autre appareil"));

            System.out.println("Attente de l'approbation utilisateur réussie.");
        } catch (Exception e) {
            System.err.println("Erreur lors de la vérification de la sécurité du compte : " + e.getMessage());
        }
    }
    
    public void WaitForApproval () {

        
            try {
                
                // Attendre que l'utilisateur approuve la connexion
            	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300)); // Temps d'attente max : 300 secondes
                WebElement approvalMessage = wait.until(ExpectedConditions.visibilityOf(assertionvalidé));
                

                System.out.println("Connexion approuvée avec succès !");
            } catch (Exception e) {
                System.out.println("Erreur ou temps d'attente dépassé : " + e.getMessage());
            } 
        }
    }

