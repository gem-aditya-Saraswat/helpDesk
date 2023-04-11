@regression
Feature: Dashboard Employee View
  Scenario: Verify LoggedIn User Details
    Given User Clicks on Login with SSO button
    And User Login with "Userid" and "Password"
    And User click on Employee view
    Then Verify loggedIn user details as Aditya Saraswat and Technical Trainee


  Scenario: Side Menu Button functionality
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User clicks on Side Menu button
    Then Verify collapse of side menu
    And  User clicks on Side Menu button
    Then Verify expansion of side menu

  Scenario: Contact us functionality check
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User clicks on contact us button
    Then User Verify contact email presence
    And  User closes the contact us panel

  Scenario: User guide verification
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When Click on User Guide Button
    Then Verify New tab open
    Then Verify user Guide

  Scenario: Log out button functionality
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User clicks on logout button
    Then Verify user logged out successfully

  Scenario: Verify Rows per page
    Given User Do Login with "Userid" and "Password" on "Employee" view
    And User selects "5" Rows per page from dropdown
    Then User verifies that the number of rows per page equal to the "5"
    And User selects "10" Rows per page from dropdown
    Then User verifies that the number of rows per page equal to the "10"
    And User selects "25" Rows per page from dropdown
    Then User verifies that the number of rows per page equal to the "25"

  Scenario: HelpDesk, Verify Next/Previous Button functionalities
    Given User Do Login with "Userid" and "Password" on "Employee" view
    Then  User verify Next button should be enabled on first page
    Then User verify Previous button should be disabled on first page
    And User clicks on Next button and verify that the previous button is enabled
    Then User clicks on Previous button and verify that it is disabled now