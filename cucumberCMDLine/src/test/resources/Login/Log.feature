Feature: Page de connexion

  Scenario: Connexion avec identifiant valide
    Given l'utilisateur ouvre la page de connexion
    When l'utilisateur saisit un identifiant valide
    Then il est redirigé vers la page d'accueil
