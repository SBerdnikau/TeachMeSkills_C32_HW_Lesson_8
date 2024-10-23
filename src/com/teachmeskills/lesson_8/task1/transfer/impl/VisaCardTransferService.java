package com.teachmeskills.lesson_8.task1.transfer.impl;

import com.teachmeskills.lesson_8.task1.model.account.Account;
import com.teachmeskills.lesson_8.task1.model.card.BaseCard;
import com.teachmeskills.lesson_8.task1.model.document.Check;
import com.teachmeskills.lesson_8.task1.transfer.CardTransferService;

import java.util.Date;

// TODO реализовать имплементацию интерфейса
public class VisaCardTransferService implements CardTransferService {

    @Override
    public Check transferFromCardToCard(BaseCard sendingCard, BaseCard receivingCard, int amountTransfer) {
        //реализовать логику перевода
        return new Check(amountTransfer, new Date(), sendingCard);
    }

    @Override
    public Check transferFromCardToAccount(BaseCard sendingCard, Account receivingAccount, int amountTransfer) {
        //реализовать логику перевода
        return new Check(amountTransfer, new Date(), sendingCard);
    }
}
