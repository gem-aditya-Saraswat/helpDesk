@regression
Feature: Filter

  Scenario Outline: Filter close and clear all functionality Verification
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User click on filter button
    And User click filter with <Criteria>
    And User close the filter
    Then User Verify the filtered rows on <Department/Status> with <Criteria>
    And User click on filter button
    And User click on clear all filters
    Examples:
      | Criteria | Department/Status |
      | IT       | Department        |

  Scenario: Verify the "Hide cancelled, closed and resolved tickets" functionality verification
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User click on filter button
    And User switches on the toggle for 'Hide cancelled, closed and resolved tickets'
    Then User verify that ticket displayed should not be 'Cancelled, closed or resolved'

  Scenario Outline: Verify is user is able to select Department and Status in Filters
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When User click on filter button
    And User picks the <Department> and <Status>
    Then User Verify the <Department> and <Status>
    Examples:
      | Department                                               | Status                                                                                        |
      | IT                                                       | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | IT                                                       | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | IT                                                       | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | IT                                                       | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | IT                                                       | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | IT                                                       | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | IT                                                       | Closed & Re-opened & Rejected                                                                 |
#      | IT                                                       | Re-opened & Rejected                                                                          |
#      | IT                                                       | Rejected                                                                                      |
#      | HR                                                       | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | HR                                                       | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | HR                                                       | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | HR                                                       | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | HR                                                       | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | HR                                                       | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | HR                                                       | Closed & Re-opened & Rejected                                                                 |
#      | HR                                                       | Re-opened & Rejected                                                                          |
#      | HR                                                       | Rejected                                                                                      |
#      | Accounts                                                 | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | Accounts                                                 | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | Accounts                                                 | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | Accounts                                                 | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | Accounts                                                 | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | Accounts                                                 | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | Accounts                                                 | Closed & Re-opened & Rejected                                                                 |
#      | Accounts                                                 | Re-opened & Rejected                                                                          |
#      | Accounts                                                 | Rejected                                                                                      |
#      | Admin                                                    | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | Admin                                                    | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | Admin                                                    | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | Admin                                                    | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | Admin                                                    | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | Admin                                                    | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | Admin                                                    | Closed & Re-opened & Rejected                                                                 |
#      | Admin                                                    | Re-opened & Rejected                                                                          |
#      | Admin                                                    | Rejected                                                                                      |
#      | test dept                                                | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | test dept                                                | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | test dept                                                | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | test dept                                                | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | test dept                                                | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | test dept                                                | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | test dept                                                | Closed & Re-opened & Rejected                                                                 |
#      | test dept                                                | Re-opened & Rejected                                                                          |
#      | test dept                                                | Rejected                                                                                      |
#      | HR                                                       | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | HR                                                       | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | HR                                                       | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | HR                                                       | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | HR                                                       | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | HR                                                       | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | HR                                                       | Closed & Re-opened & Rejected                                                                 |
#      | HR                                                       | Re-opened & Rejected                                                                          |
#      | HR                                                       | Rejected                                                                                      |
#      | Accounts                                                 | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | Accounts                                                 | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | Accounts                                                 | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | Accounts                                                 | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | Accounts                                                 | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | Accounts                                                 | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | Accounts                                                 | Closed & Re-opened & Rejected                                                                 |
#      | Accounts                                                 | Re-opened & Rejected                                                                          |
#      | Accounts                                                 | Rejected                                                                                      |
#      | Admin                                                    | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | Admin                                                    | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | Admin                                                    | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | Admin                                                    | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | Admin                                                    | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | Admin                                                    | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | Admin                                                    | Closed & Re-opened & Rejected                                                                 |
#      | Admin                                                    | Re-opened & Rejected                                                                          |
#      | Admin                                                    | Rejected                                                                                      |
#      | test dept                                                | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | test dept                                                | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | test dept                                                | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | test dept                                                | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | test dept                                                | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | test dept                                                | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | test dept                                                | Closed & Re-opened & Rejected                                                                 |
#      | test dept                                                | Re-opened & Rejected                                                                          |
#      | test dept                                                | Rejected                                                                                      |
#      | IT & HR                                                  | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | IT & HR                                                  | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | IT & HR                                                  | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | IT & HR                                                  | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | IT & HR                                                  | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | IT & HR                                                  | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | IT & HR                                                  | Closed & Re-opened & Rejected                                                                 |
#      | IT & HR                                                  | Re-opened & Rejected                                                                          |
#      | IT & HR                                                  | Rejected                                                                                      |
#      | IT & HR & Accounts                                       | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | IT & HR & Accounts                                       | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | IT & HR & Accounts                                       | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | IT & HR & Accounts                                       | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | IT & HR & Accounts                                       | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | IT & HR & Accounts                                       | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | IT & HR & Accounts                                       | Closed & Re-opened & Rejected                                                                 |
#      | IT & HR & Accounts                                       | Re-opened & Rejected                                                                          |
#      | IT & HR & Accounts                                       | Rejected                                                                                      |
#      | IT & HR & Accounts & Admin                               | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | IT & HR & Accounts & Admin                               | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | IT & HR & Accounts & Admin                               | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | IT & HR & Accounts & Admin                               | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | IT & HR & Accounts & Admin                               | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | IT & HR & Accounts & Admin                               | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | IT & HR & Accounts & Admin                               | Closed & Re-opened & Rejected                                                                 |
#      | IT & HR & Accounts & Admin                               | Re-opened & Rejected                                                                          |
#      | IT & HR & Accounts & Admin                               | Rejected                                                                                      |
#      | IT & HR & Accounts & Admin & test dept                   | Open & Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected |
#      | IT & HR & Accounts & Admin & test dept                   | Unassigned & Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected        |
#      | IT & HR & Accounts & Admin & test dept                   | Assigned & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                     |
#      | IT & HR & Accounts & Admin & test dept                   | On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                                |
#      | IT & HR & Accounts & Admin & test dept                   | Resolved & Cancelled & Closed & Re-opened & Rejected                                          |
#      | IT & HR & Accounts & Admin & test dept                   | Cancelled & Closed & Re-opened & Rejected                                                     |
#      | IT & HR & Accounts & Admin & test dept                   | Closed & Re-opened & Rejected                                                                 |
#      | IT & HR & Accounts & Admin & test dept                   | Re-opened & Rejected                                                                          |
#      | IT & HR & Accounts & Admin & test dept                   | Rejected                                                                                      |
#      | IT & HR & Accounts & Admin & test dept & Test Department | Open & On Hold & Resolved & Cancelled & Closed & Re-opened & Rejected                         |