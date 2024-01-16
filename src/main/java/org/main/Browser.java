package org.main;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/*
Author: Muhammad Fadhlan Harits
Explanation:
This class is used for navigating the URL
 */

public class Browser {
    // Initiate selenium webdriver
    private WebDriver driver;


    // Initialize chrome browser
    public Browser(){
        this.driver = new ChromeDriver();
    }

    // Open URL
    public void openURL(String URL){
        driver.get(URL);
        driver.manage().window().maximize();
    }

    // Close browser
    public int quitBrowser(){
        driver.quit();
        return 0;
    }

    // Click an element via xpath
    public void click(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }


    // Add delay
    public void delay(int time){

        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    // Input text to an element via xpath
    public void inputText(String xpath, String text){
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    // Clear input from an alement
    public void clearInput(String xpath){
        driver.findElement(By.xpath(xpath)).clear();
    }


    // Switch to an iframe after a certain action
    public void switchToIframe(String iframe){
        WebElement frame = driver.findElement(By.xpath(iframe));
        driver.switchTo().frame(frame);
    }

    // Check if an element is present or not
    public boolean verifyElementPresent(String xpath){
        try{
            driver.findElement(By.xpath(xpath)).isDisplayed();

            return true;
        }
        catch(NoSuchElementException e){

            return false;
        }
    }
}

