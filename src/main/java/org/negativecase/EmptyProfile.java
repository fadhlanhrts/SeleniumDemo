package org.negativecase;
import org.main.Browser;
public class EmptyProfile {

    Browser browser = new Browser();

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
        browser.openURL("https://demo.midtrans.com/");
        browser.delay(2);
        browser.click(btnBuyXpath);
        browser.delay(2);

        browser.clearInput(nameXpath);
        browser.clearInput(emailXpath);
        browser.clearInput(phoneXpath);
        browser.clearInput(cityXpath);
        browser.clearInput(addressXpath);
        browser.clearInput(postalCodeXpath);

        browser.delay(8);

        browser.click(btnCheckoutXpath);

        browser.delay(6);

        browser.switchToIframe(iframe);



        if(browser.verifyElementPresent(orderSummaryXpath)){
            System.out.println("Element found, test case " + className + " has passed");
        } else {
            System.out.println("Element not found, test case " + className + " is not passed");
        }
        browser.quitBrowser();
    }

}
