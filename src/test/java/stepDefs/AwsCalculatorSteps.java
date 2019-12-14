package stepDefs;

import Pages.AwsHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.Configuration;
import utilities.Driver;
import utilities.ExcelUtils;

public class AwsCalculatorSteps {

    AwsHomePage awsHomePage=new AwsHomePage();


    @Given("^User navigate to AWS Calculator homepage$")
    public void user_navigate_to_AWS_Calculator_homepage() throws Throwable {

        Driver.driver.get(Configuration.getProperties("awsURL"));

    }

    @When("^User adds (\\d+) EC(\\d+) Instances$")
    public void user_adds_EC_Instances(int numberOfInstances, int arg2) throws Throwable {

        awsHomePage.addButton1.click();
        Driver.driver.findElement(By.xpath("(//*[@class='cell firstCell'])[3]")).click();

    }

    @When("^User adds (\\d+) EC(\\d+) Dedicated Hosts$")
    public void user_adds_EC_Dedicated_Hosts(int arg1, int arg2) throws Throwable {
        Driver.driver.findElement(By.xpath("(//*[@class='cell firstCell'])[6]")).click();
        Driver.driver.findElement(By.xpath("(//*[@class='cell firstCell'])[7]")).click();
    }

    @Then("^Total estimated cost has to match with prices on \"([^\"]*)\" \"([^\"]*)\" excel file$")
    public void total_estimated_cost_has_to_match_with_prices_on_excel_file(String excelName, String sheetName) throws Throwable {
        awsHomePage.estimateBill.click();
        Thread.sleep(2000);
        String totalActualAmount= awsHomePage.totalAmount.getAttribute("value");
        Thread.sleep(2000);
        System.out.println(totalActualAmount);

        ExcelUtils.openExcelFile(excelName, sheetName);
        String ec2Price=ExcelUtils.getValue(1,1);
        double calec2Price= Double.parseDouble(ec2Price)*2;

        String ec2Hosts= ExcelUtils.getValue(2,1);
        double calec2Hosts= Double.parseDouble(ec2Hosts)*2;

        double expectedTotalPrice= calec2Price+calec2Hosts;


        Assert.assertEquals(expectedTotalPrice,Double.parseDouble(totalActualAmount),1);

    }
}
