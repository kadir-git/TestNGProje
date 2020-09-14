package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {

    @Test
    public void dosyaVarMi(){
        //bilgisayardaki dosya yolu alinir
        System.out.println(System.getProperty("user.dir"));     //C:\Users\kayao\IdeaProjects\TestNGProje

        System.out.println(System.getProperty("user.home"));    //C:\Users\kayao

        String kullaniciDosyaYolu = System.getProperty("user.dir");

        //C:/Users/kayao/IdeaProjects/TestNGProje/pom.xml
        String pomXmlDosyaYolu = kullaniciDosyaYolu + "/pom.xml";

        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        Assert.assertTrue(varMi);
    }

    @Test
    public void dosyaUpload(){ //bilgisayardan web sayfasina dosya yükleme

        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:/Users/kayao/Downloads/logo.png");

        WebElement upLoadButonu = driver.findElement(By.id("file-submit"));
        upLoadButonu.click();

        WebElement fileUploaded = driver.findElement(By.xpath("//*[.='File Uploaded!']"));
        Assert.assertTrue(fileUploaded.isDisplayed());

    }

    @Test
    public void dosyaDownload(){

        driver.get("http://the-internet.herokuapp.com/download");
        //C:\Users\kayao\Downloads\Amsterdam.jpg
        WebElement amsterdamLinki = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        amsterdamLinki.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean varMi = Files.exists(Paths.get("C:\\Users\\kayao\\Downloads\\Amsterdam.jpg"));
        Assert.assertTrue(varMi);
    }

}
