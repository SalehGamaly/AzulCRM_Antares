@login
Feature: Users should be able to login

  Background: User is already in the log in page
    Given the user is on the login page

  Scenario Outline: Verify login with different user types
    Given  user logged in with "<username>" and "<password>"
    Examples:
      | username                       | password |
      | hr11@cybertekschool.com        | UserUser |
      | helpdesk11@cybertekschool.com  | UserUser |
      | marketing11@cybertekschool.com | UserUser |


  Scenario Outline: Verify login with different user types
    Given user logged in as "<userType>"

    Examples:
      | userType  |
      | hr       |
      | helpdesk |
      | marketing |


