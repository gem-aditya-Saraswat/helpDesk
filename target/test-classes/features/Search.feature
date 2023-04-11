@regression
Feature: Search
  Scenario: Search with Valid Functionality
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User enter Valid search item as "Sample Ticket"
    And User click on Search button
    Then User verify the search results for "Sample Ticket"
    And User clear the search box
    Then User verify the search box is empty


  Scenario: Search with InValid Functionality
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User enter Invalid search item as "XYZ"
    And User click on Search button
    Then User verify the search results for "XYZ"
