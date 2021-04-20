package com.practice.gradle.seleniumdemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchAddCart{
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test
    public void searchAndSelect() throws InterruptedException
    {
        String str3="dress";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.id("search_query_top")).sendKeys(str3);

        driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();

        String str2=driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getAttribute("innerHTML");

        Assert.assertTrue(str2.contains(str3),"Search result found");

        //driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).click();

        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        Thread.sleep(5000);

    }

    @AfterTest()
    public void close()
    {
        driver.quit();
    }
}
