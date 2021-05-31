package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.actions.HomePageActions;

public class HomeSteps {
    private World world;
    HomePageActions homePageActions = new HomePageActions();

    public HomeSteps(World world) {
        this.world = world;
    }

    @Given("^I am to the Home page \"([^\"]*)\" logging in$")
    public void i_am_on_the_home_page_without_logging_in(String loginState) {
        if(loginState.equalsIgnoreCase("without"))
            Assert.assertEquals(homePageActions.getNumFeedElements().longValue(), 2);
        else if(loginState.equalsIgnoreCase("after"))
            Assert.assertEquals(homePageActions.getNumFeedElements().longValue(), 3);
    }

    @Then("I should see atleast {int} posts")
    public void i_should_see_atleast_posts(Integer numArticles) {
        Assert.assertTrue(homePageActions.getArticleLinks().size() >= numArticles);
    }

    @And("^I \"([^\"]*)\" see Favorite button \"([^\"]*)\"$")
    public void i_see_favorite_button_for_article(String seeNoSee, String addnlText) {
        if(seeNoSee.equalsIgnoreCase("should not")) {
            Assert.assertTrue(homePageActions.getFavoriteButtons().size() == 0);
        } else {
            Assert.assertTrue(homePageActions.getFavoriteButtons().size() > 0);
        }
    }

    @And("I click on article {int} that is displayed")
    public void i_click_on_article_that_is_displayed(Integer articleNum) {
        articleNum = articleNum % 10; //This is to ensure that the articleNum is between 1 to 10 for this exam

        //If the number of articles on page is less than the requested number, we will click on first article instead
        if(articleNum < homePageActions.getArticleLinks().size())
            homePageActions.getArticleLink(articleNum).click();
        else
            homePageActions.getArticleLink(1).click();
    }

    @And("^I navigate to \"([^\"]*)\" tab$")
    public void i_navigate_to_tab(String tabName) {
        if(tabName.equalsIgnoreCase("global feed"))
            homePageActions.navigateToGlobalFeed();
        else if(tabName.equalsIgnoreCase("global feed"))
            homePageActions.navigateToMyActivity();
    }

    @And("I favorite article number {int}")
    public void i_favorite_article_number(Integer articleNum) {
        articleNum = articleNum % 10; //This is to ensure that the articleNum is between 1 to 10 for this exam

        if(articleNum < homePageActions.getArticleLinks().size())
            articleNum = 1;

        homePageActions.favoriteArticle(articleNum);
    }

    @And("I see that the article number {int} is marked as favorite")
    public void i_see_that_article_number_is_favorite(Integer articleNum) {
        articleNum = articleNum % 10; //This is to ensure that the articleNum is between 1 to 10 for this exam

        if(articleNum < homePageActions.getArticleLinks().size())
            articleNum = 1;

        String favoriteBtnClass = homePageActions.getFavoriteButtons().get(articleNum-1).getAttribute("class").trim();
        Assert.assertTrue(favoriteBtnClass.toLowerCase().contains("btn-primary"));
    }
}