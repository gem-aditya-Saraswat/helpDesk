@regression
Feature: Calender
  Scenario: Default value Validation
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User navigate to calender button
    Then User verify default value display
    Then User verify selected default value

  Scenario: Select random Date
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User navigate to calender button
    And User select 12-February-2023
    Then User verify Selected 12-February-2023


  Scenario: Verify month and weekday counts
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User navigate to calender button
    And User clicks on "Month" tab
    Then User verify "Month" counts
    Then User verify "Weekday" counts

  Scenario: Specific date range selection and Clear Data functionality
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User navigate to calender button
    And User selected date range with 12-March-2023 and 20-March-2023
    Then User verify expected select range between 12-March-2023 and 20-March-2023
    And User clicks on clear data button
    Then User verify default value display


  Scenario: Verify Previous and Next navigation button
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User navigate to calender button
    Then User verify Click on "Previous" navigate button
    Then User verify Click on "Next" navigate button

