package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase  {    // DAY 14 - 6 Eylül 2020 Pazar

    @Test
    public void test01(){

        driver.get("http://amazon.com");

        // 1. Adım : Mouse'u moveToElement methodunu kullanarak, Account & Lists
        //           webelementinin üzerine götürün.
        // 2. Adım : Start here. linkine tıklayın.

        WebElement button = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);

        // mouse'u webelement'in üzerine götürme işlemi yapıyoruz.
        actions.moveToElement(button).perform();

        // By.partialLinkText("Starten Sie hier.")
        WebElement startenSieHier = driver.findElement(By.xpath("//*[.='Starten Sie hier.'] "));
        startenSieHier.click();

        // 3. Adım : Sayfanın title'ı Amazon Registration ise testiniz başarılı olsun.
        // True kullanarak Assert.assertTrue(driver.getTitle().equals("Amazon Registrierung"));
        // Assert.assertFalse(!driver.getTitle().equals("Amazon Registrierung"));
        //Assert.assertEquals(driver.getTitle(),"Amazon Registrierung");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Amazon Registrierung", title);

    }

    @Test (dependsOnMethods = "test01")
    public void test02(){

        WebElement name = driver.findElement(By.id("ap_customer_name"));
        name.sendKeys("Kadir");

        driver.findElement(By.id("ap_email")).sendKeys("kadir@protonmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("Amazon06.mld");
        driver.findElement(By.id("ap_password_check")).sendKeys("Amazon06.mld");
        driver.findElement(By.id("continue")).click();
    }
}