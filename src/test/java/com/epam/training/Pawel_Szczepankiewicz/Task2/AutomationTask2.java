package com.epam.training.Pawel_Szczepankiewicz.Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationTask2 {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {

            WebDriver driver = new ChromeDriver();

            Duration duration = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver, duration);


            // 1.Open https://pastebin.com/ or a similar service in any browser.

            driver.get("https://pastebin.com/");


            // 2.Create 'New Paste' with the following attributes:

            //agreement
            WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("css-47sehv")));
            agreeButton.click();

            //code textbox
            WebElement textBox = driver.findElement(By.id("postform-text"));
            textBox.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force\n");

            //syntax checkbox selection
            WebElement checkbox = driver.findElement(By.id("select2-postform-format-container"));
            checkbox.click();

            //bash option
            WebElement option = driver.findElement(By.xpath("//li[text()='Bash']"));
            option.click();

            //syntax checkbox selection
            WebElement checkbox1 = driver.findElement(By.id("select2-postform-expiration-container"));
            checkbox1.click();

            //10 minutes option
            WebElement option1 = driver.findElement(By.xpath("//li[text()='10 Minutes']"));
            option1.click();

            //past name / title textbox
            WebElement textBox1 = driver.findElement(By.id("postform-name"));
            textBox1.sendKeys("how to gain dominance among developers");

            //accepting the data
            textBox1.sendKeys(Keys.ENTER);


            // 3.Save 'paste' and check the following:

            //Browser page title matches 'Paste Name / Title'
            WebElement h1Element = driver.findElement(By.xpath("//div[contains(@class, 'info-top')]//h1"));
            String elementText = h1Element.getText();

            if (elementText.equals("how to gain dominance among developers")) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }

            //Syntax is suspended for bash
            boolean syntaxSuspended = driver.findElements(By.xpath("//*[contains(text(), 'Syntax is suspended for bash')]")).isEmpty();
            System.out.println(syntaxSuspended);

            //Check that the code matches the one from paragraph 2.
            WebElement textareaElement = driver.findElement(By.className("textarea -raw js-paste-raw"));
            String text = textareaElement.getText();
            String wantedText = "git config --global user.name  \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force";
            boolean textBoolean = text.equals(wantedText);
            System.out.println(textBoolean);


            //quit
            driver.quit();

        }

    }

}
