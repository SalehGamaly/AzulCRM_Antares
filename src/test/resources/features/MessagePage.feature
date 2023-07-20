Feature: User should be able to upload files and pictures
  User story: As a user, I should be able to upload files and pictures as messages

  Background:
    Given The user is on "Home" page


  Scenario: Upload files and pictures in following formats: .pdf, .txt, .jpeg, .png, .docx
    Then user sees "Upload files and messages" box
    Then user uploads the files as messages


  Scenario: Inserting the files and images into the text
    Then user uploads the file
    Then user sees "Insert in text" option
    And user clicks "Insert in text" button
    Then user sees file in text.


  Scenario: Removing files and images at any time before sending.
    Then user uploads the file
    And user sees the "Remove" button after uploading
    And user clicks the "Remove" button
    Then user can see the files being removed


