@TEC-105

Feature: Automationpractice User updates his address

  Scenario:User is updating his address by singing in
    Given Navigate to sign in page
    And Clicks on sign in button
    Then enter the credentials email "nargiza1517@gmail.com" and password "123456789"
    Then User clicks on my addresses option
    And User clicks on update button
    Then User eneter his new address
      | Address  | Apt | City     | State | Zip   |
      | 2010 ave | 900 | New York | NY    | 11235 |
    And User clicks on button SAVE
    Then User validates the old address with new address






