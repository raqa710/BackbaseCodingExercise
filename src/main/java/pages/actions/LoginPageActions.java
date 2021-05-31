package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.HomePageLocators;
import pages.locators.LoginPageLocators;
import utils.SeleniumDriver;

public class LoginPageActions {
    LoginPageLocators loginPageLocators = null;
    HomePageLocators homePageLocators = null;

    public LoginPageActions() {
        this.loginPageLocators = new LoginPageLocators();
        this.homePageLocators = new HomePageLocators();

        PageFactory.initElements(SeleniumDriver.getDriver(), loginPageLocators);
        PageFactory.initElements(SeleniumDriver.getDriver(), homePageLocators);
    }

    public void enterLoginCredentials(String userName, String pass) {
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(loginPageLocators.signInHeader));

        loginPageLocators.usernameTxtbox.sendKeys(userName);
        loginPageLocators.passwordTxtbox.sendKeys(pass);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPageLocators.signInBtn.click();

        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(homePageLocators.settingsLink));
    }
}