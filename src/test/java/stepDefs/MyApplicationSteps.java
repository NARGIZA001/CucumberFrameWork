package stepDefs;

import Pages.MyApplicationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Configuration;
import utilities.Driver;
import utilities.JDBCutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApplicationSteps {

    MyApplicationPage maPage= new MyApplicationPage();

    Map<String , Object> uiData= new HashMap<String, Object >();

    List<Map <String,Object>> dbData=new ArrayList<>();







    @Given("^Navigate MyApplication$")
    public void navigate_MyApplication() throws Throwable {

        Driver.driver.get(Configuration.getProperties("MyApplication"));


    }

    @When("^User gets employee info for employee_id \"([^\"]*)\" from UI$")
    public void user_gets_employee_info_for_employee_id_from_UI(String Employee_id) throws Throwable {

        int indexOfrow=0;
        for (int i=0;i< maPage.employee_ids.size(); i++){

            if (maPage.employee_ids.get(i).getText().equalsIgnoreCase(Employee_id)){
                indexOfrow=i;
            }
        }

        // xpath //table//tr [4]//td
        // for (int i=0; i< 4; i++){
         List <WebElement> elements=Driver.driver.findElements(By.xpath("//table//tr ["+(indexOfrow+1)+"]//td"));

           uiData.put("first_name", elements.get(0).getText());
           uiData.put("last_name", elements.get(1).getText());
           uiData.put("job_title", elements.get(3).getText());

    }

    @When("^User gets data for employee_id \"([^\"]*)\" from database$")
    public void user_gets_data_for_employee_id_from_database(String Employee_id) throws Throwable {
        String query ="select e.first_name, e.last_name, j.job_title\n" +
                "from employees e join jobs j on\n" +
                "e.job_id=j.job_id\n" +
                "where employee_id="+ Employee_id;
        JDBCutils.establishedConnection();
        dbData=JDBCutils.runSQLQuery(query);





    }

    @Then("^Validate data are matching$")
    public void validate_data_are_matching() throws Throwable {

        Assert.assertEquals(dbData.get(0).get("FIRST_NAME"), uiData.get("first_name"));
        Assert.assertEquals(dbData.get(0).get("LAST_NAME"), uiData.get("last_name"));
        Assert.assertEquals(dbData.get(0).get("JOB_TITLE"), uiData.get("job_title"));

    }

}
