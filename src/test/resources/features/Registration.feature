@registration
Feature: User registers
  As a new user, I want to registrate with my credentials,
  so that, I can login after that.

  Background:
    Given user is on the "http://localhost:5173/signup" page


  Scenario: Successful register with valid credentials
    When user enters "Johnn", "Dooe" and valid "johndooe", "johnndoe@gmail.com" and "password" credentials
    And user clicks on the Create an account button
    Then user should be on the "http://localhost:5173/login" page


  Scenario: Unsuccessful register with invalid email
    When user enters "John", "Doe" and valid "johndoe", "johnDoe" and "password" credentials
    And user clicks on the Create an account button
    Then user should not be be on the "http://localhost:5173/login" page


  Scenario: Password too short
    When user enters "John", "Doe" and valid "johndoe", "john@example.com" and "p" credentials
    And user clicks on the Create an account button
    Then an error message should indicate the password is too short


  Scenario Outline: Successful register with special characters
    When user enters "<FirstName>", "<LastName>" and valid "<UserName>", "<Email>" and "<Password>" credentials
    And user clicks on the Create an account button
    Then user should be on the "http://localhost:5173/login" page
    Examples:
      | FirstName  | LastName  | UserName             | Email                    | Password   |
      | Little dog | test      | *test                | examp@email.com          | pass-word  |
      | *username  | .         | pass word            | test_user@testdomain.com | pass_word  |
      | user123    | test_user | test_user@domain.com | test_user@domain.com     | pass@word  |
      | ' '        | ' '       | ' '                  | test@gmail.com           | ' '        |
      | user@name  | .com*     | qwerty1234           | user@name.com            | qwerty1234 |


  Scenario: Attempting SQL Injection Attack on the Registration Form
    When user enters "John", "Doe" and valid "johndoe", "fakeemail' OR '1'='1" and "password" credentials
    And user clicks on the Create an account button
    Then The registration should fail or show an error message


  Scenario: Responsive UI Test for Registration Page
    When user resizes the window to "1920x1080"
    Then layout should adjust correctly

    When user resizes the window to "768x1024"
    Then layout should adjust correctly

    When user resizes the window to "375x667"
    Then layout should adjust correctly

