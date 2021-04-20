package com.practice.gradle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    WebDriver driver=null;

    By clickOnOrderList = By.xpath("//span[text()='Order history and details']");

    public OrderPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void verifyOrders()
    {
        driver.findElement(clickOnOrderList).click();
    }

}
