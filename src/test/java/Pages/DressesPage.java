package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DressesPage {


    WebDriver driver;

    public DressesPage(){
        this.driver =Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }

  @FindBy(xpath = "//*[@id='special_block_right']/div/div/a/span")
    public WebElement specialPrice;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/div[1]/span[1]")
    public WebElement currentPrice;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/div[1]/span[2]")
    public WebElement oldPrice;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/div[1]/span[2]")
    public WebElement discountedPrice;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[2]/div[1]/span[1]")
    public WebElement currentdPrice2;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[2]/div[1]/span[2]")
    public WebElement oldPrice2;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[2]/div[1]/span[3]")
    public WebElement discountedPrice2;

    @FindBy (xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/div[1]/span")
    public List<WebElement> listofPrice1;

    @FindBy (xpath = "//*[@id='center_column']/ul/li[2]/div/div[2]/div[1]/span")
    public List<WebElement> listofPrice2;


}
