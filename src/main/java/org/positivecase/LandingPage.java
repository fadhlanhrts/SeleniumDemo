package org.positivecase;
import org.main.Browser;
/*
Author: Muhammad Fadhlan Harits
Steps:
1. Navigate to https://demo.midtrans.com/
 */
public class LandingPage {

    // Initiate browser
    Browser browser = new Browser();

    // Class name for logs, checking whether the test passed or not
    String className = this.getClass().getSimpleName();

    // Locator for button buy
    String btnBuyXpath = "//*[@class = \"btn buy\"]";

    // Method for running the test case
    public void run() {
        browser.openURL("https://demo.midtrans.com/");

        if (browser.verifyElementPresent(btnBuyXpath)) {
            System.out.println("Element found, test case " + className + " has passed");
            ClickBuyNow clickBuy = new ClickBuyNow(true, browser);
            clickBuy.run();
        } else {
            System.out.println("Element not found, test case " + className + " is not passed");
            browser.quitBrowser();
        }
        browser.quitBrowser();
    }

}
