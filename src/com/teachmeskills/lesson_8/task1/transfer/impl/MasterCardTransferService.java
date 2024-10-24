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
            sendingCard.amount -= amountTransfer;
            receivingCard.amount += amountTransfer;
            return new Check(amountTransfer, new Date(), sendingCard);
        }else {
            System.out.println("ATTENTION! Transfer limit exceeded " + (amountTransfer - Constans.TRANSFER_LIMIT_MASTER_CARD));
            return new Check( Constans.TRANSFER_LIMIT_MASTER_CARD, new Date(), sendingCard);
        }
    }

    @Override
    public Check transferFromCardToAccount(BaseCard sendingCard, Account receivingAccount, int amountTransfer) {
        if (sendingCard.checkCardLimitTransfer(amountTransfer)) {
            sendingCard.amount -= amountTransfer;
            receivingAccount.amount += amountTransfer;
            return new Check(amountTransfer, new Date(), sendingCard);
        }else {
            System.out.println("ATTENTION! Transfer limit exceeded " + (amountTransfer - Constans.TRANSFER_LIMIT_MASTER_CARD));
            return new Check( Constans.TRANSFER_LIMIT_MASTER_CARD, new Date(), sendingCard);
        }
    }
}
