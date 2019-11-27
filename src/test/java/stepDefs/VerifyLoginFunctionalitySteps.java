package stepDefs;

import Pages.LoginPage;
import org.junit.Assert;
import utilities.Configuration;
import utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;



public class VerifyLoginFunctionalitySteps {




        LoginPage loginPage=new LoginPage();


    @Given("^Navigate to login Page$")
    public void navigate_to_login_Page() throws Throwable {
        Driver.driver.get(Configuration.getProperties("browserUrl"));
        Thread.sleep(3000);
    }

        @Then("^User logs in with valid credentials username \"([^\"]*)\" password \"([^\"]*)\"$")
        public void user_logs_in_with_valid_credentials_username_password(String username, String password) throws Throwable {
            loginPage.username.sendKeys(username);
            loginPage.password.sendKeys(password);
            loginPage.loginButton.click();

        }

        @Then("^Verify user is in Homepage$")
        public void verify_user_is_in_Homepage() throws Throwable {
            // we need to verify it by getting the title.

            String actualTitle= Driver.driver.getTitle();
            String expectTitle= "Web Orders";
            Assert.assertEquals(expectTitle,actualTitle);

        }
    @Then("^User logs in with invalid credentials username \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_invalid_credentials_username_password(String username, String password) throws Throwable {
     loginPage.username.sendKeys(username);
     loginPage.password.sendKeys(password);
     loginPage.loginButton.click();

    }
    @Then("^Verify user gets error message \"([^\"]*)\"$")
    public void verify_user_gets_error_message(String errorMessage) throws Throwable {

        String actualResult=loginPage.errorMessage.getText();

        Assert.assertEquals(errorMessage,actualResult);

    }



}


