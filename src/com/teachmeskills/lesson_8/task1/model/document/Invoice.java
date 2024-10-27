package com.teachmeskills.lesson_8.task1.model.document;

import com.teachmeskills.lesson_8.task1.model.account.Account;
import com.teachmeskills.lesson_8.task1.model.client.BaseClient;

import java.util.Date;

// TODO добавить поля на свое усмотрение
public class Invoice {
    private Account[] accountNumber;
    private BaseClient[] clients;
    private Date currentDate;

    public Invoice(Account[] accountNumber, BaseClient[] clients, Date currentDate) {
        this.accountNumber = accountNumber;
        this.clients = clients;
        this.currentDate = currentDate;
    }

    public Account[] getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Account[] accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BaseClient[] getClients() {
        return clients;
    }

    public void setClients(BaseClient[] clients) {
        this.clients = clients;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
