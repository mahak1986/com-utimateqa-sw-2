package testsuite;
/**
 * Create the package ‘testsuite’
 * and create the following class inside the ‘testsuite’ package.
 * 1. LoginTest
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.Set;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * Write down the following test into ‘LoginTest’ class
     * 1. userShouldNavigateToLoginPageSuccessfully * click on the ‘Sign In’ link
     * * Verify the text ‘Welcome Back!’
     */
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        String expectedText = "Welcome Back!";
        //Finding actual text and get text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual using Assert
        Assert.assertEquals("Error Message", expectedText, actualText);
    }

    /**
     * 2. verifyTheErrorMessage
     * * click on the ‘Sign In’ link
     * * Enter invalid username
     * * Enter invalid password
     * * Click on Login button
     * * Verify the error message ‘Invalid email or password.’
     */
    @Test
    public void verifyTheErrorMessage() {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("Mahak@gmail.com");
        //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("Mahak123");
        //Click on sign in button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.removeAll(Collections.singleton(By.xpath("//div[starts-with(@style, 'visibility:')]")));
        String expectedText = "Invalid email or password.";
        //Finding actual text and get text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//li[contains(text(), 'Invalid email or password.')]"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual using Assert
        Assert.assertEquals("Error Message", expectedText, actualText);
    }

    @After
    public void setDown() {
        closeBrowser();
    }
}
