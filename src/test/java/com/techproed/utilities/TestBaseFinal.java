package com.techproed.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBaseFinal {

    protected WebDriver driver;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    protected static ExtentHtmlReporter extentHtmlReporter;

    //Test islemine baslamadan hemen önce(test methodundan önce degil, tüm test isleminden önce)
    @BeforeTest (alwaysRun = true) //alwaysRun: her zaman calistir.
    public void setUpTest() {//This is how to set up Extent report. We will create and use this one in out test classes
        extentReports = new ExtentReports();//1. create object to set the location of the report
        //olusturulan raporun eklenmesini istediginiz yer yazilir
        String filePath = System.getProperty("user.dir") + "/test-output/myprojectreport.html";//create a custom report in the current project.

        //Folder name = test-output, File name = report.html
        //String filePath = System.getProperty("user.dir") + "\\test-output\\report.html";//THIS IS FOR WINDOWS USER
        //olusturulmak istenen raporu HTML formatinda baslatip, filePath ile dosya yolu belirlenir
        extentHtmlReporter = new ExtentHtmlReporter(filePath);//2. creating the report with the path we created
        extentReports.attachReporter(extentHtmlReporter);//3. attaching the html report to our custom report

        //WE CAN ADD CUSTOM INFO. NOT NECESSARY. JUST TO GIVE MORE INFORMATION TO THE USER OR TEAM
        //Istenilen bilgiler buraya eklenebilir.
        extentReports.setSystemInfo("Environment", "Environment Name");
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser")); //
        extentReports.setSystemInfo("Automation Engineer", "Kadir");
        extentHtmlReporter.config().setDocumentTitle("Google Arama testi");
        extentHtmlReporter.config().setReportName("Google Arama Automation Reports");
    }


    //Her test methodundan sonra testte hata varsa ekran fotosu alip rapora ekler
    @AfterMethod(alwaysRun = true)//In AfterMethod, we are getting the screenshots and attaching the report when test fails
    public void tearDownMethod(ITestResult result) throws IOException {
        //Eger test sonucu basarisizsa
        if (result.getStatus() == ITestResult.FAILURE) {//When test case fails, then take the screenshot and attached the report
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());//getScreenshot is coming from ReusableMethods
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);//adding the screenshot to the report
            extentTest.fail(result.getThrowable());
            //Eger test calistirilmadan gecilmezse
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip("Test Case is skipped: " + result.getName());
        }
        Driver.closeDriver(); //Bu code tercihe bagli
    }


    //Raporlamayi sonlandirir
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        extentReports.flush();
    }
}