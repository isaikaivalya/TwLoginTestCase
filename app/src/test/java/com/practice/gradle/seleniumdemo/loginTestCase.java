package com.practice.gradle.seleniumdemo;

import com.practice.gradle.pages.HomePage;
import com.practice.gradle.pages.LoginPage;
import com.practice.gradle.pages.OrderPage;
import com.practice.gradle.pages.SignUpPage;
import com.practice.gradle.training.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;


public class loginTestCase extends BaseTest {

    @Test(dataProvider = "getData")
    public void browserLaunchTest(String username, String password)
    {
        Assert.assertEquals(driver.getTitle().trim(),"My Store", "Verification for page title");

        HomePage homePage=new HomePage(driver);
        LoginPage loginPage=new LoginPage(driver);
        OrderPage orders=new OrderPage(driver);

        homePage.clickOnSignInLink();

        loginPage.giveEmailId(username);
        loginPage.givePassword(password);
        loginPage.clickOnSubmit();

        String st1="Login - My Store";
        String st2=driver.getTitle();
        if(!st1.equals(st2)) {
            Assert.assertEquals(st2,"My account - My Store","Verifying credentials");
            orders.verifyOrders();
            boolean table = driver.findElement(By.xpath("//table[@id='order-list']")).isDisplayed();
            Assert.assertTrue(table,"Order not present");
            driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();

        }
        else
            Assert.assertEquals(st1,st2,"Valid credentials");

    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[2][2];
        data[0][0]= "bts007army22@gmail.com";
        data[0][1]="123456";

        data[1][0]= "dummy123@gmail.com";
        data[1][1]="1234546";

        return data;
    }
}
