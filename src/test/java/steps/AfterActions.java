package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.SeleniumDriver;

public class AfterActions {
    @AfterStep
    public static void afterStep(Scenario scenario) {
    	WebDriver driver= SeleniumDriver.getDriver();

    	 //if (scenario.isFailed()) {
             byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
             scenario.attach(screenshotBytes, "image/png", "End Screenshot");
         //}
    }

    @After
    public static void tearDown() {
        SeleniumDriver.tearDown();
    }
}