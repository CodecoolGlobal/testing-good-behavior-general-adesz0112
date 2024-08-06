Feature: Login
  As a user i want to login, with my username and password

  Scenario: Successful login with valid credentials

    Given  user is on the "http://localhost:5173/login" login page
    When   user enters "test1" and "test"
    And    user clicks on the login button
    Then   user is on the home page

    Scenario: Unsuccessful login with invalid credentials

      Given user is on the "http://localhost:5173/login" login page
      When  user enters "test2" and "test2"
      And   user clicks on the login button
      Then  user is on the login page