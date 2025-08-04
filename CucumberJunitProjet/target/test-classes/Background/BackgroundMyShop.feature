Feature: Test functionality of the My Shop website

  Background: Check the home page
    Given the browser is open
    And the user is on the Google search page
    When the user enters site of My shop in the search box
    And clicks enter
    Then the user is navigated to the search results page
    And the user scrolls to the My Shop site and clicks enter
    Then the user is navigated to the home page
    And the user clicks on the Sign Up button

  
  Scenario Outline: Sign up with email address
    Given the user enters email
    And the user clicks create account
    Then the user receives the registration form
    And the user fills out the form:
      | First Name | Last Name | Password |
      | <fname>    | <lname>   | <pwd>    |
    And the user clicks on the Register button
    Then the user is navigated to the dashboard

    Examples: 
      | fname | lname   | pwd      |
      | Nader | Ben Ali | nader123 |

  
  Scenario Outline: Successful authentication with valid credentials
    Given the user enters a valid email <username>
    And the user enters a valid password <password>
    And the user clicks on the Sign In button
    Then the user is redirected to their account homepage

    Examples: 
      | username               | password |
      | nadbenali.it@gmail.com | nader123 |
