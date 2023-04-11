Feature: Dashboard Support View
  Scenario: Verify support view dashboard tab clicks
    Given User Do Login with "Userid" and "Password" on "Support" view
    Then Verify click on "Icon"
    Then Verify click on "dashboard menuitem"
    Then Verify click on "toggle button"
    Then Verify click on "Assigned"
    Then Verify click on "Unassigned"
    Then Verify click on "My Department"
    Then Verify click on "Others"

  