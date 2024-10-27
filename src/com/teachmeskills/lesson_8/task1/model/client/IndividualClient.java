package com.teachmeskills.lesson_8.task1.model.client;

import com.teachmeskills.lesson_8.task1.model.account.Account;
import com.teachmeskills.lesson_8.task1.model.card.BaseCard;

public class IndividualClient  extends BaseClient{
    private String passportNumber;

    public IndividualClient(String name, Account[] accounts, BaseCard[] cards, String passportNumber) {
        super(name, accounts, cards);
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}