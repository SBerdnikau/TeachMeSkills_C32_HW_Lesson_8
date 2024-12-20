package com.teachmeskills.lesson_8.task1.transfer.impl;

import com.teachmeskills.lesson_8.task1.model.account.Account;
import com.teachmeskills.lesson_8.task1.model.card.BaseCard;
import com.teachmeskills.lesson_8.task1.model.document.Check;
import com.teachmeskills.lesson_8.task1.transfer.CardTransferService;
import com.teachmeskills.lesson_8.task1.utils.Constans;

import java.util.Date;

// TODO реализовать имплементацию интерфейса
public class MasterCardTransferService implements CardTransferService {

    @Override
    public Check transferFromCardToCard(BaseCard sendingCard, BaseCard receivingCard, int amountTransfer) {
        if (sendingCard.checkCardLimitTransfer(amountTransfer)) {
            sendingCard.setFromCardToCard(amountTransfer);
            receivingCard.setAddToCard(amountTransfer);
            return new Check(amountTransfer, new Date(), sendingCard);
        }else {
            sendingCard.setFromCardToCard(Constans.TRANSFER_LIMIT_MASTER_CARD);
            receivingCard.setAddToCard(Constans.TRANSFER_LIMIT_MASTER_CARD);
            System.out.println(Constans.WARNING_EXCEEDING_LIMIT + (amountTransfer - Constans.TRANSFER_LIMIT_MASTER_CARD));
            return new Check( Constans.TRANSFER_LIMIT_MASTER_CARD, new Date(), sendingCard);
        }
    }

    @Override
    public Check transferFromCardToAccount(BaseCard sendingCard, Account receivingAccount, int amountTransfer) {
        if (sendingCard.checkCardLimitTransfer(amountTransfer)) {
            sendingCard.setFromCardToCard(amountTransfer);
            receivingAccount.setAddToCard(amountTransfer);
            return new Check(amountTransfer, new Date(), sendingCard);
        }else {
            sendingCard.setFromCardToCard(Constans.TRANSFER_LIMIT_MASTER_CARD);
            receivingAccount.setAddToCard(Constans.TRANSFER_LIMIT_MASTER_CARD);
            System.out.println(Constans.WARNING_EXCEEDING_LIMIT + (amountTransfer - Constans.TRANSFER_LIMIT_MASTER_CARD));
            return new Check( Constans.TRANSFER_LIMIT_MASTER_CARD, new Date(), sendingCard);
        }
    }
}
