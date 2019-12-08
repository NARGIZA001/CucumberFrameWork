package stepDefs;

import Pages.DressesPage;
import Pages.ProductVerifyPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class VerifyingDiscountedPriceSteps {

    ProductVerifyPage productVerifyPage= new ProductVerifyPage();

    DressesPage dressesPage=new DressesPage();

    @Then("^User clicks on dresses option$")
    public void user_clicks_on_dresses_option() throws Throwable {
        productVerifyPage.dressMenu.click();
        dressesPage.specialPrice.click();

    }


    @Then("^Verifies items with discounted price by it is percentage$")

    public void verifiesItemsWithDiscountedPriceByItIsPercentage() throws Throwable {

        String oldPR = dressesPage.oldPrice.getText();          //  text is $20.50

        String  oldPR1= oldPR.substring(1,oldPR.length());      // removing the $ symbol from $20.50

        double sale = Double.parseDouble(oldPR1)*20/100;        // sale price -20% from original 20.50 = 4.10

        double finalPR= Double.parseDouble(oldPR1)-sale;        // deducting the 4.10 from original

        String expectedPrice="$"+finalPR+"0";                       // converting back to string $16.40 to be able to use assertion

        System.out.println(dressesPage.currentPrice.getText());

        Assert.assertTrue(expectedPrice.equalsIgnoreCase(dressesPage.currentPrice.getText()));


        String oldPR2 = dressesPage.oldPrice2.getText();          //  text is $30.51

        String  oldPR3= oldPR2.substring(1,oldPR2.length());      // removing the $ symbol from $30.51

        double sale1 = Double.parseDouble(oldPR3)*5/100;        // sale price -20% from original 30.51 =1.53

        double finalPR1= Double.parseDouble(oldPR3)-sale1;        // deducting the 1.53 from original price

        String expectedPrice1="$"+finalPR1;                     // converting back to string $28.9845 to be able to use assertion

        String expectedPrice2= expectedPrice1.substring(0,6);   //cutting the last 2 digits (45)

        System.out.println(dressesPage.currentdPrice2.getText());

        Assert.assertTrue(expectedPrice2.equalsIgnoreCase(dressesPage.currentdPrice2.getText()));







    }





    /*

        for (WebElement element : dressesPage.listofPrice1) {
            System.out.println(element.getText());
        }

        for (WebElement element : dressesPage.listofPrice2) {
            System.out.println(element.getText());
        }

          for (WebElement element : dressesPage.listofPrice1) {
            element.getText();
        }

        System.out.println(disCO);
        String  disCO1= disCO.substring(1,disCO.length());
        -Integer.parseInt(discount_price_removecurrencysymbol);
        // 30x5/100=1.5


        #1
         System.out.println(oldPR);
        System.out.println(currPR);
        #2
        System.out.println(oldPR1);
        System.out.println(currPR1);

        String disCO=dressesPage.discountedPrice.getText();
        String currPR1= actualPrice.substring(1,actualPrice.length());
        String actualPrice=dressesPage.currentPrice.getText();  //  getting the text to assert it after
     */
}
