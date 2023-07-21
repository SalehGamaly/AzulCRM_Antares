Feature: Poll Creation
  User Story:
  As a user, I should be able to create a poll by clicking on Poll tab under Activity Stream.

  Background:
    Given User is on the log in page
    When User enter the username
    And user enter the password
    And user click to log in button



  Scenario: The delivery should be to 'All employees' by default.
    And user click to Poll button
    Then verify All employees set by default


  Scenario:  User should be able to create a poll by adding questions and multiple answers.
    Given user click to Poll button
    When user enter a simple message " HELLO "
    And user enter the question "what is your favorite color?".
    And user enter the first answer "Black"
    And user enter the second answer "Red"
    Then user click to send button

  Scenario:  User should be able to select the “Allow multiple choice” checkbox.
    Given user click to Poll button
    Then user select the allow multiple choice checkbox

  Scenario: Error message: "Please specify at least one person."
    Given user click to Poll button
    When user enter a simple message " HELLO "
    And user enter the question "what is your favorite color?".
    And user enter the first answer "Black"
    And user enter the second answer "Red"
    And user click to the unselect button
    And user click to send button
    Then verify the  Error message is Please specify at least one person.

  Scenario: Error message: "The message title is not specified
    Given user click to Poll button
    When user click to send button
    Then verify the Error message is The message title is not specified

  Scenario: Error message: "The question "your favorite color ?" has no answers."
    Given user click to Poll button
    When user enter a simple message " HELLO "
    And user enter the question "what is your favorite color?".
    And user click to send button
    Then user verify the question what is your favorite color? has no answers.

  Scenario: Error message: "The question text is not specified."
    Given user click to Poll button
    When user enter a simple message " HELLO "
    And user enter the first answer "Black"
    And user click to send button
    Then user should see the erreur message the question text is not specified.











