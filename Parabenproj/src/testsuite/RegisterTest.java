package testsuite;

import browsefactory.BaseTest;
import browsefactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends Utility {
    String baseUrl= "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void openingBrowser(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        driver.findElement(By.linkText("Register")).click();
        String actualVerifyMsg = driver.findElement(By.xpath("//h1[@class='title']")).getText();
        System.out.println(actualVerifyMsg);
        String expectedMsg = "Signing up is easy!";
        Assert.assertEquals(expectedMsg,actualVerifyMsg);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully (){
        driver.findElement(By.linkText("Register")).click();
        sendTextToElement(By.id("customer.firstName"),"Ganesha");
        sendTextToElement(By.id("customer.lastName"),"Shiva");
        sendTextToElement(By.id("customer.address.street"), "Test address");
        sendTextToElement(By.id("customer.address.city"),"Test City");
        sendTextToElement(By.id("customer.address.state"),"Test state");
        sendTextToElement(By.id("customer.address.zipCode"),"Test zipcode");
        sendTextToElement(By.id("customer.phoneNumber"), "25412446216");
        sendTextToElement(By.id("customer.ssn"),"sn12345");
        sendTextToElement(By.id("customer.username"),"ganesha1@gmail.com");
        sendTextToElement(By.id("customer.password"),"test12345");
        sendTextToElement(By.id("repeatedPassword"),"test12345");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String actualWelcomeTxtMsg = driver.findElement(By.xpath("//p[@class='smallText']")).getText();
        System.out.println(actualWelcomeTxtMsg);
        String expectedMsg ="Welcome Ganesha Shiva";
        Assert.assertEquals("Verifying Register Message", expectedMsg,actualWelcomeTxtMsg);
    }


    @After
    public void closingBrowser(){
       closeBrowser();
    }
}
