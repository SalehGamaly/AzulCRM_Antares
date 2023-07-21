Feature: User should be able to upload files and pictures as a message
  User story: As a user, I should be able to upload files and pictures as messages

  @test1
  Scenario: Upload files and pictures in following formats: .pdf, .txt, .jpeg, .png, .docx
    Given user logged in as "HelpDesk"
    When user is on the Home page
    And user clicks on the Message tab
    And user clicks Upload files and images box
    Then user uploads the files as messages in following formats:pdf, txt, jpeg, png, docx


  @test2
  Scenario: Inserting the files and images into the text
    Given user logged in as "HelpDesk"
    When user is on the Home page
    And user clicks on the Message tab
    And user clicks Upload files and images box
    And user uploads the files as messages
    And user clicks Insert in text button
    Then Message box contains the file.

  @test3
  Scenario: Removing files and images at any time before sending.
    Given user logged in as "HelpDesk"
    When user is on the Home page
    And user clicks on the Message tab
    And user clicks Upload files and images box
    And user uploads the files as messages in
    And user clicks the Remove button
    Then user can see the files being removed


