package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions(
		features = ".//src//test//resources//Features/",
		glue = "TestSteps",
		plugin = { "pretty", "html:cucumberReports/cucumber-report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@SauceDemoE2E",
		dryRun = false
		)
public class CucumberTest {
	
}
