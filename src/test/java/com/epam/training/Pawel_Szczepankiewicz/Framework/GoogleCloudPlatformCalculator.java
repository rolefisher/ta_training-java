package com.epam.training.Pawel_Szczepankiewicz.Framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPlatformCalculator {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "mb2a7b")
    private WebElement searchButton;

    @FindBy(css = "a.gs-title")
    private WebElement resultOfSearch;

    @FindBy(className = "UywwFc-vQzf8d")
    private WebElement estimateButton;

    @FindBy(css = "div[data-service-form='8']")
    private WebElement computeButton;

    @FindBy(id = "c11")
    private WebElement numberInputBox;

    @FindBy(id = "c35")
    private WebElement cpuInputBox;

    @FindBy(xpath = "//input[@id='c36']")
    private WebElement memoryInputBox;

    @FindBy(xpath = "//*[@id='ow4']/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[21]/div/div/div[1]/div/div/span/div/button/div/div")
    private WebElement gpuSliderButton;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[1]/div")
    private WebElement machineDropdown;

    @FindBy(xpath = "//*[@id='ow4']/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[2]/ul/li[4]")
    private WebElement machineOption;

    @FindBy(xpath = "//*[@id='ow4']/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[31]/div/div/div[2]/div/div/div[2]/label")
    private WebElement yearOption;

    @FindBy(xpath = "//*[@id='ow4']/div/div/div/div/div/div/div[2]/div[1]/div/div[4]/div[1]/div[2]/label")
    private By labelElement;

    @FindBy(xpath = "//*[@id='ow4']/div/div/div/div/div/div/div[2]/div[1]/div/div[4]/div[2]/div[2]/div/button")
    private WebElement shareButton;

    @FindBy(xpath = "//*[@id='yDmH0d']/div[6]/div[2]/div/div/div/div[1]/a")
    private WebElement estimateSummary;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[1]/div/div[1]/div[1]/h4")
    private WebElement finalPrice;

    public GoogleCloudPlatformCalculator(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get("https://cloud.google.com/");
    }

    public void enterData(String data) {
        searchButton.sendKeys(data);
        searchButton.sendKeys(Keys.ENTER);
    }

    public void openCalculator() {
        resultOfSearch.click();
    }

    public void addEstimate() {
        WebElement estimateBox = wait.until(ExpectedConditions.visibilityOf(estimateButton));
        estimateBox.click();

        WebElement computeBox = wait.until(ExpectedConditions.visibilityOf(computeButton));
        computeBox.click();
    }

    public void fillData() throws Exception {
        WebElement numberBox = wait.until(ExpectedConditions.visibilityOf(numberInputBox));
        numberBox.click();
        numberBox.clear();
        numberBox.sendKeys("4");

        WebElement acceptButton = driver.findElement(By.cssSelector("button.glue-cookie-notification-bar__accept"));
        acceptButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("glue-cookie-notification-bar-1")));

        cpuInputBox.click();
        cpuInputBox.clear();
        cpuInputBox.sendKeys("8");

        Thread.sleep(1000);

        memoryInputBox.click();
        memoryInputBox.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        memoryInputBox.sendKeys("30");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", gpuSliderButton);

        machineDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(machineOption)).click();

        yearOption.click();

        String estimatedValue = getElementValue(labelElement);

        Thread.sleep(2000);

        shareButton.click();
        estimateSummary.click();
    }

    public String getElementValue(By element) throws Exception {
        WebElement value = driver.findElement(element);
        String elementText = value.getText();
        return elementText;
    }

    public void closeBrowser() {
        driver.quit();
    }

}
