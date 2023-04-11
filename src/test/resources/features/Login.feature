@regression
Feature: Login

  Scenario: Launch Helpdesk
    Given Launch Helpdesk Portal
    When User Clicks on Login with SSO button
    And User Login with "Userid" and "Password"
    And User click on Employee view
    And User click on Support view

  Scenario: User enters Wrong Credentials
    Given Launch Helpdesk Portal
    And User Clicks on Login with SSO button
    And User Login wrong "Userid" and "Password"

