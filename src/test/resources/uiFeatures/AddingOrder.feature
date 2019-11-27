
@TEC-102


Feature: Adding order as per user story


  Scenario: Verify create order functionality
    Given Navigate to login Page
    Then User logs in with valid credentials username "Tester" password "test"
    And User clicks on Order
    Then User creates new Order
      | Product Name | Quantity | Customer Name | Street    | City    | State | Zip   | Card Nr    | Expire Date |
      | ScreenSaver  | 2        | Techtorial    | 123N tech | Chicago | IL    | 60000 | 1234567890 | 12/21       |
    Then User verify Order "is" created

    Scenario: Verify create order functionality with invalid data
      Given Navigate to login Page
      Then User logs in with valid credentials username "Tester" password "test"
      And User clicks on Order
      Then User creates new Order
        | Product Name | Quantity | Customer Name | Street    | City    | State | Zip   | Card Nr    | Expire Date |
        | ScreenSaver  | 2        | Techtorial    | 123N tech | Chicago | IL    | zipCode | 1234567890 | 12/21       |
      Then User verify Order "is NOT" created

  @TECTC-1015
  Scenario : Verify Delete functionality
    Given Navigate to login Page
    Then User logs in with valid credentials username "Tester" password "test"
    And User Deletes "<Marks Smith>" from table
    Then User validates that "<Mark Smith>" is deleted
    Examples:
      | Name           |
      | Mark Smith     |
      | Samuel Clemens |
      |Paul Brown|
