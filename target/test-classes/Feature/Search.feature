


@search
Feature: Verify search fnctionality

  Background: 
    Given User is already logged in the application



  Scenario: Search for a valid product
    And User enters a valid prodct in the search filed
    And Clicks on the seach button
    Then the valid product should be displayed


  Scenario: Search for a invalid product
    And User enters an invalid prodct in the search filed
    And Clicks on the seach button
    Then the customer should be informed about the non eistance of the product
