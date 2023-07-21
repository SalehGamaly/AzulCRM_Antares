Feature: Add Department
  Agile story:  As a user, I should be able to use functions on Company Structure under Employee menu.

  Background:
    Given user is on the login page of the AzulCRM application

  Scenario: Hr user should be able to add a department from the company structure.
    Given user enters hr username
    And user enters hr password
    Then user sees Company Structure  in the employee menu
    And user hr can click add department
    Then user hr input "AzulCRM" department name
    And user hr select " .  . Quality Assurance and Test Department" parent department


  Scenario: There is no “ADD DEPARTMENT” option for Helpdesk
    Given user enters Helpdesk username
    And user enters Helpdesk password
    Then user clicks employee menu
    Then user Helpdesk verify there is no ADD DEPARTMENT option


  Scenario: There is no “ADD DEPARTMENT” option for Marketing user
    Given user enters Marketing username
    And user enters Marketing password
    Then user clicks employee menu
    Then user Marketing verify there is no ADD DEPARTMENT option