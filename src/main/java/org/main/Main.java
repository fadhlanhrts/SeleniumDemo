package org.main;

import org.negativecase.*;
import org.positivecase.*;

public class Main {
    public static void main(String[] args) {

        // Test Case for running positive cases
        LandingPage landingPageCase = new LandingPage();
        landingPageCase.run();

        //Test Case for running negative case - close profile after clicking buy now
        CloseProfilePage closeProfile = new CloseProfilePage();
        closeProfile.run();

        //Test Case for running negative case - empty profile
        EmptyProfile ep = new EmptyProfile();
        ep.run();

        // Test Case for negative case - close choose payment page
        CloseChoosePaymentPage closePayment = new CloseChoosePaymentPage();
        closePayment.run();

        // Test case for negative case - empty card details
        EmptyCardDetails emptyCard = new EmptyCardDetails();
        emptyCard.run();

        // Test case for negative case - cancel payment
        CancelPayment cancelPayment = new CancelPayment();
        cancelPayment.run();

        //Test case for negative case - invalid card detail
        InvalidCardDetails invalidCard = new InvalidCardDetails();
        invalidCard.run();

        // Test case for negative case - invalid otp
        InvalidOTP invalidOTP = new InvalidOTP();
        invalidOTP.run();

    }
}
