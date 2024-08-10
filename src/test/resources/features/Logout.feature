Feature: The user can logout from the page
  As a user i want to logout from the page

  Scenario: Successful logout from the home page

    Given user is on the "http://localhost:5173/login" page
    And  user enters "test1" and "test"
    And user clicks on the login button
    When  user clicks on the logout button
    Then  user is navigated to login page