package steps;

import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.actions.ArticlePageActions;
import pages.actions.HomePageActions;

public class ArticleSteps {
    private World world;
    ArticlePageActions articlePageActions = new ArticlePageActions();

    public ArticleSteps(World world) {
        this.world = world;
    }

    @And("^I \"([^\"]*)\" see Favorite button inside article$")
    public void i_see_favorite_button_for_inside_article(String seeNoSee) {
        if(seeNoSee.equalsIgnoreCase("should not")) {
            Assert.assertTrue(articlePageActions.getFavoriteButtons().size() == 0);
        } else {
            Assert.assertTrue(articlePageActions.getFavoriteButtons().size() > 0);
        }
    }

    @And("^I \"([^\"]*)\" see that the article is marked as favorite in detail view$")
    public void i_see_that_article_is_marked_favorite(String yesNo) {
        String favoriteBtnClass = articlePageActions.getTopFavoriteButton().getAttribute("class").trim();

        if(yesNo.equalsIgnoreCase("should"))
            Assert.assertTrue(favoriteBtnClass.toLowerCase().contains("btn-primary"));
        else if(yesNo.equalsIgnoreCase("should not"))
            Assert.assertTrue(favoriteBtnClass.toLowerCase().contains("btn-outline-primary"));
    }
}