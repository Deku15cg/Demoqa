
package TestRun;




import org.junit.runner.RunWith;

import UtilityPackage.ConfigReader;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue={"com.demoqa2Bkp_08022023.StepDefinitions","hook"},
		monochrome = true,
		
		plugin = { "pretty",
				   "html:Reports/htmlReport/Report.html", 
				   "json:target/jsonReport/Cucumber.json",
				   "junit:Reports/junitReport/report.xml",
				   //"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
}
)


public class TestRunner {

		
		
}


