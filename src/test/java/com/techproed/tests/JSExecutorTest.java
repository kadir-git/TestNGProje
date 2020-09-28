package com.techproed.tests;

import com.techproed.pages.AmazonNewPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorTest {

    @Test
    public void amazonArama(){
        Driver.getDriver().get("http://amazon.com");

        //JS ile bir web sayfasinin basligini alabiliriz.
        String baslik = JSExecutor.getTitleByJS();
        System.out.println(baslik);

        AmazonNewPage amazonNewPage = new AmazonNewPage();
        amazonNewPage.aramaKutusu.sendKeys("samsung");

        //JS ile bir webelemente tiklayabiliyoruz
        JSExecutor.clickElementByJS(amazonNewPage.aramaButonu);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //JS ile bir web sayfasinin en altina gidilebilir.
        JSExecutor.scrollDownByJS();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //JS ile istenilen webelementin oldugu bölüme gidilebilir
        WebElement farbe = Driver.getDriver().findElement(By.xpath("//span[.='Farbe']"));
        JSExecutor.scrollInToViewJS(farbe);

        //JS ile bir webelementin arka plan rengi gecici degistirilebilir
        JSExecutor.flash(farbe);

        //JS ile bir webelementin arka plan rengi degistirilebilir.
        WebElement condition = Driver.getDriver().findElement(By.xpath("//*[.='Zustand']"));
        JSExecutor.changeColor("rgb(255,0,0", condition);

        //JS ile isterseniz websayfasında JSAlert üretebiliyorsunuz.
        JSExecutor.generateAlert("Test bitti! Selenium dersi de bitti!");
    }




}
