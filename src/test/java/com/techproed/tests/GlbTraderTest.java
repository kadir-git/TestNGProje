package com.techproed.tests;

import com.techproed.pages.GlbTraderPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbTraderTest extends TestBaseFinal {

    @Test
    public void arama() throws InterruptedException {

        extentTest = extentReports.createTest("Baslik karsilastirma.", "Ürün ismi ve sayfa basligini karsilastiralim.");

        extentTest.info("Sayfa adresine gidelim.");
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_search"));

        extentTest.info("Glb nesnesi üretelim.");
        GlbTraderPage glbTraderPage = new GlbTraderPage();


        extentTest.info("select nesnesi üretelim.");
        Select select = new Select(glbTraderPage.kategorilerDropDown);
        select.selectByVisibleText("Consumer Electronics");

        extentTest.info("Arama kutusuna kelime yazalim.");
        glbTraderPage.aramaKutusu.sendKeys(ConfigurationReader.getProperty("glb_kelime") + Keys.ENTER);

        extentTest.info("2.siradaki ürünün ismini aldık.");
        String urunIsmi = glbTraderPage.sonuclarListe.get(1).getText();

        extentTest.info("2. sıradaki ürüne tıkladık.");
        glbTraderPage.sonuclarListe.get(1).click();

        extentTest.info("3 sn bekle dedik.");
        Thread.sleep(3000);

        extentTest.info("Sayfa başlığını aldık.");
        String sayfaBasligi = Driver.getDriver().getTitle();

        extentTest.info("Assert işlemi yapalım.");
        Assert.assertEquals(urunIsmi , sayfaBasligi);

        extentTest.pass("Testimiz PASS!");

    }

}
