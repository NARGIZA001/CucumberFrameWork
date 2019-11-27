package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInAccountPage {
    WebDriver driver;

    public SignInAccountPage(){
        this.driver =Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@class='header_user_info']")
    public WebElement singinButton;

    @FindBy(id ="email_create") //input[@id="email_create"]
    public WebElement typeEmail;

    @FindBy (id="SubmitCreate")
    public WebElement createAccountButton;

    @FindBy(id = "id_gender2")//id_gender2
    public WebElement genderF;

    @FindBy(id = "customer_firstname")//id="customer_firstname"
    public WebElement firstName;

    @FindBy(id = "customer_lastname")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id="passwd")
    public WebElement password;

    @FindBy(id="days")
    public WebElement birthDay;

    @FindBy(id="months")
    public WebElement birthMonth;

    @FindBy(id="years")
    public WebElement birthYear;

    @FindBy(id="optin")
    public WebElement newsletter;

    @FindBy(id="company")
    public  WebElement company;

    @FindBy(xpath = "//input[@name='address1']")
    public WebElement address;

    @FindBy(id="city")
    public  WebElement city;

    @FindBy(id="id_state")
    public  WebElement state;

    @FindBy(id="postcode")
    public  WebElement zip;

    @FindBy(id="phone_mobile")
    public  WebElement mobilPhone;

    @FindBy(xpath="//button[@id='submitAccount']")
    public WebElement register;



}
