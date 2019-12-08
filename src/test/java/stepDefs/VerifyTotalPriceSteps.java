package stepDefs;

import Pages.ProductVerifyPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class VerifyTotalPriceSteps {

    ProductVerifyPage productVerifyPage = new ProductVerifyPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
    Actions act = new Actions(Driver.driver);



    @When("^User scrolls down and add five items into cart$")
    public void userScrollsDownAndAddFiveItemsIntoCart() throws Throwable {

        productVerifyPage.dressMenu.click();

        js.executeScript("window.scrollBy(0,500)");
        act.moveToElement(productVerifyPage.dress1).build().perform();
        productVerifyPage.addtoCart1.click();
        Thread.sleep(2000);
        productVerifyPage.Close1.click();
        Thread.sleep(2000);

        act.moveToElement(productVerifyPage.dress2).build().perform();
        productVerifyPage.addtoCart2.click();
        Thread.sleep(2000);
        productVerifyPage.Close1.click();
        Thread.sleep(2000);

        act.moveToElement(productVerifyPage.dress3).build().perform();
        productVerifyPage.addtoCart3.click();
        Thread.sleep(2000);
        productVerifyPage.Close1.click();


        act.moveToElement(productVerifyPage.dress4).build().perform();
        productVerifyPage.addtoCart4.click();
        Thread.sleep(2000);
        productVerifyPage.Close1.click();
        Thread.sleep(2000);

        act.moveToElement(productVerifyPage.dress5).build().perform();
        productVerifyPage.addtoCart5.click();
        Thread.sleep(2000);
        productVerifyPage.Close1.click();
        Thread.sleep(2000);

    }

    @When("^User Verifies the total amount of the items in the cart$")
    public void user_Verifies_the_total_amount_of_the_items_in_the_cart() throws Throwable {

        productVerifyPage.cart.click();
        double sum = 0.0;
        double shipping = 2;
        String expected = "154.87000000000003";
                //productVerifyPage.totalPrice.getText();
        //expected=expected.replace("$","");

        for (WebElement p : productVerifyPage.listOfPrices) {
            String price = p.getText();//50
            price = price.replace("$", "");
            if (price.length() > 0) {
                Double price1 = Double.parseDouble(price);
                sum = sum + price1;

            }
        }
        sum = sum + shipping;
        String sum1=new Double(sum).toString();
       // sum1.substring(0,5);

        System.out.println(sum);
        Assert.assertEquals(expected,sum1);


    }


/*** List<WebElement> links = driver.findElements(By.tagName("a"));
 System.out.println(links.size());
 int a = 0;
 for (WebElement c : links) {
 if (c.getAttribute("href") != null) {
 System.out.println(++a + " - " + c.getAttribute("href"));
 }


 List<WebElement> elements=new ArrayList<>();
 elements.addAll(driver.findElements(By.xpath("(//span[@class='a-price-whole'])")));
 System.out.println(elements.size());
 int sum=0;
 for(WebElement c: elements){
 String str=c.getText();
 str=str.replace(",","");
 int price=0;
 if(str.length()>0){
 price=Integer.parseInt(str);}
 sum=sum+price;
 }
 System.out.println(sum);

 }*/
}
