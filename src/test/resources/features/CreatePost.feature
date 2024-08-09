Feature: User posts an image with description

  Scenario: User uploads an image from their local device and provides a description for it
    Given user is on the "http://localhost:5173/login" login page to login before
    And user enters "test1" and "test" credentials
    And  user clicks on the login button to login
    When user clicks on the Create Post button on the home page
    And user writes description
    And user uploads an image file
    And user clicks on the Create Post button
    Then user sees the uploaded image