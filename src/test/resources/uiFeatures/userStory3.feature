@TEC-106

Feature:Price Calculation

  Scenario: Add to cart 5 products and verify the total amount
    Given Navigate to sign in page
    When User scrolls down and add five items into cart
    Then User Verifies the total amount of the items in the cart