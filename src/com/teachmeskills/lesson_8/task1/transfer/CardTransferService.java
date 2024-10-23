package com.teachmeskills.lesson_8.task1.transfer;

import com.teachmeskills.lesson_8.task1.model.account.Account;
import com.teachmeskills.lesson_8.task1.model.card.BaseCard;
import com.teachmeskills.lesson_8.task1.model.document.Check;

public interface CardTransferService {

    // TODO сделать возвращаемое значение Check (класс лежит в пакете document)
    // TODO добавить входные параметры в метод: карта с..., карта на..., сумма трансфера
    Check transferFromCardToCard(BaseCard sendingCard, BaseCard receivingCard, int amountTransfer);

    // TODO сделать возвращаемое значение Check (класс лежит в пакете document)
    // TODO добавить входные параметры в метод: карта с.., счет на..., сумма трансфера
    Check transferFromCardToAccount(BaseCard sendingCard, Account receivingAccount, int amountTransfer);

}
