package org.negativecase;

import org.main.Browser;

public class CloseProfilePage {
    Browser browser = new Browser();
    String className = this.getClass().getSimpleName();

    String btnBuyXpath = "//*[@class = \"btn buy\"]";

    String closeBtn = "//*[@class = 'cancel-btn']";

    public void run(){
        browser.openURL("https://demo.midtrans.com/");
        browser.delay(2);
        browser.click(btnBuyXpath);
        browser.delay(2);

        browser.click(closeBtn);



        if(browser.verifyElementPresent(btnBuyXpath)){
            System.out.println("Element found, test case " + className + " has passed");
        } else {
            System.out.println("Element not found, test case " + className + " is not passed");
        }
        browser.quitBrowser();
    }
}
