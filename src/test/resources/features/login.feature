@login
Feature: Users should be able to login

  Background: User is already in the log in page
    Given the user is on the login page

  Scenario: Verify login with different user types
    Given  user logged in as "<userType>"
    Given  user logged in with username as "User1" and password as "UserUser123"