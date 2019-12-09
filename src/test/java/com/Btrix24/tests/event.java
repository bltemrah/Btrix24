package com.Btrix24.tests;

import com.Btrix24.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class event {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        //clicking the start button
        driver.findElement(By.tagName("button")).click();
        //find the username inputbox
        WebElement username = driver.findElement(By.id("username"));

        //How to wait explicitly
        //Create Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //call until method from wait object
        //waiting for the sepecific element to be visible up to 10 sec
        wait.until(ExpectedConditions.visibilityOf(username));

        //sending some username
        username.sendKeys("Mike Smith");
        
        //Let see git pull effect
    }
}
