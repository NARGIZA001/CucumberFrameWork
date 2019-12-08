@TEC-110

Feature:  Color change for item

  Scenario: Choose any item and change the color and verify it is change.
    Given Navigate to sign in page
    Then User selects T-Shirt option
    Then User selects an item
    And  User changes the color of the item
    Then Verifies if the color had changed
