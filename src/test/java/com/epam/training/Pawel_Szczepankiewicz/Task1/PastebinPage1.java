package com.epam.training.Pawel_Szczepankiewicz.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPage1 {
    private WebDriver driver;
    private WebDriverWait wait;

    private By agreeButton = By.className("css-47sehv");
    private By codeTextBox = By.id("postform-text");
    private By expirationDropdown = By.id("select2-postform-expiration-container");
    private By tenMinutesOption = By.xpath("//li[text()='10 Minutes']");
    private By pasteNameTextBox = By.id("postform-name");

    public PastebinPage1 (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPage() {
        driver.get("https://pastebin.com/");
    }

    public void agreeToTerms() {
        WebElement agreeBtn = wait.until(ExpectedConditions.elementToBeClickable(agreeButton));
        agreeBtn.click();
    }

    public void enterCode(String code) {
        WebElement codeBox = driver.findElement(codeTextBox);
        codeBox.sendKeys(code);
    }

    public void selectExpiration(String optionText) {
        WebElement expirationBox = driver.findElement(expirationDropdown);
        expirationBox.click();
        WebElement option = driver.findElement(tenMinutesOption);
        option.click();
    }

    public void enterPasteName(String name) {
        WebElement nameBox = driver.findElement(pasteNameTextBox);
        nameBox.sendKeys(name);
        nameBox.sendKeys(Keys.ENTER);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
