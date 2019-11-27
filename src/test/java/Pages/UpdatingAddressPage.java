package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UpdatingAddressPage {

    WebDriver driver;

    public UpdatingAddressPage(){
        this.driver =Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath ="//input[@id='email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@id='passwd']")
    public  WebElement inputPasswd;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    public  WebElement submit;

    @FindBy (xpath = "//i[@class='icon-building']")
    public WebElement myAddresses;

    @FindBy(xpath = "//a[@title=\"Update\"]")
    public  WebElement update;

    @FindBy (id="submitAddress")
    public  WebElement save;
}
