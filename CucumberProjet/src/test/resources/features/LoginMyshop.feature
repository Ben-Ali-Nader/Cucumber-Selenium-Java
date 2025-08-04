Feature: Authentification utilisateur

  @Step3
  Scenario Outline: Authentification réussie avec des identifiants valides
    Given user est sur la page de connexion
    When user entre un email valide <username>
    And user entre un mot de passe valide <password>
    And user clique sur le bouton Sign In
    Then user est redirigé vers la page daccueil de son compte

    Examples: 
      | username               | password |
      | nadbenali.it@gmail.com | nader123 |
