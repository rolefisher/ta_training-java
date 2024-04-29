package com.epam.training.Pawel_Szczepankiewicz.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationTask1 {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {

            WebDriver driver = new ChromeDriver();

            Duration duration = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver, duration);

            driver.get("https://pastebin.com/");

            //agreement
            WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("css-47sehv")));
            agreeButton.click();

            //code textbox
            WebElement textBox = driver.findElement(By.id("postform-text"));
            textBox.sendKeys("Hello from WebDriver");

            //checkbox selection
            WebElement checkbox = driver.findElement(By.id("select2-postform-expiration-container"));
            checkbox.click();

            //10 minutes option
            WebElement option = driver.findElement(By.xpath("//li[text()='10 Minutes']"));
            option.click();

            //past name / title textbox
            WebElement textBox1 = driver.findElement(By.id("postform-name"));
            textBox1.sendKeys("helloweb");

            //accepting the data
            textBox1.sendKeys(Keys.ENTER);

            //quit
            driver.quit();

        }

    }

}
