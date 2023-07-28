Feature: Poll Creation
  User Story:
  As a user, I should be able to create a poll by clicking on Poll tab under Activity Stream.

  Background:
    #  Given user logged in as "<userType>" is enough no need all steps for the features
    Given User is on the log in page
    When User enter the username
    And user enter the password
    And user click to log in button



  Scenario: The delivery should be to 'All employees' by default.
    Given user logged in as "<userType>"
    # And user click to "Poll" button
    And user clicks on the "Poll" tab
    #Do not use verify in Then part,
    #Then "All employees" set by default
    Then verify All employees set by default


  Scenario:  User should be able to create a poll by adding questions and multiple answers.
    Given user click to Poll button
    When user enter a simple message " HELLO "
    And user enter the question "what is your favorite color?".
    And user enter the first answer "Black"
    And user enter the second answer "Red"
    #this is not a verification
    #And user clicks to "Send" button
    #Then the poll is created
    Then user click to send button

  Scenario:  User should be able to select the “Allow multiple choice” checkbox.
    Given user click to Poll button
    #Again no verification here?
    #And user clicks the allow multiple choice checkbox
    #Then the allow multiple choice checkbox is selected
    Then user select the allow multiple choice checkbox

  Scenario: Error message: "Please specify at least one person."
    Given user click to Poll button
    When user enter a simple message " HELLO "
    And user enter the question "what is your favorite color?".
    And user enter the first answer "Black"
    And user enter the second answer "Red"
    And user click to the unselect button
    And user click to send button
    Then "Please specify at least one person" error message is displayed
    Then verify the  Error message is Please specify at least one person.

  Scenario: Error message: "The message title is not specified
    Given user click to Poll button
    When user click to send button
    Then "The message title is not specified" error message is displayed
    Then verify the Error message is The message title is not specified

  Scenario: Error message: "The question "your favorite color ?" has no answers."
    Given user click to Poll button
    When user enter a simple message " HELLO "
    And user enter the question "what is your favorite color?".
    And user click to send button
    Then "the question what is your favorite color? has no answers." error message is displayed
    Then user verify the question what is your favorite color? has no answers.

  Scenario: Error message: "The question text is not specified."
    Given user click to Poll button
    When user enter a simple message " HELLO "
    And user enter the first answer "Black"
    And user click to send button
    Then user should see the erreur message the question text is not specified.











