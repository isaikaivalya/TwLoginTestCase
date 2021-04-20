package com.practice.gradle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
    WebDriver driver ;

    By openSignInPage = By.xpath("//a[@title='Log in to your customer account']");

    By mailId = By.id("email_create");

    By clickSubmit = By.xpath("//*[@id=\"SubmitCreate\"]");

    By radio1 = By.xpath("//*[@id=\"id_gender2\"]");

    By firstName = By.id("customer_firstname");

    By lastName = By.id("customer_lastname");

    By passwd = By.id("passwd");

     By dobday = By.id("days");

    By dobmonth = By.id("months");

    By dobyear = By.id("years");

    By company = By.id("company");

    By address =  By.id("address1");

    By city = By.id("city");

     By state = By.id("id_state");

    By postcode = By.id("postcode");

    By country = By.id("id_country");

    By mobile = By.id("phone_mobile");

    By alias = By.id("alias");

    By register = By.xpath("//button[@id=\"submitAccount\"]");

    public SignUpPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickOnSign()
    {
        driver.findElement(openSignInPage).click();
    }

    public void provideEmail(String email)
    {
        driver.findElement(mailId).sendKeys(email);
    }

    public void clickSubmit()
    {
        driver.findElement(clickSubmit).click();
    }

    public void clickOnRadio()
    {
        driver.findElement(radio1).click();
    }

    public void giveFirstName(String frstname)
    {
        driver.findElement(firstName).sendKeys(frstname);
    }

    public void giveLastName(String lsttname)
    {
        driver.findElement(lastName).sendKeys(lsttname);
    }

    public void givePassword(String password)
    {
        driver.findElement(passwd).sendKeys(password);
    }

    public void selectDate(String day)
    {
        new Select(driver.findElement(dobday)).selectByValue(day);
    }

    public void selectMonth(String month)
    {
        new Select(driver.findElement(dobmonth)).selectByValue(month);
    }

    public void selectYear(String year)
    {
        new Select(driver.findElement(dobyear)).selectByValue(year);
    }

    public void companyName(String cmp)
    {
        driver.findElement(company).sendKeys(cmp);
    }

    public void giveAddress(String addr)
    {
        driver.findElement(address).sendKeys(addr);
    }

    public void giveCity(String cty)
    {
        driver.findElement(city).sendKeys(cty);
    }

    public void selectState(String stateid)
    {
        new Select(driver.findElement(state)).selectByValue(stateid);
    }

    public void givePostCode(String pc)
    {
        driver.findElement(postcode).sendKeys(pc);
    }

    public void selectCountryId(String Id)
    {
        new Select(driver.findElement(country)).selectByValue(Id);
    }

    public void giveMobile(String num)
    {
        driver.findElement(mobile).sendKeys(num);
    }

    public void giveAlias(String al)
    {
        driver.findElement(alias).sendKeys(al);
    }

    public void clickOnRegister()
    {
        driver.findElement(register).click();
    }
}
