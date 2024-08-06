Feature: The user can logout from the page
  As a user i want to logout from the page

  Scenario: Successful logout from the home page

    Given user is already logged in "http://localhost:5173/login" with valid "test1" and "test" credentials
    When  user clicks on the logout button
    Then  user is navigated to login page