package com.epam.training.Pawel_Szczepankiewicz.Task2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class AutomationTask2 {

    private WebDriver driver;
    private com.epam.training.Pawel_Szczepankiewicz.Task2.PastebinPage2 pastebinPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pszcz\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\\");
        driver = new ChromeDriver();
        pastebinPage = new com.epam.training.Pawel_Szczepankiewicz.Task2.PastebinPage2(driver);
        pastebinPage.openPage();
    }

    @Test
    public void testCreateNewPaste() {
        pastebinPage.agreeToTerms();
        pastebinPage.enterCode("""
                git config --global user.name  "New Sheriff in Town"
                git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
                git push origin master --force""");
        pastebinPage.selectHighlighting("Bash");
        pastebinPage.selectExpiration("10 Minutes");
        pastebinPage.enterPasteName("how to gain dominance among developers");

        WebElement bashElement = driver.findElement(By.cssSelector("ol.bash"));

        String actualText = bashElement.getText();
        String expectedText = "git config --global user.name  \"New Sheriff in Town\"\n"
                + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
                + "git push origin master --force";

        assertEquals(expectedText, actualText);

        assertEquals("how to gain dominance among developers - Pastebin.com" , driver.getTitle());

    }

    @After
    public void tearDown() {
        pastebinPage.closeBrowser();
    }


}
