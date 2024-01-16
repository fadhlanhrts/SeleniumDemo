package org.positivecase;
import org.main.Browser;
/*
Author: Muhammad Fadhlan Harits
Steps:
1. Navigate to https://demo.midtrans.com/
2. Click Buy Now
 */
public class ClickBuyNow {

    Browser browser;
    boolean previousRunPassed = false;
    public ClickBuyNow(boolean previousRunPassed, Browser browser){
        if(!previousRunPassed){
            this.browser = new Browser();
        } else {
            this.browser = browser;
        }
    }

    String className = this.getClass().getSimpleName();

    String btnBuyXpath = "//*[@class = \"btn buy\"]";

    String btnCheckoutXpath = "//*[@class = \"cart-checkout\"]";
    public void run(){
        if(!previousRunPassed){
            browser.openURL("https://demo.midtrans.com/");
            browser.delay(3);
        }

        browser.click(btnBuyXpath);
        browser.delay(3);

        if(browser.verifyElementPresent(btnCheckoutXpath)){
            System.out.println("Element found, test case " + className + " has passed");
            ClickCheckout clickCheckout = new ClickCheckout(true, browser);
            clickCheckout.run();
        } else {
            System.out.println("Element not found, test case " + className + " is not passed");
            browser.quitBrowser();
        }

        browser.quitBrowser();
    }

}
