package com.techproed.smoketests;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class GlbSignUpTest {

    @Test
    public void test(){

        /*
         * 1. Adım : https://www.glbtrader.com/register-2.html adresine gidelim
         * 2. Adım : GlbSignUpPage class'ından nesne üretip, webelementleri kullanalım.
         * 3. Adım : İçerisine ekleyeceğimiz bilgileri (name, email, phone vs) yine
         *           ConfigurationReader kullanarak, properties file'dan alalım.
         * 4. Adım : Sign-Up butonuna tıklayalım.
         * 5. Adım : Success yazısını görüp görmediğimi Assert ile doğrulayalım.
         */

                                                        //https://www.glbtrader.com/register-2.html
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_login"));

        GlbSignUpPage glbSignUpPage  = new GlbSignUpPage();

        glbSignUpPage .emailBox.sendKeys(ConfigurationReader.getProperty("glb_email"));
        glbSignUpPage .nameBox.sendKeys(ConfigurationReader.getProperty("glb_name"));
        glbSignUpPage .mobileBox.sendKeys(ConfigurationReader.getProperty("glb_phone"));
        glbSignUpPage .passwordBox.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        glbSignUpPage .rePasswordBox.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        glbSignUpPage .signUp.click();



        // signUp butonuna tıkladıktan sonra, Success!! yazısını hemen alabilir miyim ?
        System.out.println(glbSignUpPage.basariliYazisi.getText());

        boolean dogruMu = glbSignUpPage.basariliYazisi.getText().contains("Success");
        Assert.assertTrue(dogruMu);

    }

    @AfterClass
    public void tearDown(){

        // Driver class'ının içerisindeki closeDriver methodunu çağırmamız yeterli.
        // Driver'ı kapattık ve hafızadan sildik.
        //Driver.closeDriver();
    }

}
