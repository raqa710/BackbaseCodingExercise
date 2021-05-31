package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import pages.actions.HomePageActions;
import pages.actions.LoginPageActions;
import utils.SeleniumDriver;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class LoginSteps {
    private World world;
    HomePageActions homePageActions = new HomePageActions();
    LoginPageActions loginPageActions = new LoginPageActions();

    public LoginSteps(World world) {
        this.world = world;
    }

    @Given("^I navigate to the BBlog website with valid credentials$")
    public void i_navigate_to_bblog_website() {
        final String HTTPS_PROTOCOL = "https://";
        String credentials = world.accessUser + ":" + world.accessPass + "@";

        try {
            credentials = URLEncoder.encode(world.accessUser, StandardCharsets.UTF_8.toString()) + ":" + URLEncoder.encode(world.accessPass, StandardCharsets.UTF_8.toString()) + "@";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String testURL = world.testURL;
        String testURLWithAuth = HTTPS_PROTOCOL + credentials + testURL.split(HTTPS_PROTOCOL)[1];

        SeleniumDriver.openPage(testURLWithAuth);
        SeleniumDriver.openPage(testURL);
    }

    @And("^I login with valid credentials$")
    public void i_login_with_valid_credentials() {
        homePageActions.clickSignIn();
        loginPageActions.enterLoginCredentials(world.loginUser, world.loginPass);
    }
}
