package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {


    // driver, element


    //this method will get hover ove the webelement
    //You need to pass the elements and driver


    public static void hover (WebElement element, WebDriver driver){

        Actions actions=new Actions(driver);

        actions.moveToElement(element).build().perform();

    }


    //this method will get the text of the  webelement and return string.You need to pass the elements


    public  static String getText(WebElement element){
        return element.getText();
    }


    //This method will take the list of webelemnets it will return list of text from the webelemnts

    public  static List<String> getElementsText(List<WebElement> elements){

        List <String> textList=new ArrayList<>();
        for (WebElement el: elements){

            if (!el.getText().isEmpty()){
                textList.add(el.getText());
            }
        }

        return textList;
    }

    public static void visibilityOfElemnt(WebDriver driver, WebElement element, int time){
        // webdriver is coming from Driver class , Webelement will come from page class , then you just provide time

        WebDriverWait wait=new WebDriverWait(driver, time);

        wait.until(ExpectedConditions.visibilityOf(element));

    }


    public static void switchWindow(String targetTitel, WebDriver driver){

        String origin=driver.getWindowHandle();
        Set<String> allWindows=driver.getWindowHandles();


        for (String windows: allWindows){

            driver.switchTo().window(windows);

            if (driver.getTitle().equals(targetTitel)){

                return ;
            }

            driver.switchTo().window(origin);

        }

    }

    //clickable, isAlertPresent, draganddrop, rightclick --> home work

}
