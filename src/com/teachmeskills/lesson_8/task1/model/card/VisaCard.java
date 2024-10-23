package com.teachmeskills.lesson_8.task1.model.card;

import com.teachmeskills.lesson_8.task1.utils.Constans;

import java.util.Date;

public class VisaCard  extends BaseCard{

    int cashback;

    public VisaCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, int cashback) {
        super(cardNumber, cvv, validDate, cardHolder, currency);
        this.cashback = cashback;
    }

    @Override
    public boolean checkCardLimitTransfer(int amountForTransfer) {
        // TODO реализовать проверку лимита. суть проверки в том, что сумма для перевода не превышает лимит
        if( amountForTransfer > Constans.TRANSFER_LIMIT_VISA_CARD){
            return false;
        }else {
            return true;
        }
    }

}
