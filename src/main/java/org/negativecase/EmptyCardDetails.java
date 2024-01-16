package org.negativecase;

import org.main.Browser;

public class EmptyCardDetails {
    Browser browser = new Browser();
    String className = this.getClass().getSimpleName();

    String btnBuyXpath = "//*[@class = \"btn buy\"]";

    String btnCheckoutXpath = "//*[@class = \"cart-checkout\"]";

    String iframe = "//*[@id = \"snap-midtrans\"]";

    String debitCardXpath = "//*[@class = \"list-title text-actionable-bold\" and contains(text(),'Credit/debit card')]";


    String btnPayNow = "//*[@class = \"btn full disabled inactive btn-theme\"]";

    String warningXpath = "//*[@class = 'card-warning text-failed']";

    public void run(){
        browser.openURL("https://demo.midtrans.com/");
        browser.delay(2);
        browser.click(btnBuyXpath);
        browser.delay(2);

        browser.click(btnCheckoutXpath);

        browser.delay(6);

        browser.delay(6);

        browser.switchToIframe(iframe);

        browser.delay(3);

        browser.click(debitCardXpath);


        browser.click(btnPayNow);

        browser.delay(7);



        if(browser.verifyElementPresent(warningXpath)){
            System.out.println("Element found, test case " + className + " has passed");
        } else {
            System.out.println("Element not found, test case " + className + " is not passed");
        }
        browser.quitBrowser();
    }
}
