package Utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        BaseTest baseTest = (BaseTest) result.getInstance();
        String screenshotPath = baseTest.takeScreenshot(result.getName());
        try {
            baseTest.test.fail("Test échoué", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
