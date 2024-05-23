package com.epam.training.Pawel_Szczepankiewicz.Task3;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPlatformCalculator {

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchButton = By.className("mb2a7b");
    private By resultOfSearch = By.cssSelector("a.gs-title");
    private By estimateButton = By.className("UywwFc-vQzf8d");
    private By computeButton = By.cssSelector("div[data-service-form='8']");
    private By numberInputBox = By.id("c11");

    private By cpuInputBox = By.id("c35");
    private By memoryInputBox = By.xpath("//input[@id='c36']");

    private By gpuSliderButton = By.xpath("//*[@id='ow4']/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[21]/div/div/div[1]/div/div/span/div/button/div/div");

    private By machineDropdown = By.xpath("//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[1]/div");
    private By machineOption = By.xpath("//*[@id='ow4']/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[2]/ul/li[4]");

    private By yearOption = By.xpath("//*[@id='ow4']/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[31]/div/div/div[2]/div/div/div[2]/label");

    private By labelElement = By.xpath("//*[@id='ow4']/div/div/div/div/div/div/div[2]/div[1]/div/div[4]/div[1]/div[2]/label");

    private By shareButton = By.xpath("//*[@id='ow4']/div/div/div/div/div/div/div[2]/div[1]/div/div[4]/div[2]/div[2]/div/button");

    private By estimateSummary = By.xpath("//*[@id='yDmH0d']/div[6]/div[2]/div/div/div/div[1]/a");

    private By finalPrice = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[1]/div/div[1]/div[1]/h4");

    private By newTab = By.id("https://cloud.google.com/products/calculator/estimate-preview/d11d5c2c-b512-44b8-a94a-d4b5af9f66aa?hl=en");


    public GoogleCloudPlatformCalculator(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPage() {
        driver.get("https://cloud.google.com/");
    }

    public void enterData(String data) {
        WebElement searchBox = driver.findElement(searchButton);
        searchBox.sendKeys(data);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void openCalculator() {
        WebElement result = driver.findElement(resultOfSearch);
        result.click();
    }

    public void addEstimate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));;
        WebElement estimateBox = wait.until(ExpectedConditions.visibilityOfElementLocated(estimateButton));
        estimateBox.click();

        WebElement computeBox = wait.until(ExpectedConditions.visibilityOfElementLocated(computeButton));
        computeBox.click();
    }

    public void fillData() throws Exception {

        //Number of instances: 4
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement numberBox = wait.until(ExpectedConditions.visibilityOfElementLocated(numberInputBox));

        numberBox.click();
        numberBox.clear();
        numberBox.sendKeys("4");

        //Machine type: n1-standard-8 (vCPUs: 8, RAM: 30 GB)

        WebElement acceptButton = driver.findElement(By.cssSelector("button.glue-cookie-notification-bar__accept"));
        acceptButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("glue-cookie-notification-bar-1")));

        WebElement cpuBox = driver.findElement(cpuInputBox);
        cpuBox.click();
        cpuBox.clear();
        cpuBox.sendKeys("8");

        Thread.sleep(1000);

        WebElement memoryBox = driver.findElement(memoryInputBox);
        memoryBox.click();
        memoryBox.sendKeys(Keys.BACK_SPACE);
        memoryBox.sendKeys(Keys.BACK_SPACE);
        memoryBox.sendKeys(Keys.BACK_SPACE);
        memoryBox.sendKeys(Keys.BACK_SPACE);
        memoryBox.sendKeys("30");

        //* Select “Add GPUs“
        //* GPU type: NVIDIA Tesla V100
        //* Number of GPUs: 1

        WebElement sliderButton = driver.findElement(gpuSliderButton);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", sliderButton);

        WebElement machineDropdownBox = wait.until(ExpectedConditions.elementToBeClickable(machineDropdown));
        machineDropdownBox.click();

        WebElement machineOptionBox = wait.until(ExpectedConditions.elementToBeClickable(machineOption));
        machineOptionBox.click();

        WebElement yearOptionBox = wait.until(ExpectedConditions.elementToBeClickable(yearOption));
        yearOptionBox.click();

        // Check if prize exists
        String estimatedValue = getElementValue(labelElement);

        Thread.sleep(2000);

        // Click share button
        WebElement shareButtonBox = wait.until(ExpectedConditions.elementToBeClickable(shareButton));
        shareButtonBox.click();

        // Click estimate summary
        WebElement estimateSummaryBox = wait.until(ExpectedConditions.elementToBeClickable(estimateSummary));
        estimateSummaryBox.click();

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
