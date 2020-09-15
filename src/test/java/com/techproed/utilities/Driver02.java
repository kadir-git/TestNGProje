package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver02 {

    //Eger bir class'tan NESNE ÜRETILMESINI ISTEMIYORSANIZ
    //constructor'i private yapabilirseniz. (Singleton )
    private Driver02(){
    }

    // WebDriver nesnemizi, static olarak oluşturduk, çünkü program başlar başlamaz
    // hafızada yer almasını istiyoruz.
    static WebDriver driver;

    //Programin herhangi bir yerinden getDriver() methodu cagrilarak
    //hafizada STATIC olarak olusturulmus DRIVER nesnesine erisebiliriz.
    //Yani yeniden WebDriver nesnesi olusturmak zorunda degiliz.
    //Driver.getDriver()
    public static WebDriver getDriver(){

        //Eger driver nesnesi hafizada bossa olusturulmamissa yenden olusturmana gerek yok
        //Eger null ise yeniden olusturabilirsin
        //Sadece ilk cagrildiginda bir tane nesne üret, sonraki cagirmalarda var olan nesnesi kullan.
        if (driver==null){
            //Eger Chrome kullanmak istiyorsak
            switch (ConfigurationReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

            // Eger firefox kullanmak istiyorsak
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        return driver;
    }

    public static void closeDriver(){
        //Eger driver nesnesi null degilse yani hafizada varsa
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }





}
