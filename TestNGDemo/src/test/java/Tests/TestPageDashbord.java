package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.Authentification;
import Pages.dashbord;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPageDashbord {

    static WebDriver driver;
    static Authentification auth;
    static dashbord dash;
    static ExtentReports extent;
    static ExtentTest test;

    @BeforeSuite
    public void setupDriverAndReporter() {
        // Setup WebDriver
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/login");

        // Setup ExtentReports
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent.attachReporter(htmlReporter);
    }

    @AfterSuite
    public void teardownDriverAndReporter() {
        // Close WebDriver
        if (driver != null) {
            driver.quit();
        }
        // Finalize ExtentReports
        extent.flush();
    }

    @BeforeTest
    public void initializePages() {
        // Initialize pages
        auth = new Authentification(driver);
        auth.accpte_cockies();
      dash = new dashbord(driver);  // Ensure dash is initialized
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public static void testValidAuthentication() throws InterruptedException {
        test = extent.createTest("Authentication with valid credentials", "Testing valid login flow");
        test.log(Status.INFO, "Starting valid authentication test");
        
        // Perform login steps
        auth.enter_email("20977552");
        test.pass("User entered email");
        auth.enter_passwd("");
        test.pass("User entered password");
        auth.SeConnecter();
        test.pass("User clicked on login");

        // Wait for UI to stabilize
        Thread.sleep(2000);

        test.info("Valid authentication test completed successfully");
    }

    @Test
    public static void testAccountSecurityApproval() throws InterruptedException {
        test = extent.createTest("Waiting for user account security approval", "Testing account security flow");
        test.log(Status.INFO, "Starting account security approval test");

        // Ensure dash is initialized before using it
        if (dash != null) {
            dash.WaitForApproval();
            test.pass("User approved account security successfully");
            System.out.println("je suis laaaaaaa");
            Thread.sleep(5000);
            System.out.println("je suis la");
        } else {
            test.fail("Dashbord object is not initialized");
        }
    }
}
