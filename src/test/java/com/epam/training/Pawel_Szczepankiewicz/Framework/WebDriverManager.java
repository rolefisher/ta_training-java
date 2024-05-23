package com.epam.training.Pawel_Szczepankiewicz.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverManager {

    private WebDriver driver;

    public WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    throw new IllegalArgumentException("Browser " + browser + " is not supported");
            }
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
