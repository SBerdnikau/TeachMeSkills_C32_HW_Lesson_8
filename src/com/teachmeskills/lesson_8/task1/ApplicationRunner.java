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
        System.out.print("Enter the path to the file: ");
        Scanner scanner = new Scanner(System.in);
        String filePath =  scanner.nextLine();

        // TODO сделать метод createParser статичным и избавиться от необходимости создания объекта parserFabric
        // TODO заменить "" на имя файла, полученное со сканера
        IParser parser = ParserFabric.createParser(filePath);
        parser.parseFile(filePath);

        // TODO реализовать тестовый сценарий
        // создать двух клиентов
        // каждому клиенту создать два счета и две карты
        BaseClient client1 = new IndividualClient("BIO0-001-H001-G99",
                new Account[]{ new Account( "B00-B11-D11-444", 2000), new Account("A01-B02-876-234", 2500) },
                new BaseCard[]{ new MasterCard( "001-111-123-534", 111, new Date(), "SERGEY", "BYN", "BLR", 2500 ),
                new VisaCard( "002-345-222-221", 122, new Date(), "SERGEY", "USD", 1, 3000  )},
                "HB6500987645");

        BaseClient client2 = new LegalClient("LC11-222-111-324",
                new Account[]{ new Account( "111-222-546-999", 5000), new Account("222-234-543-655", 10000) },
                new BaseCard[]{ new MasterCard( "222-432-222-111", 222, new Date(), "KATE", "BYN", "BLR", 7500 ),
                        new VisaCard( "222-432-000-399", 876, new Date(), "KATE", "USD", 2, 12000  )},
                "L61-C12-G23-N22");

        BaseCard[] cardsClient1 =  client1.getCards();
        MasterCard masterCardClient1 = (MasterCard) cardsClient1[0];
        BaseCard[] cardsClient2 = client2.getCards();
        MasterCard masterCardClient2 = (MasterCard) cardsClient2[0];
        VisaCard visaCardClient2 = (VisaCard) cardsClient2[1];
        Account[] accountsClient1 = client2.getAccounts();
        Account accountClient1 =   accountsClient1[0];

        // перевести с карты одного клиента на карту другого сумму денег
        MasterCardTransferService masterCardTransfer1 = new MasterCardTransferService();
        masterCardClient1.showBaseInfo();
        Check check1 = masterCardTransfer1.transferFromCardToCard(masterCardClient1, masterCardClient2, 700);
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
