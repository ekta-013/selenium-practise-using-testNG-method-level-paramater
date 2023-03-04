package com.bridgelabz.test;

import com.bridgelabz.main.BaseClass;
import org.openqa.selenium.By;

public class TestMethodParameter extends BaseClass {

    public void test(String phoneNo, String emailId) throws InterruptedException {
        driver.get("https://bldev.bridgelabz.com/webinar");
        driver.findElement(By.id("deftphnumber")).sendKeys(phoneNo);
        Thread.sleep(500);
        driver.findElement(By.id("deftemail")).sendKeys(emailId);
        Thread.sleep(500);
    }
}
