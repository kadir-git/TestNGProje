package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelOlusturma extends TestBase {

    @BeforeMethod
    public void girisTest(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");

        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);

    }

    @Test
    public void hotelCreate(){
        driver.findElement(By.id("Code")).sendKeys("Resort Hotel");
        driver.findElement(By.id("Name")).sendKeys("Koala Palace");
        driver.findElement(By.id("Address")).sendKeys("Maldivler");
        driver.findElement(By.id("Phone")).sendKeys("+1555337766");
        driver.findElement(By.id("Email")).sendKeys("kadir@hotel.com");

        WebElement idGroup = driver.findElement(By.id("IDGroup"));

        Select select = new Select(idGroup);
        select.selectByVisibleText("Hotel Type2");

        driver.findElement(By.id("btnSubmit")).click();

        // WebElement basariliYazisi = driver.findElement(By.className("bootbox-body"));
        WebDriverWait wait = new WebDriverWait(driver, 20);


        WebElement basariliYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(basariliYazisi.isDisplayed());

    }



}
