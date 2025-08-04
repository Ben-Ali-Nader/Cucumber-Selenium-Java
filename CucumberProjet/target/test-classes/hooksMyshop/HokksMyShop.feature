Feature: Test functionality of the My Shop website

  @s1
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

  @s2
  Scenario Outline: Sign up with email address
    Given the brow <browser> is open
    And user clicks on the Sign Up button
    When user enters email
    And user clicks create account
    Then user receives the registration form
    And user fills out the form:
      | First Name | Last Name | Password |
      | <fname>    | <lname>   | <pwd>    |
    And user click sur button Register
    Then user is navigated to the dashboard

    Examples: 
      | fname | lname   | pwd      | browser            |
      | Nader | Ben Ali | nader123 | automationpractice |

  @s3
  Scenario Outline: Authentification réussie avec des identifiants valides
    Given user est sur la <PConnexion>
    When user entre un email valide <username>
    And user entre un mot de passe valide <password>
    And user clique sur le bouton Sign In
    Then user est redirigé vers la page daccueil de son compte

    Examples: 
      | username               | password | PConnexion         |
      | nadbenali.it@gmail.com | nader123 | automationpractice |
