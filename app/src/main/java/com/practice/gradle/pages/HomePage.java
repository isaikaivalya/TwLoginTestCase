package com.practice.gradle.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver=null;

    By signInLink = By.xpath("//a[@title='Log in to your customer account']");
    By contactUs = By.xpath("//a[@title='Contact Us']");

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void clickOnSignInLink()
    {
        driver.findElement(signInLink).click();
    }
    public void clickOnContactUs()
    {
        driver.findElement(contactUs).click();
    }
}
