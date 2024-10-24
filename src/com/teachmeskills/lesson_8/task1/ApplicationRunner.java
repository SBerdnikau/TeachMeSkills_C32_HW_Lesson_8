package com.teachmeskills.lesson_8.task1;

import com.teachmeskills.lesson_8.task1.document_parser.IParser;
import com.teachmeskills.lesson_8.task1.fabric.ParserFabric;
import com.teachmeskills.lesson_8.task1.model.account.Account;
import com.teachmeskills.lesson_8.task1.model.card.BaseCard;
import com.teachmeskills.lesson_8.task1.model.card.MasterCard;
import com.teachmeskills.lesson_8.task1.model.card.VisaCard;
import com.teachmeskills.lesson_8.task1.model.client.BaseClient;
import com.teachmeskills.lesson_8.task1.model.client.IndividualClient;
import com.teachmeskills.lesson_8.task1.model.client.LegalClient;
import com.teachmeskills.lesson_8.task1.model.document.Check;
import com.teachmeskills.lesson_8.task1.transfer.impl.MasterCardTransferService;
import com.teachmeskills.lesson_8.task1.transfer.impl.VisaCardTransferService;

import java.util.Date;
import java.util.Scanner;

public class ApplicationRunner {
    public static void main(String[] args) {
        // TODO запросить с консоли путь и имя файла
        System.out.print("Введите путь к файлу: ");
        Scanner scanner = new Scanner(System.in);
        String filePath =  scanner.nextLine();

        // TODO сделать метод createParser статичным и избавиться от необходимости создания объекта parserFabric
        // TODO заменить "" на имя файла, полученное со сканера
        IParser parser = ParserFabric.createParser(filePath);
        parser.parseFile(filePath);

        // TODO реализовать тестовый сценарий
        // создать двух клиентов
        // каждому клиенту создать два счета и две карты
        BaseClient client1  = new IndividualClient( "Client_001",
                new Account[]{  new Account("000011", 2000), new Account("000012", 100)},
                new BaseCard[]{ new MasterCard("CH00001", 111, new Date(), "Client_001", "USD", "BLR", 1200),
                new VisaCard("CH00002", 112, new Date(), "Client_002", "USD", 2, 300)}
        );
        BaseClient client2  = new LegalClient( "Client_002",
                new Account[]{  new Account("000021", 5000), new Account("000022", 1000)},
                new BaseCard[]{ new MasterCard("CH00002", 221, new Date(), "Client_002", "USD", "BLR", 800),
                new VisaCard("CH00002", 222, new Date(), "Client_002", "USD", 1, 700)}
        );

        BaseCard[] cardsClient1 =  client1.getCards();
        MasterCard masterCardClient1 = (MasterCard) cardsClient1[0];
        BaseCard[] cardsClient2 = client2.getCards();
        MasterCard masterCardClient2 = (MasterCard) cardsClient2[0];
        VisaCard visaCardClient2 = (VisaCard) cardsClient2[1];
        Account[] accountsClient1 = client2.getAccounts();
        Account accountClient1 =   accountsClient1[1];

        // перевести с карты одного клиента на карту другого сумму денег
        MasterCardTransferService masterCardTransfer1 = new MasterCardTransferService();
        masterCardClient1.showBaseInfo();
        Check check1 = masterCardTransfer1.transferFromCardToCard(masterCardClient1, masterCardClient2, 200);
        check1.showCheckInfo();
        masterCardClient1.showBaseInfo();

        // перевести с карты одного клиента на счет, другого клиента сумму денег
        VisaCardTransferService visaCardTransferS1 = new VisaCardTransferService();
        visaCardClient2.showBaseInfo();
        Check check2 = visaCardTransferS1.transferFromCardToAccount(visaCardClient2, accountClient1, 100);
        check2.showCheckInfo();
        visaCardClient2.showBaseInfo();
    }
}
