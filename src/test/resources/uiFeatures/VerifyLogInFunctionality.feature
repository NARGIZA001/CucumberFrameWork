
@TEC-101


Feature: Verifying Login Functionality

  Background: Common first steps
    Given Navigate to login Page

  Scenario: Verifying with valid credentials
    Then User logs in with valid credentials username "Tester" password "test"
    And Verify user is in Homepage

    Scenario: Verifying with invalid credentials
      Then User logs in with invalid credentials username "Testers" password "test"
      And Verify user gets error message "Invalid Login or Password."

