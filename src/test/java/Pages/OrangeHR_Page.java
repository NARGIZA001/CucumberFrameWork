package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.security.PublicKey;
import java.util.List;

public class OrangeHR_Page {

    WebDriver driver ;

   public OrangeHR_Page(){
       this.driver=Driver.driverSetup("chrome");
       PageFactory.initElements(driver,this);
   }


   @FindBy (id="txtUsername")
    public WebElement usernameOR;

   @FindBy (id="txtPassword")
    public WebElement passwordOR;

   @FindBy (xpath = "//input[@id='btnLogin']")
    public  WebElement logIn;

   @FindBy (id="menu_admin_viewAdminModule")
   public WebElement adminButton;
   @FindBy (id="ohrmList_chkSelectRecord_2")
   public WebElement checkBOx;

   @FindBy( xpath = "//*[@id='resultTable']/tbody/tr[6]/td[2]/a") //*[@id="resultTable"]/tbody/tr[6]/td[2]/a
   public WebElement lindasCredentials;

   @FindBy(xpath =  "//input[@id='systemUser_chkChangePassword']") //systemUser_chkChangePassword
   public  WebElement editCheckBox;

   @FindBy (xpath = "//input[@id='btnSave']")
   public WebElement editButton;

   @FindBy (xpath = "//input[@id='systemUser_password']")
   public  WebElement newPassword;

   @FindBy (id="systemUser_confirmPassword")
   public  WebElement confirmNewPassword;

   @FindBy(id="welcome")
   public  WebElement welcome;

   @FindBy(xpath = "//*[@id='welcome-menu']/ul/li[2]/a")
   public  WebElement logout;

   @FindBy(xpath = "//*[@id='welcome']")
   public WebElement welocomLinda;

   @FindBy (xpath = "//a[@id='menu_leave_viewLeaveModule']")
    public WebElement leaveButton;

   @FindBy(xpath = "(")
   public  WebElement numberOfdays;

   @FindBy (xpath = "//*[@id='resultTable']/tbody/tr[1]/td[6]/a")
    public  WebElement pendingAprove;

   @FindBy (xpath = "//table[@id='resultTable']/tbody/tr/td[4]")
    public List<WebElement>  hours;
   @FindBy(id = "menu_admin_viewAdminModule")
    public  WebElement admin;
   @FindBy (xpath = "//a[@id='menu_admin_Job']")
    public  WebElement jobs;

   @FindBy(id="menu_admin_viewJobTitleList")
    public  WebElement jobTitle;

   @FindBy (id= "btnAdd")
    public  WebElement add;

   @FindBy (id="jobTitle_jobTitle")
   public  WebElement newJobField;

   @FindBy (id="btnSave")
    public  WebElement save;

   @FindBy ( xpath= "//*[@id='resultTable']/tbody/tr[9]/td[2]/a")
    public  WebElement itSDET;
}






































