package stepDefs;

import Pages.SignInAccountPage;
import Pages.UpdatingAddressPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

import java.util.List;
import java.util.Map;



public class UpdateAddressSteps {



    UpdatingAddressPage updatingAddressPage= new UpdatingAddressPage();
    SignInAccountPage signInAccountPage=new SignInAccountPage();




    @Then("^enter the credentials email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enterTheCredentialsEmailAndPassword(String email , String password) throws Throwable {

        updatingAddressPage.inputEmail.sendKeys(email);
        Thread.sleep(2000);
        updatingAddressPage.inputPasswd.sendKeys(password);
        Thread.sleep(2000);
        updatingAddressPage.submit.click();
        Thread.sleep(2000);


    }
    @Then("^User clicks on my addresses option$")
    public void user_clicks_on_my_addresses_option() throws Throwable {

    updatingAddressPage.myAddresses.click();
    }

    @Then("^User clicks on update button$")
    public void user_clicks_on_update_button() throws Throwable {
    updatingAddressPage.update.click();
    String oldAddress=signInAccountPage.address.getText();
    }

    @Then("^User eneter his new address$")
    public void user_eneter_his_new_address(DataTable dataTable) throws Throwable {
    List<Map<String,Object>> listOfMaps=dataTable.asMaps(String.class, Object.class);
        signInAccountPage.address.clear();
    signInAccountPage.address.sendKeys(listOfMaps.get(0).get("Address").toString());
        signInAccountPage.city.clear();
    signInAccountPage.city.sendKeys(listOfMaps.get(0).get("City").toString());
        signInAccountPage.zip.clear();
    signInAccountPage.zip.sendKeys(listOfMaps.get(0).get("Zip").toString());


    }

    @Then("^User clicks on button SAVE$")
    public void user_clicks_on_button_SAVE() throws Throwable {
        updatingAddressPage.save.click();

    }

    @Then("^User validates the old address with new address$")
    public void user_validates_the_old_address_with_new_address() throws Throwable {
        String oldUrl="http://automationpractice.com/index.php?controller=address&id_address=242029";
        String  newURL=Driver.driver.getCurrentUrl();
        Assert.assertNotSame(newURL,oldUrl);

    }



}
