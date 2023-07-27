
Feature: Company Structure Function
  Agile story: As a user, I should be able to use functions on Company Structure under Employee menu.

  Background:
    Given user is on the login page of the AzulCRM application

  Scenario: ALl user types should be able to display company structure
    #Given user logged in as "<userType>"
    Given user enters hr username
    And user enters hr password
    #Not verification!
    Then user clicks employee menu
    #And user sees "Company Structure" in the employee menu
    And user sees Company Structure in the employee menu

  Scenario: Login as Helpdesk

    Given user enters Helpdesk username
    And user enters Helpdesk password
    Then user Helpdesk sees Company Structure in the employee menu

  Scenario: Login as Marketing user
    Given user enters Marketing username
    And user enters Marketing password
    Then user marketing sees Company Structure in the employee menu

  Scenario Outline:  <userType> user should be  able to see the company structure
    Given user logged in as "<userType>"
    #And user clicks on "Employees" menu
    #Then user sees "Company Structure" in the employee menu

    Examples:
      | userType  |
      | hr       |
      | helpdesk |
      | marketing |










