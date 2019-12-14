package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.xml.xpath.XPath;

public class AwsHomePage {

    WebDriver driver;

    public AwsHomePage(){

        driver=Driver.driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "(//*[@class='cell firstCell'])[2]")
    public WebElement addButton1;


    @FindBy (xpath = "//*[@class='billLabel']")
    public  WebElement estimateBill;

    @FindBy(xpath = "(//input[@class='gwt-TextBox gwt-TextBox-readonly'])[4119]")
    public  WebElement totalAmount;
}
