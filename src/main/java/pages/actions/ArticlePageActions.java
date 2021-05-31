package pages.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.locators.ArticlePageLocators;
import utils.SeleniumDriver;

import java.util.List;

public class ArticlePageActions {
    ArticlePageLocators articlePageLocators = null;

    public ArticlePageActions() {
        this.articlePageLocators = new ArticlePageLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), articlePageLocators);
    }

    public List<WebElement> getFavoriteButtons() {
        return articlePageLocators.favoriteButtons;
    }

    public WebElement getTopFavoriteButton() {
        return articlePageLocators.topFavoriteButton;
    }

    public void favoriteArticle() {
        String favoriteBtnClass = getTopFavoriteButton().getAttribute("class").trim();

        if(favoriteBtnClass.toLowerCase().contains("btn-outline-primary")) //Ensuring article is not already favorited
            articlePageLocators.topFavoriteButton.click();
    }
}