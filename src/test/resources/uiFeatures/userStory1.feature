
@TEC-103
Feature:  Authentication functionality

  Scenario: Create an account verify it is created by signing in (Use Datatable)
    Given Navigate to sign in page
    Then Clicks on sign in button
    And User types Email address
    Then User clicks on account Button
    And User inputs his personal information
    And User inputs his address
      | Title | First Name | Last Name | email address   | password | days|months|years|
      | Mrs.  | Naki       | Kenesh    | narga@gmail.com | hophop   |29   |10    |2010 |
    Then User checks the news letter button
    And User inputs address
      | First name | Last name | Company | Address    | Apt | City    | State | Zip   | Country | Phone     |
      | Naki       | Kenesh    | Tech    | 2200 Devon | 385 | Chicogo | Il    | 10036 | US      | 123456789 |
    Then User clicks on Register Button





