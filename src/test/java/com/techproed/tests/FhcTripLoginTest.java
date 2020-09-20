package com.techproed.tests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {

    @Test (groups = {"fhctrip", "login"})
    public void hotelTest(){
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");

        FhcTripLoginPage fhcTripLoginPage = new FhcTripLoginPage(driver);

        fhcTripLoginPage.userNameBox.sendKeys("manager2");
        fhcTripLoginPage.passwordBox.sendKeys("Man1ager2!");
        fhcTripLoginPage.logInButton.click();

    }

}
