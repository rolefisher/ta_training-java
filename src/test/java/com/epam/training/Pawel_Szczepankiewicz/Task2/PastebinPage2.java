package com.epam.training.Pawel_Szczepankiewicz.Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPage2 {

    private WebDriver driver1;
    private WebDriverWait wait1;

    private By agreeButton = By.className("css-47sehv");
    private By codeTextBox = By.id("postform-text");

    private By highlightingDropdown = By.id("select2-postform-format-container");
    private By bashOption = By.xpath("//li[text()='Bash']");

    private By expirationDropdown = By.id("select2-postform-expiration-container");
    private By tenMinutesOption = By.xpath("//li[text()='10 Minutes']");

    private By pasteNameTextBox = By.id("postform-name");

    private By textBoxCheck = By.cssSelector("ol.bash");

    public PastebinPage2 (WebDriver driver1) {
        this.driver1 = driver1;
        this.wait1 = new WebDriverWait(driver1, Duration.ofSeconds(10));
    }

    public void openPage() {
        driver1.get("https://pastebin.com/");
    }

    public void agreeToTerms() {
        WebElement agreeBtn = wait1.until(ExpectedConditions.elementToBeClickable(agreeButton));
        agreeBtn.click();
    }

    public void enterCode(String code) {
        WebElement codeBox = driver1.findElement(codeTextBox);
        codeBox.sendKeys(code);
    }

    public void selectHighlighting(String optionText) {
        WebElement highlightingBox = driver1.findElement(highlightingDropdown);
        highlightingBox.click();
        WebElement option = driver1.findElement(bashOption);
        option.click();
    }

    public void selectExpiration(String optionText) {
        WebElement expirationBox = driver1.findElement(expirationDropdown);
        expirationBox.click();
        WebElement option = driver1.findElement(tenMinutesOption);
        option.click();
    }

    public void enterPasteName(String name) {
        WebElement nameBox = driver1.findElement(pasteNameTextBox);
        nameBox.sendKeys(name);
        nameBox.sendKeys(Keys.ENTER);
    }

    public void checkText(String content) {
        WebElement textBox = driver1.findElement(textBoxCheck);
    }

    public void closeBrowser() {
        driver1.quit();
    }



}
