package stepDefs;

import Pages.HRApplicationPages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utilities.Configuration;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.JDBCutils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HRApplicationSteps {

    HRApplicationPages hrApp = new HRApplicationPages();
    List<Map<String, Object>> dbData = new ArrayList<>();
    List<Map<String, Object>> departmentNameCount = new ArrayList<>();


    @Given("^User goes to HR homepage$")
    public void user_goes_to_HR_homepage() throws Throwable {

        Driver.driver.get(Configuration.getProperties("HRapp"));


    }

    @When("^User gets first and last names of the employees from homepage$")
    public void user_gets_first_and_last_names_of_the_employees_from_homepage() throws Throwable {
        // List<Map<String, Object>> dbData = new ArrayList<>();
        try {
            JDBCutils.establishedConnection();
            dbData = JDBCutils.runSQLQuery("select first_name ,last_name\n" +
                    " from employees e join  departments d on\n" +
                    " e.department_id=d.department_id\n" +
                    " join locations l on d.location_id=l.location_id\n" +
                    " join countries c on l.country_id=c.country_id\n" +
                    " join regions r on c.region_id=r.region_id\n" +
                    " where region_name ='Europe'");
            System.out.println(dbData.size());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutils.closeConnection();
        }


        for (int i = 0; i < hrApp.firstName.size(); i++) {
            System.out.println("from ui: "+hrApp.firstName.get(i).getText());
            System.out.println("from db: "+dbData.get(i).get("FIRST_NAME"));
            if (hrApp.firstName.get(i).getText().contains(dbData.get(i).get("FIRST_NAME").toString())) {
                Assert.assertTrue(true);
            }

            for (int k = 0; k < hrApp.lastName.size(); k++) {
                if (hrApp.lastName.get(k).getText().contains(dbData.get(k).get("LAST_NAME").toString())) {
                    Assert.assertTrue(true);
                }
            }


        }

    }


    @When("^User counts the number of the employees from the homepage and database then updates the excel file for documentation$")
    public void user_counts_the_number_of_the_employees_from_the_homepage() throws Throwable {

        ExcelUtils.openExcelFile("testData", "Sheet3");

        int expectedNumOfEmployees = dbData.size();
        int actualNumOfEmployees = hrApp.firstName.size();

        System.out.println(expectedNumOfEmployees + "<<<<<<>>>>>>" + actualNumOfEmployees);

        Assert.assertEquals(expectedNumOfEmployees, actualNumOfEmployees);


        ExcelUtils.setValue("36", 1, 1);

        Thread.sleep(1000);

        ExcelUtils.setValue("36", 1, 2);

        Thread.sleep(1000);

        ExcelUtils.setValue("PASSED", 1, 3);


    }

    @Then("^User retrieves the data of active employees from database and validates it with ui active employees$")
    public void user_retrieves_the_data_of_active_employees_from_database_and_validates_it_with_ui_active_employees() throws Throwable {

        try {
            JDBCutils.establishedConnection();
            departmentNameCount = JDBCutils.runSQLQuery("select department_name, count(*) \n" +
                    " from employees e full outer join departments d on e.department_id=d.department_id where employee_id in (select  employee_id from\n" +
                    " employees MINUS  select employee_id from job_history)\n" +
                    " group by department_name ORDER BY department_name ASC");
            System.out.println(departmentNameCount.size());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutils.closeConnection();
        }


        for (int i = 0; i < hrApp.departmentNames.size(); i++) {

            System.out.println("database: " + departmentNameCount.get(i).get("DEPARTMENT_NAME"));
            System.out.println("ui: " + hrApp.departmentNames.get(i).getText());
            if (!hrApp.departmentNames.get(i).getText().contains(departmentNameCount.get(i).get("DEPARTMENT_NAME").toString())) {
                Assert.assertTrue(false);
            }
        }

        for (int k = 0; k < hrApp.numberOfEmployees.size(); k++) {
            if (!hrApp.numberOfEmployees.get(k).getText().contains(departmentNameCount.get(k).get("COUNT(*)").toString())) {
                Assert.assertFalse(false);
            }
        }


    }

    @Then("^User counts the number of active employees in database and validates it with ui data then updates the excel document$")
    public void user_counts_the_number_of_active_employees_in_database_and_validates_it_with_ui_data_then_updates_the_excel_documnet() throws Throwable {


        int expectedEmplNum = departmentNameCount.size();
        int actualEmpNum = hrApp.numberOfEmployees.size();

        System.out.println(expectedEmplNum + "<<<<*>>>>" + actualEmpNum);
        Assert.assertEquals(expectedEmplNum, actualEmpNum);

        int sumActual = 0;

        for (WebElement element : hrApp.numberOfEmployees) {
            String str = element.getText();
            int d = Integer.parseInt(str);
            sumActual = sumActual + d;
        }

        System.out.println(sumActual);


        int sumExpected = 0;

        for (Map<String, Object> s : departmentNameCount) {

            String str = s.get("COUNT(*)").toString();
            int values = Integer.parseInt(str);
            sumExpected = sumExpected + values;

        }

        System.out.println(sumActual);

        Assert.assertEquals(sumExpected, sumActual);

        ExcelUtils.openExcelFile("testData", "Sheet3");

        ExcelUtils.setValue("100", 2, 1);

        Thread.sleep(1000);

        ExcelUtils.setValue("100", 2, 2);

        Thread.sleep(1000);

        ExcelUtils.setValue("PASSED", 2, 3);


    }


}




