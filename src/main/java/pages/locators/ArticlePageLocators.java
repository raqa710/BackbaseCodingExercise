package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ArticlePageLocators {
    @FindBy(how= How.XPATH, using="(//i[@class='ion-heart']/parent::button)[1]")
    public WebElement topFavoriteButton;

    @FindBy(how= How.XPATH, using="(//i[@class='ion-heart']/parent::button)[2]")
    public WebElement bottomFavoriteButton;

    @FindBy(how=How.XPATH, using="//i[@class='ion-heart']/parent::button")
    public List<WebElement> favoriteButtons;
}