@wip

Feature: Add link in message

  Scenario Outline: as a "<userType>" I can attach a link to the specified text

    Given  I am logged in as "<userType>"
    # When I click on the "Message" tab
    When I click on the message tab
    # And I click on the "Link" icon under the message body
    And I click on the Link icon under the message body
    And I enter the "<linkURL>" as url link
    Then I enter the "<linkText>" as link text
    # And I click on the "Save" button
    And I click on the Save button
    And I click on the Send button
    Then link is attached to the "<linkText>" in the message body
    When I click on the link in the message body
    #Then I am navigated to the ...
    Then I should be navigated to the new url and url should contain "<inURL>"

    Then the link should open in a new tab

    Examples:
      | userType  | linkURL        | linkText | inURL  |
      | HR        | www.etsy.com   | etsy     | etsy  |
      | HelpDesk  | www.Amazon.com | amazon   | amazon |
      | Marketing | www.yahoo.com  | yahoo    | yahoo  |
