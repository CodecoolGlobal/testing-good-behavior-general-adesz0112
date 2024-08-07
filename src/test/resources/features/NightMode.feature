Feature: User can use night mode
  As a user I want to use the night mode feature, so I can change between night and day mode

  Background:
    Given user is on the "http://localhost:5173/login" page with valid "test1" and "test" credentials

  Scenario:
    When user clicks on the night mode button
    Then the background color of the page is changed


    Scenario:
      And the page is in night mode
      When user clicks on the day mode button
      Then the background color of the page is changed
