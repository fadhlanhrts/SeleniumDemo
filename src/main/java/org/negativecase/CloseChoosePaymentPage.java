package org.negativecase;

import org.main.Browser;

public class CloseChoosePaymentPage {
    Browser browser = new Browser();
    String className = this.getClass().getSimpleName();

    String btnBuyXpath = "//*[@class = \"btn buy\"]";

    String btnCheckoutXpath = "//*[@class = \"cart-checkout\"]";

    String iframe = "//*[@id = \"snap-midtrans\"]";

    String closeBtn = "//*[@class = 'close-snap-button clickable']";

    public void run(){
        browser.openURL("https://demo.midtrans.com/");
        browser.delay(2);
        browser.click(btnBuyXpath);
        browser.delay(2);

        browser.click(btnCheckoutXpath);

        browser.delay(6);

        browser.switchToIframe(iframe);

        browser.delay(3);

        browser.click(closeBtn);



        if(browser.verifyElementPresent(btnBuyXpath)){
            System.out.println("Element found, test case " + className + " has passed");
        } else {
            System.out.println("Element not found, test case " + className + " is not passed");
        }
        browser.quitBrowser();
    }

}
