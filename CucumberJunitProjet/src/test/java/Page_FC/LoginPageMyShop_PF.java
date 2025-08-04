package Page_FC;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageMyShop_PF {
    private WebDriver driver;

    @FindBy(id = "email")  
    private WebElement user;

    @FindBy(id = "passwd")  
    private WebElement password;

    @FindBy(id = "SubmitLogin")  
    private WebElement submit;

    @FindBy(xpath = "//*[@class='page-heading']")  
    private WebElement home;

    @FindBy(xpath = "//*[@title='Return to Home']")  
    private WebElement btnHome;

    // Constructor
    public LoginPageMyShop_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

   

    public void enterUsername(String username) {
        if (user != null) {
            user.sendKeys(username);
        } else {
            throw new IllegalStateException("The username field was not initialized properly.");
        }
    }

    public void enterPassword(String pwd) {
        if (password != null) {
            password.sendKeys(pwd);
        } else {
            throw new IllegalStateException("The password field was not initialized properly.");
        }
    }

    public void clickLogin() {
        submit.click();
    }

    public boolean isDashboardDisplayed() {
        return btnHome.isDisplayed();
    }

    public void clickDashboardHome() {
        btnHome.click();
    }

    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        if (driver != null) {
            driver.quit();  // Ferme la session uniquement à la fin
        }
        
    }
}