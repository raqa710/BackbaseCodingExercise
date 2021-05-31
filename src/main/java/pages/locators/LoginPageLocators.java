package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageLocators {
    @FindBy(how=How.XPATH, using="//h1[text()='Sign in']")
    public WebElement signInHeader;

    @FindBy(how=How.XPATH, using="//input[@placeholder='Username']")
    public WebElement usernameTxtbox;

    @FindBy(how=How.XPATH, using="//input[@placeholder='Password']")
    public WebElement passwordTxtbox;

    @FindBy(how=How.TAG_NAME, using="button")
    public WebElement signInBtn;
}