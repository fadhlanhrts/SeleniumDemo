package org.positivecase;
import org.main.Browser;
/*
Author: Muhammad Fadhlan Harits
Steps:
1. Navigate to https://demo.midtrans.com/
2. Click Buy Now
3. Input personal information
4. Click checkout
 */

public class ClickCheckout {
    Browser browser;
    boolean previousRunPassed = false;
    public ClickCheckout(boolean previousRunPassed, Browser browser){
        if(!previousRunPassed){
            this.browser = new Browser();
        } else {
            this.browser = browser;
        }
    }
    String className = this.getClass().getSimpleName();

    String btnBuyXpath = "//*[@class = \"btn buy\"]";

    String btnCheckoutXpath = "//*[@class = \"cart-checkout\"]";

    String nameXpath = "//*[@data-reactid = \".0.0.1.0.3.0.0.0.1.0\"]";

    String emailXpath = "//*[@data-reactid = \".0.0.1.0.3.0.0.1.1.0\"]";
    String phoneXpath = "//*[@data-reactid = \".0.0.1.0.3.0.0.2.1.0\"]";

    String cityXpath = "//*[@data-reactid = \".0.0.1.0.3.0.0.3.1.0\"]";

    String addressXpath = "//*[@data-reactid = \".0.0.1.0.3.0.0.4.1.0\"]";

    String postalCodeXpath = "//*[@data-reactid = \".0.0.1.0.3.0.0.5.1.0\"]";

    String iframe = "//*[@id = \"snap-midtrans\"]";

    String orderSummaryXpath = "//*[@class = \"order-summary-section\"]";


    public void run(){
        if(!previousRunPassed) {
            browser.openURL("https://demo.midtrans.com/");
            browser.delay(2);
            browser.click(btnBuyXpath);
            browser.delay(2);
        }

        browser.inputText(nameXpath, "Test Selenium");
        browser.inputText(emailXpath, "testselenium@email.com");
        browser.inputText(phoneXpath, "812345678");
        browser.inputText(cityXpath, "Jakarta");
        browser.inputText(addressXpath, "Jl. Sudirman");
        browser.inputText(postalCodeXpath, "123456");


        browser.click(btnCheckoutXpath);

        browser.delay(6);

        browser.switchToIframe(iframe);

        browser.delay(3);


        if(browser.verifyElementPresent(orderSummaryXpath)){
            System.out.println("Element found, test case " + className + " has passed");
            ClickCardPayment clickCard = new ClickCardPayment(true, browser);
            clickCard.run();
        } else {
            System.out.println("Element not found, test case " + className + " is not passed");
            browser.quitBrowser();
        }
        browser.quitBrowser();
    }


}
