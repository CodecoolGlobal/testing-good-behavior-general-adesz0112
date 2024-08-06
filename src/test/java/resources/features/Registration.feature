Feature: User registers
  As a new user, I want to registrate with my credentials,
  so that, I can login after that.

  Scenario: Successful register with valid credentials
    Given user is on the "http://localhost:3000/signup" page
    When user enters "Robert", "Marky" and valid "robmark", "kicim86837@gmail.com" and "password" credentials
    And user clicks on the Create an account button
    Then user should be on the "http://localhost:3000/login" page


