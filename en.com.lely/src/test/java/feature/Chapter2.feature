Feature: Lely Automation Cases

  Scenario: Verify that the descriptions of each of the search results contain the searched word
    Given Navigate to Url
    When Click the search button
    Then Verify search area appeared
    Then Enter happy into the search area
    Then Click the search icon
    And Verify that the descriptions

  Scenario: Luna EUR Document View
    Given Navigate to Techdocs
    When Click Searhbox
    Then Enter "Luna EUR" and choose it
    Then View the document
    Then Return the main tab
