package com.teachmeskills.lesson_8.task1.model.card;

import com.teachmeskills.lesson_8.task1.utils.Constans;

import java.util.Date;

public class MasterCard extends BaseCard{

    public String country;

    public MasterCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, String country, double amount) {
        super(cardNumber, cvv, validDate, cardHolder, currency, amount);
        this.country = country;
    }

    @Override
    public boolean checkCardLimitTransfer(int amountForTransfer) {
        // TODO реализовать проверку лимита. суть проверки в том, что сумма для перевода не превышает лимит
        return   amountForTransfer > Constans.TRANSFER_LIMIT_MASTER_CARD ? false : true;
    }

    @Override
    public void showBaseInfo() {
        System.out.println("MASTERCARD-INFO");
        System.out.println(cardNumber + " -> " + amount + " -> "  + validDate + "\n");
    }
}
