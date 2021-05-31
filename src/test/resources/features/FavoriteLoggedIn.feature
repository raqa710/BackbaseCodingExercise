@favorite-logged-in @favorite @logged-in
Feature: Acceptance testing to validate Favorite feature for BBlog website when user is not logged in

Background:
  Given I navigate to the BBlog website with valid credentials
  And I login with valid credentials

  Scenario: Favorite Article: Logged In - Home Page: Ensure "Favorite Post" option is visible when user is logged in for articles in Home page view
    Given I am to the Home page "after" logging in
    And I navigate to "Global Feed" tab
    Then I should see atleast 1 posts
    And I "should" see Favorite button "for first article"

  Scenario: Favorite Article: Logged In - Home Page: Ensure user is able to mark a post as favorite for articles in Home page view
    Given I am to the Home page "after" logging in
    And I navigate to "Global Feed" tab
    Then I should see atleast 1 posts
    And I favorite article number 1
    And I see that the article number 1 is marked as favorite

  Scenario: Favorite Article: Logged In - Home Page: Ensure that the article shows as favorited in Post page view when a user favorites an article in Home page view
    Given I am to the Home page "after" logging in
    And I navigate to "Global Feed" tab
    Then I should see atleast 1 posts
    And I favorite article number 1
    Then I click on article 1 that is displayed
    And I "should" see that the article is marked as favorite in detail view