package com.teachmeskills.lesson_8.task1.model.document;

import com.teachmeskills.lesson_8.task1.model.card.BaseCard;

import java.util.Date;

// TODO добавить поля: сумма перевода, дата перевода, номер счета или номер карты
// TODO создать метод для вывода информации о чеке на экран
public class Check {
    private int transferAmount;
    private Date transferDate;
    private BaseCard card;

    public Check(int transferAmount, Date transferDate, BaseCard card) {
        this.transferAmount = transferAmount;
        this.transferDate = transferDate;
        this.card = card;
    }

    public void showCheckInfo(){
        System.out.println("--CHECK FOR TRANSFER--");
        System.out.println("Transfer from card: " + card.cardNumber + "\nDate: " + transferDate + "\nAmount: " + transferAmount + "\n");
    }

}
