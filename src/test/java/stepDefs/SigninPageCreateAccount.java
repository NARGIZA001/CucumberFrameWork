package stepDefs;

import Pages.SignInAccountPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import utilities.Configuration;
import utilities.Driver;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SigninPageCreateAccount {
    WebDriver driver;

   SignInAccountPage signInAccountPage =new SignInAccountPage();


    @Given("^Navigate to sign in page$")
    public void navigate_to_sign_in_page() throws Throwable {
        Driver.driver.get(Configuration.getProperties("WebAppUrl"));
        String actualTitle= Driver.driver.getTitle();
        String expectTitle= "My Store";
        Assert.assertEquals(expectTitle,actualTitle);

    }

    @Then("^Clicks on sign in button$")
    public void clicks_on_sign_in_button() throws Throwable {
        signInAccountPage.singinButton.click();


    }

    @Then("^User types Email address$")
    public void user_types_Email_address() throws Throwable {

        Random random=new Random(); //java faker
        int n = random.nextInt(10000);
        System.out.println(n+"@gmail.com");
        signInAccountPage.typeEmail.sendKeys(n+"@gmail.com");

    }

    @Then("^User clicks on account Button$")
    public void user_clicks_on_account_Button() throws Throwable {
        signInAccountPage.createAccountButton.click();
    }

    @Then("^User inputs his personal information$")
    public void user_inputs_his_personal_information() throws Throwable {
        signInAccountPage.genderF.click(); //radio button

    }

    @Then("^User inputs his address$")
    public void user_inputs_his_address(DataTable arg1) throws Throwable {

        List<Map<String, Object>> listOfMaps = arg1.asMaps(String.class,Object.class);
        signInAccountPage.firstName.sendKeys(listOfMaps.get(0).get("First Name").toString());
        Thread.sleep(3000);
        signInAccountPage.lastName.sendKeys(listOfMaps.get(0).get("Last Name").toString());

        // signInAccountPage.email.sendKeys(listOfMaps.get(0).get("email").toString());

        signInAccountPage.password.sendKeys(listOfMaps.get(0).get("password").toString());

        signInAccountPage.birthDay.sendKeys(listOfMaps.get(0).get("days").toString());

        signInAccountPage.birthMonth.sendKeys(listOfMaps.get(0).get("months").toString());

        signInAccountPage.birthYear.sendKeys(listOfMaps.get(0).get("years").toString());


    }
    @Then("^User checks the news letter button$")
    public void userChecksTheNewsLetterButton() throws Throwable {
       signInAccountPage.newsletter.click();

        Thread.sleep(5000);
    }

    @Then("^User inputs address$")
    public void user_inputs_address(DataTable arg1) throws Throwable {
        List<Map<String, Object>> listOfMaps = arg1.asMaps(String.class,Object.class);
        signInAccountPage.company.sendKeys(listOfMaps.get(0).get("Company").toString());
        signInAccountPage.address.sendKeys(listOfMaps.get(0).get("Address").toString());
        signInAccountPage.city.sendKeys(listOfMaps.get(0).get("City").toString());
        signInAccountPage.state.sendKeys(listOfMaps.get(0).get("State").toString());
        signInAccountPage.zip.sendKeys(listOfMaps.get(0).get("Zip").toString());
        signInAccountPage.mobilPhone.sendKeys(listOfMaps.get(0).get("Phone").toString());
        signInAccountPage.register.click();


    }

    @Then("^User clicks on Register Button$")
    public void user_clicks_on_Register_Button() throws Throwable {

    }





//        WebElement birthDay=driver.findElement(By.xpath("//select[@id='days']"));
//        Select select=new Select(signInAccountPage.birthDay);
//        select.selectByVisibleText("29");
//        WebElement birthMonths=driver.findElement(By.id("months"));


//        Select select1=new Select(signInAccountPage.birthMonths);
//        select.selectByValue("10");

//        Select select2=new Select(signInAccountPage.birthYear);
//        select.selectByValue("2006");



}
