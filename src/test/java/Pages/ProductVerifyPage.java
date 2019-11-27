package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ProductVerifyPage {

    WebDriver driver;

    public ProductVerifyPage(){
        this.driver =Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]")
    public WebElement dressMenu;
    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
    public WebElement dress1;
    @FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[1]/div/a[1]/img")
    public WebElement dress2;
    @FindBy(xpath = "//*[@id='center_column']/ul/li[3]/div/div[1]/div/a[1]/img")

    public WebElement dress3;
    @FindBy(xpath = "//*[@id='center_column']/ul/li[4]/div/div[1]/div/a[1]/img")
    public WebElement dress4;
    @FindBy(xpath = "//*[@id='center_column']/ul/li[5]/div/div[1]/div/a[1]/img")
    public WebElement dress5;
    @FindBy(xpath = "//span[@class='cross']")
    public WebElement Close1;

    @FindBy(xpath = "/span[@class='continue btn btn-default button exclusive-medium']")
    public  WebElement continueShop;
    @FindBy(xpath ="//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    public  WebElement addtoCart1;
    @FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[2]/div[2]/a[1]/span")
    public WebElement addtoCart2;
    @FindBy(xpath = "//*[@id='center_column']/ul/li[3]/div/div[2]/div[2]/a[1]/span")
    public WebElement addtoCart3;
    @FindBy(xpath = "//*[@id='center_column']/ul/li[4]/div/div[2]/div[2]/a[1]/span")
    public WebElement addtoCart4;
    @FindBy(xpath = "//*[@id='center_column']/ul/li[5]/div/div[2]/div[2]/a[1]/span")
    public WebElement addtoCart5;
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    public  WebElement cart;
    @FindBy(xpath = "//td[@data-title='Total']")
    public List <WebElement> listOfPrices;
    @FindBy(id="total_shipping")
    public WebElement shippingLable;
    @FindBy(id="total_price")
    public WebElement totalPrice;



}
