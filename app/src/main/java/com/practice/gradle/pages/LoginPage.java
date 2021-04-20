package com.practice.gradle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver=null;

    By email = By.xpath("//input[@data-validate=\"isEmail\" and @ id=\"email\"]");
    By password = By.xpath("//input[@type=\"password\" and @ id=\"passwd\"]");
    By submit = By.xpath("//button[@type=\"submit\" and @id=\"SubmitLogin\"]");

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void giveEmailId(String username)
    {
        driver.findElement(email).sendKeys(username);
    }
    public void givePassword(String passwd)
    {
        driver.findElement(password).sendKeys(passwd);
    }
    public void clickOnSubmit()
    {
        driver.findElement(submit).click();
    }


}
