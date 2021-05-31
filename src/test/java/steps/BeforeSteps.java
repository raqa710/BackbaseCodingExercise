package steps;

import io.cucumber.java.Before;
import utils.SeleniumDriver;

public class BeforeSteps {
    @Before
    public static void setUp() {
        SeleniumDriver.setUpDriver();
    }
}
