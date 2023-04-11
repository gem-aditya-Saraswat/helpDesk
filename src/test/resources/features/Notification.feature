@regression
Feature: Notification

  Scenario: Verify unread notification count Employee View
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User check for notification header count
    And User clicks on notification button
    And User clicks on "Unread"
    Then User verify the notification count

  Scenario: Mark all notifications as Read Employee View
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User check for unread notifications
    And User clicks on notification button
    And User mark all notification as read
    Then User verify the notification count

  Scenario: Notification show more and ticket click functionality Employee View
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User clicks on notification button
    Then User verify the Show More working
    And User clicks on a Ticket from Notifications
    Then User verify the ticket details page

  Scenario: Verify unread notification count Support View
    Given User Do Login with "Userid" and "Password" on "Support" view
    When User check for notification header count
    And User clicks on notification button
    And User clicks on "Unread"
    Then User verify the notification count

  Scenario: Mark all notifications as Read Support View
    Given User Do Login with "Userid" and "Password" on "Support" view
    When User check for unread notifications
    And User clicks on notification button
    And User mark all notification as read
    Then User verify the notification count

  Scenario: Notification show more and ticket click functionality Support View
    Given User Do Login with "Userid" and "Password" on "Support" view
    When User clicks on notification button
    Then User verify the Show More working
    And User clicks on a Ticket from Notifications
    Then User verify the ticket details page