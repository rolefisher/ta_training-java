package com.epam.training.Pawel_Szczepankiewicz.Framework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationTask3 {

    private WebDriver driver;
    private GoogleCloudPlatformCalculator GoogleCalculator;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pszcz\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\\");
        driver = new ChromeDriver();
        GoogleCalculator = new GoogleCloudPlatformCalculator(driver);
        GoogleCalculator.openPage();
    }

    @Test
    public void testCreateNewPaste() throws Exception {

        GoogleCalculator.enterData("Google Cloud Platform Pricing Calculator");
        GoogleCalculator.openCalculator();
        GoogleCalculator.addEstimate();
        GoogleCalculator.fillData();

    }

    @After
    public void tearDown() {
        GoogleCalculator.closeBrowser();
    }

}
