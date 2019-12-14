package stepDefs;

import Pages.OrangeHR_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Configuration;
import utilities.Driver;

public class OrangeHR_Steps {



    OrangeHR_Page orangeHR= new OrangeHR_Page();
    JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
    String actual ="";
    Actions act= new Actions(Driver.driver);


    @Given("^Navigate to OrangeHR log in page$")
    public void navigate_to_OrangeHR_log_in_page() throws Throwable {

        Driver.driver.get(Configuration.getProperties("orangeUrl"));
        String actualTitle= Driver.driver.getTitle();
        String expectTitle= "OrangeHRM";
        Assert.assertEquals(expectTitle,actualTitle);


    }

    @Then("^User logs in with valid username \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_valid_username_password(String username, String password) throws Throwable {

        orangeHR.usernameOR.sendKeys(username);
        orangeHR.passwordOR.sendKeys(password);
        orangeHR.logIn.click();

    }

    @Then("^User changes the username \"([^\"]*)\" password \"([^\"]*)\" then sign in again to verify if password has changed$")
    public void userChangesTheUsernamePasswordThenSignInAgainToVerifyIfPasswordHasChanged(String lindaUser, String lindapassword) throws Throwable {
        Thread.sleep(1000);
        orangeHR.adminButton.click();
        Thread.sleep(1000);
        orangeHR.checkBOx.click();
        orangeHR.lindasCredentials.click();
        Thread.sleep(1000);
        orangeHR.editButton.click();
        orangeHR.editCheckBox.click();
        orangeHR.newPassword.sendKeys(lindapassword);
        orangeHR.confirmNewPassword.sendKeys(lindapassword);
        orangeHR.editButton.click();
        orangeHR.welcome.click();
        Thread.sleep(5000);
        js.executeScript("arguments[0].click();", orangeHR.logout);
        Thread.sleep(2000);
        orangeHR.usernameOR.sendKeys(lindaUser);
        Thread.sleep(1000);
        orangeHR.passwordOR.sendKeys(lindapassword);
        orangeHR.logIn.click();

        String expected="Welcome Linda";
        String actual=orangeHR.welocomLinda.getText();
        Assert.assertEquals(expected,actual);
    }



    @Then("^User clicks on leave days and chosses Linda Anderson's number$")
    public void user_clicks_on_leave_days_and_chosses_Linda_Anderson_s_number() throws Throwable {
        Thread.sleep(2000);
        orangeHR.leaveButton.click();
        Thread.sleep(2000);
        orangeHR.pendingAprove.click();

        Thread.sleep(4000);

        actual =orangeHR.numberOfdays.getText();

        Thread.sleep(4000);

    }

    @Then("^User verifies if Linda Anderson's leave days  are calculated properly by counting the days$")
    public void user_verifies_if_Linda_Anderson_s_leave_days_are_calculated_properly_by_counting_the_days() throws Throwable {

       double sum=0;

       for(WebElement el: orangeHR.hours){
           String hour=el.getText();
           if (hour.length()==4) {
               String hour1=hour.substring(0,4);
               double d = Double.parseDouble(hour1);
               sum= sum+d;
               System.out.println(sum);
           }
       }

       double expected = sum/8.00;


       System.out.println(expected+ "*****");

        System.out.println(actual);

       Assert.assertEquals(expected, actual);


    }

    @Then("^User clicks on Job Title Section$")
    public void user_clicks_on_Job_Title_Section() throws Throwable {


    act.moveToElement(orangeHR.admin).perform();
    act.moveToElement(orangeHR.jobs).perform();
    act.moveToElement(orangeHR.jobTitle).click().perform();

    orangeHR.add.click();



    }

    @Then("^User adds \"([^\"]*)\" job into the job secotion$")
    public void user_adds_job_into_the_job_secotion(String jobTitle) throws Throwable {

        orangeHR.newJobField.sendKeys(jobTitle);
        orangeHR.save.click();

    }

    @Then("^User verifies if the  \"([^\"]*)\" ptofession has been added$")
    public void user_verifies_if_the_ptofession_has_been_added(String itSdet) throws Throwable {

        String actual =orangeHR.itSDET.getText();
        Assert.assertEquals(itSdet,actual);


    }

}
