package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class OrderHomePage {

    WebDriver driver;

    public OrderHomePage(){
        this.driver =Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//a[@href='Process.aspx']")
    public WebElement orderButton;

    @FindBy (xpath = "//table[@class='SampleTable']//tr")
    public List<WebElement> orderRows;




}
