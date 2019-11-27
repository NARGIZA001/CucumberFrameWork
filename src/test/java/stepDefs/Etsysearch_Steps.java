package stepDefs;

import Pages.EtsyHomePage;
import Pages.EtsyResultPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Configuration;
import utilities.Driver;

public class Etsysearch_Steps {

    EtsyHomePage etsyHomePage= new EtsyHomePage();
    EtsyResultPage etsyResultPage=new EtsyResultPage();



    @Given("^Navigate to Etsy Homepage$")
    public void navigate_to_Etsy_Homepage() throws Throwable {
        Driver.driver.get(Configuration.getProperties("EtsyUrl"));

    }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String item) throws Throwable {
        etsyHomePage.searchField.sendKeys(item+Keys.ENTER);

    }

    @Then("^Validate search message  has the \"([^\"]*)\" word$")
    public void validate_search_message_has_the_word(String item) throws Throwable {
        String actualSearchMessage=etsyResultPage.searchMessage.getText(); // getting the text from the webpage
        Assert.assertEquals(item,actualSearchMessage);

    }

    @When("^User clicks \"([^\"]*)\"$")
    public void user_clicks(String department) throws Throwable {


        if(etsyHomePage.jewelryAcc.getText().equalsIgnoreCase(department)){
            etsyHomePage.jewelryAcc.click();

        }else if(etsyHomePage.clothingShoe.getText().equalsIgnoreCase(department)){
            etsyHomePage.clothingShoe.click();

        }else if(etsyHomePage.homeLiving.getText().equalsIgnoreCase(department)){
            etsyHomePage.homeLiving.click();

        }else if(etsyHomePage.weddinParty.getText().equalsIgnoreCase(department)){
            etsyHomePage.weddinParty.click();

        }else if (etsyHomePage.ToysEnter.getText().equalsIgnoreCase(department)){
            etsyHomePage.ToysEnter.click();
        }



    }

    @Then("^User validate \"([^\"]*)\"$")
    public void user_validate(String title) throws Throwable {
        String jewelActitle=Driver.driver.getTitle();
        Assert.assertEquals(title,jewelActitle);

    }

    @And("^User click on over Price checkbox$")
    public void userClickOnOverPriceCheckbox() throws Throwable {
       // WebDriverWait wait=new WebDriverWait(Driver.driver, 10);
      //  wait.until(ExpectedConditions.elementToBeClickable(etsyResultPage.over1000));

        etsyResultPage.over1000.click();

    }

    @Then("^User verifies all item prices are over that price$")
    public void userVerifiesAllItemPricesAreOverThatPrice() throws Throwable {

        for (WebElement element:etsyResultPage.resultPrices) {
            String number = element.getText().replace(",", "");
            System.out.println(number);
            if (!number.isEmpty()) {
                double price = Double.parseDouble(number);
                System.out.println(price);
                Assert.assertTrue(price >=799);
            }
        }

    }
}
