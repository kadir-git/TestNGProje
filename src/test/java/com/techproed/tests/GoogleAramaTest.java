package com.techproed.tests;

import com.techproed.pages.GoogleAramaPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//TestBaseFinal class'ini miraz almamizin sebebi; TestBaseFinal class'inin icinde
//rapor almak icin kullanacagimiz nesneler ve methodlar var.
public class GoogleAramaTest extends TestBaseFinal {

    // 1. Adım : Google.com'a gidelim.
    // 2. Adım : techproeducation araması yapalım
    // 3. Adım : sonuçlar içerisinde techproeducation.com var mı, doğrulayalım.

    @Test
    public void aramaTesti() throws InterruptedException {
        extentTest = extentReports.createTest("Google Arama", "Google'da techproeducation aramasi yaptik.");

        extentTest.info("Sayfa adresine git.");
        Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));

        extentTest.info("Webelementleri kullanabilmek icin nesne olustur.");
        GoogleAramaPage googleAramaPage = new GoogleAramaPage();

        extentTest.info("techproeducation aramasi yap.");
        googleAramaPage.aramaKutusu.sendKeys("techproeducation" + Keys.ENTER);

        extentTest.info("3 sn bekle.");
        Thread.sleep(3000);

        extentTest.info("tüm linkleri karsilastir.");
        boolean linkVarMi = false;
        for (WebElement w: googleAramaPage.tumLinkler) {
            if (w.getText().contains("techproeducation.com")){
                linkVarMi = true;
                break;
            }
        }

        extentTest.info("asssert islemi yap.");
        Assert.assertTrue(linkVarMi);
        extentTest.pass("Test PASSED !");


    }


}
