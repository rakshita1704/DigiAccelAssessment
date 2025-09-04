package TestSteps;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import TestBase.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
	static WebDriver driver;
	static Logger logger;
	
		@Before
		public static void setup() {
			driver = BaseClass.initializeDriver();
			logger = BaseClass.getLogger();
		}

		@After
		public static void teardown() {
			driver.quit();
			logger.info("Closed browser");
		}

		@AfterStep
	    public void handleAlertAfterStep(Scenario scenario) {
	        handleAlertIfPresent(driver);
	    }

    // ✅ Alert handler method
    public static void handleAlertIfPresent(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            logger.info("Alert found: " + alert.getText());
            alert.accept(); // Clicks OK button
            logger.info("Alert closed.");
        } catch (NoAlertPresentException e) {
            // No alert present
        } catch (Exception e) {
            logger.error("Error while handling alert: " + e.getMessage());
        }
    }



//		@AfterStep
//	    public void addScreenshot(Scenario scenario) {
//	        TakesScreenshot ts=(TakesScreenshot) driver;
//	        byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
//	        scenario.attach(screenshot, "image/png",scenario.getName());
//	    }
}
