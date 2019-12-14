@TEC-112

Feature: HR Management Application
  @TECT-1020
  Scenario: Login as an Admin and change password for Fiona Grace and verify it is changed by signing in again

    Given Navigate to OrangeHR log in page
    Then User logs in with valid username "Admin" password "admin123"
    Then User changes the username "linda.anderson" password "linda321" then sign in again to verify if password has changed



  @TECT-1021
  Scenario: Login to application and go to Leave section
            and verify Linda Anderson’s number leave days properly calculated by going to details of leave and counting the days.
    Given Navigate to OrangeHR log in page
    Then User logs in with valid username "Admin" password "admin123"
    And User clicks on leave days and chosses Linda Anderson's number
    Then User verifies if Linda Anderson's leave days  are calculated properly by counting the days



  @TECT-1022
  Scenario: Login and go to job Title section and add ‘IT SDET’ job, and verify it is added.

    Given Navigate to OrangeHR log in page
    Then User logs in with valid username "Admin" password "admin123"
    Then User clicks on Job Title Section
    And User adds "IT SDET" job into the job secotion
    Then User verifies if the  "IT SDET" ptofession has been added

