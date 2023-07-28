@wip
Feature: Send Messages

  User story:
  As a user I want to be able to send messages,
  So that I can communicate with other employees.



  Scenario Outline: Send Message with Mandatory Fields
    Given user logged in as "<userType>"
    When user is on the Activity Stream page
    #"Message" tab--  make dynamic
    And user clicks on the "Message" tab

    #user enters "Test Message SC1" to the message field
    # User adds "h1@" as recipient
    And user fills in the message content and recipient fields

    #user clicks on the "Send" butoon
    And user clicks on the Send button

    #the message is sent to the recipient
    Then the message should be sent to the recipient



    Examples:
      | userType  |
      | hr       |
      | helpdesk |
      | marketing |


    Scenario: Send Message with Missing Message Content
    Given user logged in as "HR"
    When user is on the Activity Stream page
    And user clicks on the Message tab
        #And user does not fill in the message content
      #And user clicks on the "Send" button
    And user clicks on the Send button without filling in the message content
      #user sees "The message title is not specified" error message
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
      #user enters "bla bla" in the message field
    And user fills in the message content
      #Then --- verification--< message delivery is
    Then the message delivery should be to "All employees"
      #No need this part?
    And user clicks on the Send button without specifying any recipients



    Scenario: Cancel Sending Message
    Given user logged in as "HR"
    When user is on the Message tab
    And user fills in "Test Scenario" message
      #user clicks on the "Cancel" button
    And user clicks on the Cancel button
    Then the message should be cancelled
