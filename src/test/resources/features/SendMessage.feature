@wip
Feature: Send Messages

  User story:
  As a user I want to be able to send messages,
  So that I can communicate with other employees.


  Scenario: Send Message with Mandatory Fields
    Given user logged in as "HR"
    When user is on the Activity Stream page
    And user clicks on the Message tab
    And user fills in the message content and recipient fields
    And user clicks on the Send button
    Then the message should be sent to the recipient


    Scenario: Send Message with Missing Message Content
    Given user logged in as "HR"
    When user is on the Activity Stream page
    And user clicks on the Message tab
    And user clicks on the Send button without filling in the message content
    Then user should see an error message that says "The message title is not specified"


    Scenario: Send Message with Empty Recipient Field
    Given user logged in as "HR"
    When user is on the Activity Stream page
    And user clicks on the Message tab
    And user clicks on the Send button without a selected recipient
    Then user should see a recipient error message that says "Please specify at least one person."


    Scenario: Message Delivery to All Employees by Default
    Given user logged in as "HR"
    When user is on the Activity Stream page
    And user clicks on the Message tab
    And user fills in the message content
    And the message delivery should be to "All employees"
    Then user clicks on the Send button without specifying any recipients



    Scenario: Cancel Sending Message
    Given user logged in as "HR"
    When user is on the Message tab
    And user fills in "Test Scenario" message
    And user clicks on the Cancel button
    Then the message should be cancelled
