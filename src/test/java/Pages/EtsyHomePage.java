package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EtsyHomePage {
    WebDriver driver;

    public EtsyHomePage(){
        this.driver =Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="global-enhancements-search-query")
    public WebElement searchField;

    @FindBy(linkText ="Jewelry & Accessories") //span[contains(.,'Jewelry & Accessories')]
    public WebElement jewelryAcc;

    @FindBy(linkText ="Clothing & Shoes") //span[contains(.,'Clothing & Shoes')]
    public WebElement clothingShoe;

    @FindBy(linkText ="Home & Living") //span[contains(.,'Home & Living')]
    public WebElement homeLiving;

    @FindBy(linkText ="Wedding & Party") //span[contains(.,'Wedding & Party')]
    public WebElement weddinParty;

    @FindBy(linkText ="Toys & Entertainment") //span[contains(.,'Toys & Entertainment')]
    public WebElement ToysEnter;






}
