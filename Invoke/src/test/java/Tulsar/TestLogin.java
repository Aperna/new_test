package Tulsar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by user on 05/08/2017.
 */
public class TestLogin {
//    private WebDriver driver;
//
//    @Before
//    public void invokeBrowser() throws Exception {
//        //Setting Chrome browser
//        System.setProperty("web.chrome.driver", "chrome.exe");
//        driver = new ChromeDriver();
//        //Opening the home page
//        driver.get("http://demo.nopcommerce.com/");
//        driver.manage().window().maximize();
//        //Setting TimeOut
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//    }
    public WebDriver driver;
    @Before
    public void invokeBrowser() throws Exception
    {
        System.setProperty("web.chrome.driver","chrome.exe");
        driver=new ChromeDriver();
        driver.get("http://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }



    @Test
    public void userInRegistration() {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("chine");
        driver.findElement(By.id("LastName")).sendKeys("west");
        Select dropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        dropdown.selectByIndex(10);
        Select dropdown1 = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        dropdown1.selectByVisibleText("March");
        Select dropdown2 = new Select(driver.findElement(By.name("DateOfBirthYear")));
        dropdown2.selectByVisibleText("1985");
        driver.findElement(By.id("Email")).sendKeys("Max21@ove.com");
        driver.findElement(By.id("Company")).sendKeys("Max ltd");
        driver.findElement(By.id("Newsletter")).click();
        driver.findElement(By.id("Password")).sendKeys("abc456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("abc456");
        driver.findElement(By.id("register-button")).click();
        driver.findElement(By.name("register-continue")).click();
        Assert.assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed());
    }
    @Test
    public void userLogin()throws Exception
    {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("Max21@ove.com");
        driver.findElement(By.id("Password")).sendKeys("abc456");
        driver.findElement(By.cssSelector(".button-1.login-button")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
