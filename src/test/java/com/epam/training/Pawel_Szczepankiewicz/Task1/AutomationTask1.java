package com.epam.training.Pawel_Szczepankiewicz.Task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class AutomationTask1 {

    private WebDriver driver;
    private com.epam.training.Pawel_Szczepankiewicz.Task1.PastebinPage1 pastebinPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pszcz\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\\");
        driver = new ChromeDriver();
        pastebinPage = new com.epam.training.Pawel_Szczepankiewicz.Task1.PastebinPage1(driver);
        pastebinPage.openPage();
    }

    @Test
    public void testCreateNewPaste() {
        pastebinPage.agreeToTerms();
        pastebinPage.enterCode("Hello from WebDriver");
        pastebinPage.selectExpiration("10 Minutes");
        pastebinPage.enterPasteName("helloweb");

        assertTrue(driver.getCurrentUrl().contains("pastebin.com"));
    }

    @After
    public void tearDown() {
        pastebinPage.closeBrowser();
    }

}
