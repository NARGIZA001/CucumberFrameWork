@TEC-104
Feature: Etsy Search Functionality


  @TECTC-1012
  Scenario Outline: VAlidate Etsy Search Message
    Given Navigate to Etsy Homepage
    When User searches for "<item>"
    Then Validate search message  has the "<item>" word

    Examples:
      | item   |
      | carpet |
      | 123    |
  @TECTC-1013
  Scenario Outline: Validation each Department of Etsy has valid Title
    Given Navigate to Etsy Homepage
    When User clicks "<department>"
    Then User validate "<title>"
    Examples:
      | department            | title                        |
      | Jewelry & Accessories | Jewelry & Accessories \| Etsy |
      | Clothing & Shoes      | Clothing & Shoes \| Etsy      |
      | Home & Living         | Home & Living \| Etsy         |
      | Wedding & Party       | Wedding & Party \| Etsy       |
      | Toys & Entertainment  | Toys & Entertainment \| Etsy  |

    @TECTC-1014
    Scenario: VALIDATING THE FREE SHIPPING LABLE
      Given Navigate to Etsy Homepage
      Then User input wireless charger in SearchField
      And User clicks on Free Shipping Button
      Then User validates if all items have the "FREE shipping" label

    @TECTC-1015
    Scenario: Validating over price functionality
      Given Navigate to Etsy Homepage
      When User searches for "carpet"
      And User click on over Price checkbox
      Then User verifies all item prices are over that price

