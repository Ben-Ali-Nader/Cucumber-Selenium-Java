Feature: Test functionality authentication

  @Step2
  Scenario Outline: Sign up with email address
    Given user clicks on the Sign Up button
    When user enters email
    And user clicks create account
    Then user receives the registration form
    And user fills out the form:
      | First Name | Last Name | Password |
      | <fname>    | <lname>   | <pwd>    |
    And user click sur button Register
    Then user is navigated to the dashboard

    Examples: 
      | fname | lname   | pwd      |
      | Nader | Ben Ali | nader123 |
