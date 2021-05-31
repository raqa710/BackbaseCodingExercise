@favorite-not-logged-in @favorite @not-logged-in
Feature: Acceptance testing to validate Favorite feature for BBlog website when user is logged in

Background:
  Given I navigate to the BBlog website with valid credentials

  Scenario: Favorite Article: No Login - Home Page: Ensure "Favorite Post" option is not visible when user is not logged in for articles in Home page view
    Given I am to the Home page "without" logging in
    Then I should see atleast 1 posts
    And I "should not" see Favorite button "for first article"

  Scenario: Favorite Article: No Login - Post Page: Ensure "Favorite Post" option should be visible even when user is not logged in for articles in Post page view
    Given I am to the Home page "without" logging in
    Then I should see atleast 1 posts
    And I click on article 1 that is displayed
    And I "should" see Favorite button inside article