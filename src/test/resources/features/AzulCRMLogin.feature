@wip
Feature: AzulCRM login feature

  User Story:
  As a user, I should be able to login with correct credentials to different accounts and should land on the home page
  after successful login.
  Users are: HR, Marketing, Helpdesk

  Background:
    Given user is on the login page of the CRM application

  @HR @smoke
  Scenario: Positive Login as HR
    When user enters HR information
    Then user should land on homepage

  @smoke
  Scenario: Positive Login as Marketing
    When user enters Marketing information
    Then user should land on homepage

  @HelpDesk @smoke
  Scenario: Positive Login as Helpdesk
    When user enters Helpdesk information
    Then user should land on homepage

  @invalidLogin
  Scenario Outline: Negative Login with invalid credential
    When the user login with below "<username>", "<password>"
    Then the user should not be able to log in
    Examples:
      | username                  | password |
      | hr11@cybertekschool.com   | Useruser |
      | hr1005@cybertekschool.com | UserUser |

  @ignore
    Scenario Outline: Error message should be displayed
      When the user login with below "<username>", "<password>"
      Then User sees “Please fill out the field” error message
    Examples:
      | username                | password |
      | hr11@cybertekschool.com |          |
      |                         | UserUser |


  @rememberMeLink
  Scenario: Remember me link can be clicked
    When the user locates the Remember Me link
    Then the user should be able to click on button before login


  @passwordBullet
  Scenario: Password to the login page should be in bullet signs
      When user enters password information
      Then user should see the password in bullets signs


