package org.positivecase;
import org.main.Browser;
public class ConfirmPayment {

    Browser browser;

    boolean previousRunPassed = false;
    public ConfirmPayment(boolean previousRunPassed, Browser browser){
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

    String debitCardXpath = "//*[@class = \"list-title text-actionable-bold\" and contains(text(),'Credit/debit card')]";

    String cardNumberXpath = "//*[@autocomplete = \"cc-number\"]";

    String expiryXpath = "//*[@id = \"card-expiry\"]";

    String cvvXpath = "//*[@id = \"card-cvv\"]";

    String btnPayNow = "//*[@class = \"btn full primary  btn-theme\"]";

    String iframe3DS = "//*[@class = \"iframe-3ds\"]";

    String otpXpath = "//*[@id = \"otp\"]";

    String okButton = "//*[@name = \"ok\"]";

    String paymentSuccess = "//*[@data-reactid = '.0.0.0.2.0.1.0.0:0']";
    public void run(){
        if(!previousRunPassed) {
            browser.openURL("https://demo.midtrans.com/");
            browser.delay(2);
            browser.click(btnBuyXpath);
            browser.delay(2);
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
            browser.click(debitCardXpath);
            browser.delay(4);
            browser.inputText(cardNumberXpath, "4811111111111114");
            browser.delay(5);
            browser.inputText(expiryXpath, "1128");
            browser.inputText(cvvXpath, "123");
            browser.click(btnPayNow);
            browser.delay(20);
            browser.switchToIframe(iframe3DS);
        }

        browser.inputText(otpXpath, "112233");

        browser.click(okButton);

        browser.delay(18);



        if(browser.verifyElementPresent(paymentSuccess)){
            System.out.println("Element found, test case " + className + " has passed");
        } else {
            System.out.println("Element not found, test case " + className + " is not passed");
        }
        browser.quitBrowser();
    }
}
