package pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.SeleniumDriver;

import java.util.List;

public class HomePageLocators {
    @FindBy(how=How.XPATH, using="//div[@class='feed-toggle']//li")
    public List<WebElement> homeFeedLinks;

    @FindBy(how=How.LINK_TEXT, using="Global Feed")
    public WebElement globalFeedLink;

    @FindBy(how=How.LINK_TEXT, using="My Activity")
    public WebElement myActivityLink;

    @FindBy(how=How.XPATH, using="//a[@class='preview-link']")
    public List<WebElement> articleLinks;

    public WebElement articleLink(Integer linkNum) {
        return SeleniumDriver.getDriver().findElement(By.xpath("(//a[@class='preview-link'])[" + linkNum + "]/span"));
    }

    public WebElement favoriteButton(Integer buttonNum) {
        return SeleniumDriver.getDriver().findElement(By.xpath("(//i[@class='ion-heart'])[" + buttonNum + "]/parent::button"));
    }

    public WebElement favoriteButtonNotFavorited(Integer buttonNum) {
        return SeleniumDriver.getDriver().findElement(By.xpath("(//i[@class='ion-heart']/following-sibling::div[text()='0'])[" + buttonNum + "]/parent::button"));
    }

    @FindBy(how=How.XPATH, using="//div[@class='article-preview']//button")
    public List<WebElement> favoriteButtons;

    @FindBy(how=How.XPATH, using="(//div[@class='article-preview']//button)[1]")
    public WebElement firstFavoriteButton;

    @FindBy(how=How.XPATH, using="(//i[@class='ion-heart']/following-sibling::div[text()='0'])[1]/parent::button")
    public WebElement firstFavoriteButtonNotFavorited;

    @FindBy(how=How.LINK_TEXT, using="Sign in")
    public WebElement signInLink;

    @FindBy(how=How.PARTIAL_LINK_TEXT, using="Settings")
    public WebElement settingsLink;
}