
@TEC-200
  Feature: Verifying HR Application

    Scenario: A Verifying number of employees from Europe
      Given User goes to HR homepage
      When User gets first and last names of the employees from homepage
      And User counts the number of the employees from the homepage and database then updates the excel file for documentation
    @TECT-200-2
      Scenario: B Validate number of database ‘Active’ employees and validate with their UI numbers.
        Given  User goes to HR homepage
        Then User retrieves the data of active employees from database and validates it with ui active employees
        Then User counts the number of active employees in database and validates it with ui data then updates the excel document

