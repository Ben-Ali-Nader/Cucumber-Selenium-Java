package StepsDefBackground;


import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/resources/Background/BackgroundMyShop.feature",glue={"StepsDefBackground"},
monochrome = true,

plugin = { "pretty",
		"html:target/reports/ScreeShotHtmlReports/HtmlReportsBackground.html"
		}

 


)

public class BackgroundRunnerTest {

}


/*"junit:target/reports/JunitReports/cucumber.xml",
"json:targetr/reports/JisonReports/cucumber.json"*/

//tags = "@Step1 or @Step2 or @Step3",