package com.teachmeskills.lesson_8.task1.model.document;

import com.teachmeskills.lesson_8.task1.model.account.Account;
import com.teachmeskills.lesson_8.task1.model.client.BaseClient;

import java.util.Date;

// TODO добавить поля на свое усмотрение
public class Invoice {
    Account[] accountNumber;
    BaseClient[] clients;
    Date currentDate;
}
