package com.bridgelabz.main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    @BeforeSuite
    public void beforeSuite(){System.out.println("Before Suite");}
    public static WebDriver driver = null;
    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional("Firefox") String Browser){
        if (Browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (Browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else {
            System.out.println("Not Selected any Browser!!!");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void TearDown(){
        driver.close();
    }
    public static void takeScreenshot(String testName) throws IOException {
        Date date = new Date();
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("Screenshot/"+testName+date.getTime()+".png");
        FileUtils.copyFile(srcFile,destinationFile);
    }
}

