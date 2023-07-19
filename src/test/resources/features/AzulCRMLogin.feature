Feature: AzulCRM login feature

  User Story:
  As a user, I should be able to login with correct credentials to different accounts and should land on the home page
  after successful login.
  Users are: HR, Marketing, Helpdesk

  Background:
    Given user is on the login page of the CRM application

  @HR @smoke
  Scenario: Login as HR
    When user enters HR information
    Then user should land on homepage

  @smoke
  Scenario: Login as Marketing
    When user enters Marketing information
    Then user should land on homepage

  @HelpDesk @smoke
  Scenario: Login as Helpdesk
    When user enters Helpdesk information
    Then user should land on homepage

  @invalidLogin
  Scenario Outline: Login with invalid credential
    When the user login with below "<username>", "<password>"
    Then the user should not be able to log in
    Examples:
      | username                  | password |
      | hr11@cybertekschool.com   | Useruser |
      | hr1005@cybertekschool.com | UserUser |
