@TEC-107

  Feature: The most expansive product verification in the cart
    Scenario: Add to cart the most expensive products and verify that the product is there
      Given Navigate to sign in page
      And Clicks on sign in button
      And enter the credentials email "nargiza1517@gmail.com" and password "123456789"
      Then User adds the most expensive item into a cart
      Then User verifys it in Order History