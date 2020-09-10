package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcTripHotelCreatePage {

    WebDriver driver;

    public FhcTripHotelCreatePage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Code")
    public WebElement codeBox;

    @FindBy (id = "Name")
    public WebElement nameBox;

    @FindBy(id = "Address")
    public WebElement addressBox;

    @FindBy (id = "Phone")
    public WebElement phoneBox;

    @FindBy (id = "Email")
    public WebElement emailBox;

    @FindBy (id = "IDGroup")
    public WebElement iDGroupBox;

    @FindBy (id = "btnSubmit")
    public WebElement saveButton;

}
