package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase {    //Day 14 06 September 2020 Sonntag

    @Test
    public void test01(){
        driver.get("http://amazon.com");
        WebElement element = driver.findElement(By.id("nav-link-accountList"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        WebElement kayit = driver.findElement(By.xpath("//*[.='Starten Sie hier.'] "));
        kayit.click();

        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Amazon Registrierung", title);

        WebElement name = driver.findElement(By.id("ap_customer_name"));
        name.sendKeys("Kadir");

        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("kadir@gmail.com");

        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys("asdf/?1234");

        WebElement passwordCheck = driver.findElement(By.id("ap_password_check"));
        passwordCheck.sendKeys("asdf/?1234");

        WebElement button = driver.findElement(By.id("a-autoid-0"));
        button.click();
    }

}
