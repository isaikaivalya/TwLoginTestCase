package com.practice.gradle.training;

import com.practice.gradle.utilities.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {
        if(ITestResult.FAILURE == result.getStatus())
        {
            Utility.captureScreenshot(driver,result.getName());
        }
        driver.quit();
    }

}
