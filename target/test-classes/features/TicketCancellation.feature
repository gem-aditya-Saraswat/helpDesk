@regression
Feature: Ticket Cancel
  Scenario: Cancel an Incident without file and Verify
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User create ticket without file with details  Sample ticket, Sample Description text, IT
    And User get the Incident ID
    And User search the Ticket ID
    And User Verify if ticket is cancelled
    And User cancel the ticket
    Then User verify cancel ticket

  Scenario: Cancel an Request without file
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User create request without file with details  Sample ticket, Sample Description text, IT, sample req type, sub type 1
    And User fetches the Request ID
    And User search the Ticket ID
    And User Verify if ticket is cancelled
    And User cancel the ticket
    Then User verify cancel ticket


  Scenario: Cancel an Request with file
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User create ticket with file details Sample ticket, Sample Description text, IT, sample req type, sub type 1 having file on src\test\resources\sample.doc
    And User fetches the Request ID
    And User search the Ticket ID
    And User Verify if ticket is cancelled
    And User cancel the ticket
    Then User verify cancel ticket

  Scenario: Cancel an Incident with file
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User create incident with file details Sample ticket, Sample Description Text, IT having file on src\test\resources\sample.doc
    And User get the Incident ID
    And User search the Ticket ID
    And User Verify if ticket is cancelled
    And User cancel the ticket
    Then User verify cancel ticket

  Scenario: Cancel an ticket from ticket details page
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User create ticket without file with details Sample ticket, Sample Description Text, IT
    And User get the Incident ID
    And User search the Ticket ID
    Then User Verify if ticket is cancelled
    Then User verify the ticket cancel without reason not applicable
    And User cancel the ticket through ticket details page
    Then User verify cancel ticket


