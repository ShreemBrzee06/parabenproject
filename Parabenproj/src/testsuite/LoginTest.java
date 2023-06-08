package testsuite;

import browsefactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends Utility {
 String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
@Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.name("username")).sendKeys("ganesha1@gmail.com");
        driver.findElement(By.name("password")).sendKeys("test12345");
        driver.findElement(By.xpath("//input[@class='button']")).click();
        String actualTextMsg =driver.findElement(By.xpath("//h1[@class='title']")).getText();
        System.out.println(actualTextMsg);
        String expectedMsg = "Accounts Overview";
        Assert.assertEquals("Verifying Account overview Msg:",expectedMsg,actualTextMsg);

    }

    @Test

    public void verifyTheErrorMessage(){
    sendTextToElement(By.name("username"), "ganesha1@gmail.com");
    sendTextToElement(By.name("password"), "test1234567");
    driver.findElement(By.xpath("//input[@class='button']")).click();
    String actualTextMsg =driver.findElement(By.xpath("//p[@class='error']")).getText();
    System.out.println(actualTextMsg);
    String expectedErrorMSG = "The username and password could not be verified.";
    Assert.assertEquals("Verifying Error Msg: ",expectedErrorMSG,actualTextMsg);
    }

    @Test

    public void userShouldLogOutSuccessfully(){
        sendTextToElement(By.name("username"), "ganesha1@gmail.com");
        sendTextToElement(By.name("password"), "test12345");
        driver.findElement(By.xpath("//input[@class='button']")).click();
        driver.findElement(By.xpath("//a[@href=\"/parabank/logout.htm\"]")).click();
        String actualLogOutMsg = driver.findElement(By.xpath("//div[@id='leftPanel']//h2")).getText();
        System.out.println(actualLogOutMsg);
        String expectedLogOutMsg = "Customer Login";
        Assert.assertEquals("\"Verifying Logout Msg:\"",expectedLogOutMsg,actualLogOutMsg);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
