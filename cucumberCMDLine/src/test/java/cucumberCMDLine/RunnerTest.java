package cucumberCMDLine;
   

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Login/Log.feature", 
    glue = "cucumberCMDLine",        
    monochrome = true,
    plugin = {"pretty", "html:target/reports/cucmber.html"}
   
)


public class RunnerTest {

}
