package stepDefs;

import Pages.EtsyHomePage;
import Pages.EtsyResultPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.Driver;

public class EtsyFreeShipingLable {


    EtsyHomePage etsyHomePage= new EtsyHomePage();
    EtsyResultPage etsyResultPage=new EtsyResultPage();


    @Then("^User input wireless charger in SearchField$")
    public void user_input_wireless_charger_in_SearchField() throws Throwable {
       etsyHomePage.searchField.sendKeys("Wireless Phone charger"+Keys.ENTER);

    }

    @Then("^User clicks on Free Shipping Button$")
    public void user_clicks_on_Free_Shipping_Button() throws Throwable {
        etsyResultPage.freeShipping.click();
    }


    @Then("^User validates if all items have the \"([^\"]*)\" label$")
    public void userValidatesIfAllItemsHaveTheLabel(String lable) throws Throwable {
        for (WebElement element: etsyResultPage.freeShingLabels){
            Assert.assertEquals(lable,element.getText().trim());
        }
    }
}
