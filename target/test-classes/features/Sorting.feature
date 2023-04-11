@regression
Feature: Sorting

  Scenario: Sorting data
    Given User Do Login with "Userid" and "Password" on "Employee" view
    And User sorts "ID" column
    And User sorts "Department" column
    And User sorts "Subject" column
    And User sorts "Created on" column
    And User sorts "Assigned to" column
    And User sorts "Status" column
