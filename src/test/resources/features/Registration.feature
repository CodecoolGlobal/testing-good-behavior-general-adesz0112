Feature: User registers
  As a new user, I want to registrate with my credentials,
  so that, I can login after that.

  Scenario: Successful register with valid credentials
    Given user is on the "http://localhost:5173/signup" page
    When user enters "John", "Doe" and valid "johndoe", "arvamartin@gmail.com" and "password" credentials
    And user clicks on the Create an account button
    Then user should be on the "http://localhost:5173/login" page


  Scenario: Unsuccessful register with invalid email
    Given user is on the "http://localhost:5173/signup" page
    When user enters "John", "Doe" and valid "johndoe", "arvamartin" and "password" credentials
    And user clicks on the Create an account button
    Then user should not be be on the "http://localhost:5173/login" page


    Scenario: Password too short
      Given user is on the "http://localhost:5173/signup" page
      When user enters "John", "Doe" and valid "johndoe", "john@example.com" and "p" credentials
      And user clicks on the Create an account button
      Then an error message should indicate the password is too short


  Scenario Outline: Successful register with special characters
      Given user is on the "http://localhost:5173/signup" page
      When user enters "<FirstName>", "<LastName>" and valid "<UserName>", "<Email>" and "<Password>" credentials
      And user clicks on the Create an account button
      Then user should be on the "http://localhost:5173/login" page
      Examples:
      |FirstName|LastName|UserName|Email|Password|
      | Little dog    | test          | *test           | examp@email.com             | pass-word  |
      | *username     | .             | pass word       | test_user@testdomain.com    | pass_word  |
      | user123       | test_user     | test_user@domain.com | test_user@domain.com   | pass@word  |
      | ' '           | ' '           | ' '             | test@gmail.com              | ' '        |
      | user@name     | .com*         | qwerty1234      | user@name.com               | qwerty1234 |


  Scenario: Attempting SQL Injection Attack on the Registration Form
    Given user is on the "http://localhost:5173/signup" page
    When user enters "John", "Doe" and valid "johndoe", "fakeemail' OR '1'='1" and "password" credentials
    And user clicks on the Create an account button
    Then The registration should fail or show an error message