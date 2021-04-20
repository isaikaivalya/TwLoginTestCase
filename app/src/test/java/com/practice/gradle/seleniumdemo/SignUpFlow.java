package com.practice.gradle.seleniumdemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SignUpFlow {

    WebDriver driver;

    @BeforeTest
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test
    public void createAccount() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();

        driver.findElement(By.id("email_create")).sendKeys("dummy123@gmail.com");

        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();

        WebElement radio= driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
        radio.click();

        driver.findElement(By.id("customer_firstname")).sendKeys("Nani");

        driver.findElement(By.id("customer_lastname")).sendKeys("Junnu");

        driver.findElement(By.id("passwd")).sendKeys("123456");

        Select dobday = new Select(driver.findElement(By.id("days")));
        dobday.selectByValue("2");

        Select dobmonth = new Select(driver.findElement(By.id("months")));
        dobmonth.selectByValue("11");

        Select dobyear = new Select(driver.findElement(By.id("years")));
        dobyear.selectByValue("1998");

        driver.findElement(By.id("company")).sendKeys("Tw");

        driver.findElement(By.id("address1")).sendKeys("1-2-19, flat no 102");

        driver.findElement(By.id("city")).sendKeys("California");

        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByValue("5");

        driver.findElement(By.id("postcode")).sendKeys("90034");

        Select country = new Select(driver.findElement(By.id("id_country")));
        country.selectByValue("21");

        driver.findElement(By.id("phone_mobile")).sendKeys("7654272922");

        driver.findElement(By.id("alias")).sendKeys("cartoon@gmail.com");

        driver.findElement(By.xpath("//button[@id=\"submitAccount\"]")).click();
        Thread.sleep(5000);

    }

    @AfterTest()
    public void close()
    {
        driver.quit();
    }

}
