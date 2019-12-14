package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HRApplicationPages {

    WebDriver driver;

    public HRApplicationPages (){

        driver= Driver.driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy (xpath = "//*[@id='europe-employees']/tbody/tr/td[1]")
    public List <WebElement> firstName;

    @FindBy (xpath = "//*[@id='europe-employees']/tbody/tr/td[2]")
    public List <WebElement> lastName;

    @FindBy(xpath = "//table[@id='number-of-employees-by-department-name']/tbody/tr/td[1]")
    public  List<WebElement> departmentNames;

    @FindBy(xpath = "//table[@id='number-of-employees-by-department-name']/tbody/tr/td[2]")
    public  List<WebElement> numberOfEmployees;

}
