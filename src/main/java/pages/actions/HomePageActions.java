package pages.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.locators.HomePageLocators;
import utils.SeleniumDriver;

import java.util.List;

public class HomePageActions {
    HomePageLocators homePageLocators = null;

    public HomePageActions() {
        this.homePageLocators = new HomePageLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), homePageLocators);
    }

    public Integer getNumFeedElements() {
        return homePageLocators.homeFeedLinks.size();
    }

    public List<WebElement> getArticleLinks() {
        return homePageLocators.articleLinks;
    }

    public WebElement getArticleLink(Integer articleNum) {
        return homePageLocators.articleLink(articleNum);
    }

    public List<WebElement> getFavoriteButtons() {
        return homePageLocators.favoriteButtons;
    }

    public void clickSignIn() {
        homePageLocators.signInLink.click();
    }

    public void navigateToGlobalFeed() {
        homePageLocators.globalFeedLink.click();
    }

    public void navigateToMyActivity() {
        homePageLocators.myActivityLink.click();
    }

    public void favoriteArticle(Integer articleNum) {
        String favoriteBtnClass = getFavoriteButtons().get(articleNum-1).getAttribute("class").trim();

        if(favoriteBtnClass.toLowerCase().contains("btn-outline-primary")) //Ensuring article is not already favorited
            homePageLocators.favoriteButton(articleNum).click();
    }

    public void unfavoriteArticle(Integer articleNum) {
        String favoriteBtnClass = getFavoriteButtons().get(articleNum-1).getAttribute("class").trim();

        if(favoriteBtnClass.toLowerCase().contains("btn-primary")) //Ensuring article is not already unfavorited
            homePageLocators.favoriteButton(articleNum).click();
    }
}