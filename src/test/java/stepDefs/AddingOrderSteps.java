package stepDefs;

import Pages.OrderHomePage;
import Pages.OrdersPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class AddingOrderSteps {

    OrderHomePage orderHomePage=new OrderHomePage();
    OrdersPage ordersPage=new OrdersPage();
    int iniatialorederCount;



    @Then("^User clicks on Order$")
    public void user_clicks_on_Order() throws Throwable {
        iniatialorederCount=orderHomePage.orderRows.size();

        orderHomePage.orderButton.click();

    }

    @Then("^User creates new Order$")
    public void user_creates_new_Order(DataTable dataTable) throws Throwable {

        List<Map<String,Object>> listOfMaps= dataTable.asMaps(String.class, Object.class);
        Select select=new Select(ordersPage.productName);
        select.selectByVisibleText(listOfMaps.get(0).get("Product Name").toString());

        ordersPage.quantaty.sendKeys(listOfMaps.get(0).get("Quantity").toString());

        ordersPage.customerName.sendKeys(listOfMaps.get(0).get("Customer Name").toString());

        ordersPage.streetName.sendKeys(listOfMaps.get(0).get("Street").toString());

        ordersPage.city.sendKeys(listOfMaps.get(0).get("City").toString());

        ordersPage.state.sendKeys(listOfMaps.get(0).get("State").toString());

        ordersPage.zipCode.sendKeys(listOfMaps.get(0).get("Zip").toString());

        ordersPage.amex.click();

        ordersPage.cardNum.sendKeys(listOfMaps.get(0).get("Card Nr").toString());

        ordersPage.expDate.sendKeys(listOfMaps.get(0).get("Expire Date").toString());
        Thread.sleep(3000);

        ordersPage.insertButton.click();



    }

    @Then("^User verify Order \"([^\"]*)\" created$")
    public void user_verify_Order_created(String isCondition) throws Throwable {

        ordersPage.ordersView.click();

        int afterOrderCreated= orderHomePage.orderRows.size();
        if (isCondition.equalsIgnoreCase("is")){
            Assert.assertEquals("Initial order number is: "+iniatialorederCount+"\n" +
                            "After you created order the row number is: "+afterOrderCreated,
                    iniatialorederCount+1, afterOrderCreated);
        }else {

            Assert.assertEquals("Initial order number is: "+iniatialorederCount+"\n" +
                            "After you created order the row number is: "+afterOrderCreated,
                    iniatialorederCount, afterOrderCreated);

        }

    }

    @Then("^User Deletes \"([^\"]*)\" from table$")
    public void user_Deletes_from_table(String Name) throws Throwable {
        System.out.println(orderHomePage.names.size());
        for (int i=0; i<orderHomePage.names.size(); i++){
            if (orderHomePage.names.get(i).getText().equalsIgnoreCase(Name)){
                orderHomePage.checkBox.get(i).click();
            }
        }
        Thread.sleep(5000);
        orderHomePage.deletebutton.click();
        Thread.sleep(3000);
    }

    @Then("^User validates that \"([^\"]*)\" is deleted$")
    public void user_validates_that_is_deleted(String Name) throws Throwable {
        for (WebElement element: orderHomePage.names){
            Assert.assertFalse(element.getText().equalsIgnoreCase(Name));
        }
    }











    /*
    System.out.println(listOfMaps.get(0).get("Quantity"));
        System.out.println(listOfMaps.get(0).get("Street"));
        System.out.println(listOfMaps.get(1).get("Quantity"));

        System.out.println("values of list: " + listOfMaps.size());
        System.out.println("values of list: " + listOfMaps.get(0).size());


        Assert.assertEquals("Initial order number is: "+iniatialorederCount+"\n" +
                        "After you created order the row number is: "+afterOrderCreated,
               iniatialorederCount, afterOrderCreated);

     */
}
