Feature: Test functionality of the My Shop website

  @Step1
  Scenario Outline: Check the home page
    Given the browser is open
    And the user is on the Google search page
    When the user enters <siteWeb> in the search box
    And clicks enter
    Then the user is navigated to the search results page
    And the user scrolls to the My Shop site and clicks enter
    Then the user is navigated to the home page

    Examples: 
      | siteWeb            |
      | automationpractice |
