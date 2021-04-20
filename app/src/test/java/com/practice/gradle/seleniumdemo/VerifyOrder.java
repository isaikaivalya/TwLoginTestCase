package com.practice.gradle.seleniumdemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyOrder {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test
    public void orderVerify()
    {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.xpath("//input[@data-validate=\"isEmail\" and @ id=\"email\"]")).sendKeys("bts007army22@gmail.com");
        driver.findElement(By.xpath("//input[@type=\"password\" and @ id=\"passwd\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type=\"submit\" and @id=\"SubmitLogin\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).click();
        boolean table = driver.findElement(By.xpath("//table[@id='order-list']")).isDisplayed();

        Assert.assertTrue(table,"Order present");
    }


    @AfterTest()
    public void close()
    {
        driver.quit();
    }
}
