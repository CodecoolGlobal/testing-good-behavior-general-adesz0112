Feature: User posts an image with description

  Scenario: User uploads an image from their local device and provides a description for it
    Given user is on the "http://localhost:5173/login" page
    And user enters "test1" and "test"
    And  user clicks on the login button
    When user clicks on the Create Post button on the home page
    And user writes description
    And user uploads an image file
    And user clicks on the Create Post button
    Then user sees the uploaded image