package com.practice.gradle;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    @BeforeGroups
    public void groups() {
        System.out.println("Inside groups");
    }

    @BeforeTest
    public void setup() {
        System.out.println("Open database connection");
    }
    @BeforeMethod
    public void loggingIn() {
        System.out.println("Log in");
    }

    @Test
    public void homePage() {
        System.out.println("In home page");
    }

    @Test
    public void myAccount() {
        System.out.println("Opening Accounts Page");
    }

    @AfterMethod
    public void loggingOut() {
        System.out.println("Logout sucessfully");
    }

    @AfterTest
    public void close() {
        System.out.println("Close database connection");
    }

    @AfterGroups
    public void groups1() {
        System.out.println("In after groups");
    }
}
