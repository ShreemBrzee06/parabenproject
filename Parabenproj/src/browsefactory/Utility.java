package browsefactory;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest{
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();// logout

    }

    public void verifyText(String expectedMessage, By by, String displayMessage) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    public void sendTextToElement(By by,String text){
       WebElement element = driver.findElement(by);
       element.sendKeys(text);
    }


}
