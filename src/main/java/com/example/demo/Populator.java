package com.example.demo;


import com.example.demo.models.*;
import com.example.demo.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    PurposeRepository purposeRepo;

    @Resource
    FoundationRepository foundationRepo;

    @Resource
    TransactionRepository transactionRepo;

    @Resource
    FoundationItemRepository foundationItemRepo;

    @Resource
    MasterBudgetItemRepository masterBudgetItemRepo;

    @Resource
    PayeeRepository payeeRepo;

    @Resource
    ReceiptRepository receiptRepo;


    @Resource
    BudgetItemRepository budgetItemRepo;


    @Override
    public void run(String... args) throws Exception {


        Purpose exercise = new Purpose("Exercise");
        Purpose speakerSeries = new Purpose("Speaker Series");
        Purpose distanceLearning = new Purpose("Distance Learning");
        Purpose entertainment = new Purpose("Entertainment");
        Purpose classical = new Purpose("Classical Music");
        Purpose specialNeeds = new Purpose("Special Needs");
        Purpose activities = new Purpose("Activities");
        Purpose garden = new Purpose("Raised Bed Garden");
        Purpose fathersDay = new Purpose("Father's Day");
        Purpose outings = new Purpose("Outings");
        Purpose interGen = new Purpose("Intergenerational Programs");
        Purpose artStudio = new Purpose("Art Studio Supplies");
        Purpose dreams = new Purpose("Dreams");
        Purpose holidays = new Purpose("Jewish Holidays");
        Purpose mensClub = new Purpose("Men's Club");
        Purpose newYears = new Purpose("New Year's Eve Party");
        Purpose rabbis = new Purpose("Reform or Conservative visiting rabbis");
        Purpose mothersDay = new Purpose("Mother's Day");
        Purpose eduLectures = new Purpose("Educational Lectures");
        Purpose mitzvah = new Purpose("Mitzvah Corps");
        Purpose athletic = new Purpose("Athletic Activities");
        Purpose taiChi = new Purpose("Tai Chi/Pilates/Gigong");

        purposeRepo.save(exercise);
        purposeRepo.save(speakerSeries);
        purposeRepo.save(distanceLearning);
        purposeRepo.save(entertainment);
        purposeRepo.save(classical);
        purposeRepo.save(specialNeeds);
        purposeRepo.save(activities);
        purposeRepo.save(garden);
        purposeRepo.save(fathersDay);
        purposeRepo.save(outings);
        purposeRepo.save(interGen);
        purposeRepo.save(artStudio);
        purposeRepo.save(dreams);
        purposeRepo.save(holidays);
        purposeRepo.save(mensClub);
        purposeRepo.save(newYears);
        purposeRepo.save(rabbis);
        purposeRepo.save(mothersDay);
        purposeRepo.save(eduLectures);
        purposeRepo.save(mitzvah);
        purposeRepo.save(athletic);
        purposeRepo.save(taiChi);


        Foundation mAndm = new Foundation("Marilyn & Marshall Bedol youth Special Needs", 42521, specialNeeds);
        Foundation rayeMorris = new Foundation("Raye & Morris Blane Activities Fund", 29937, activities);
        Foundation albertBilstein = new Foundation("Albert Bilstein: Garden Fund for SG", 55778, garden);
        Foundation helenHerb = new Foundation("Helen & Herb Brown", 56892, fathersDay);
        Foundation mollyCharles = new Foundation("Mollie & Charles Goodman", 38706, outings );
        Foundation barbaraGross = new Foundation("Barbara Gross", 70350, entertainment);
        Foundation june = new Foundation("June Isquick", 29484, interGen);
        Foundation barbaraStanley = new Foundation("Barbara & Stanley Meisel Art Studio Fund", 83119, artStudio);
        Foundation hortense = new Foundation("Hortense Meyer Family Dreams Fund", 72699, dreams);
        Foundation munitz = new Foundation("A Munitz- L & L Rich Family Jewish Holiday", 55073, holidays);
        Foundation rena = new Foundation("Rena 'Mimmi' Reich Fund", 64133, entertainment);
        Foundation larry = new Foundation("Larry Reiss Men's Club Fund", 47976, mensClub);
        Foundation zelda = new Foundation("Morris- Zelda- Esther Rice", 31594, newYears);
        Foundation sayre = new Foundation("Sayre Family Activities Fund", 212448, activities);
        Foundation schnerb = new Foundation("Schnerb & Sokel Reform / Conservative", 59591, rabbis);
        Foundation senkfor = new Foundation("Senkfor Family", 21442, interGen);
        Foundation sheryl = new Foundation("Sheryl & Bart Simon", 47323, mothersDay);
        Foundation carol = new Foundation("Carol P. and Irwin N. Sokol Edu. Fund", 214062, eduLectures);
        Foundation sylvia = new Foundation("Sylvia Swerdlow Memorial Fund", 39301, eduLectures);
        Foundation laya = new Foundation("Laya & Leonard Tanenbaum Good Times Fund", 74422, outings);
        Foundation peggy = new Foundation("Peggy & Philip Wasserstrom Fund", 30659, classical);
        Foundation esther = new Foundation("Esther G. & Joseph S. Weil En. Fund", 34672, entertainment);
        Foundation weisz = new Foundation("Weisz Family Mitzvah Corps Fund", 29866, mitzvah);
        Foundation estelle = new Foundation("Estelle & Allen Wolfe Fund", 14155, athletic);
        Foundation peter = new Foundation("Peter Meisel", 250000, outings);
        Foundation david = new Foundation("David and Helen Nagusky", 130000, taiChi);


        foundationRepo.save(mAndm);
        foundationRepo.save(rayeMorris);
        foundationRepo.save(albertBilstein);
        foundationRepo.save(helenHerb);
        foundationRepo.save(mollyCharles);
        foundationRepo.save(barbaraGross);
        foundationRepo.save(barbaraStanley);
        foundationRepo.save(hortense);
        foundationRepo.save(munitz);
        foundationRepo.save(june);
        foundationRepo.save(rena);
        foundationRepo.save(larry);
        foundationRepo.save(zelda);
        foundationRepo.save(sayre);
        foundationRepo.save(schnerb);
        foundationRepo.save(senkfor);
        foundationRepo.save(sheryl);
        foundationRepo.save(carol);
        foundationRepo.save(sylvia);
        foundationRepo.save(laya);
        foundationRepo.save(peggy);
        foundationRepo.save(esther);
        foundationRepo.save(weisz);
        foundationRepo.save(estelle);
        foundationRepo.save(peter);
        foundationRepo.save(david);


        Payee estherNahm = new Payee("Esther", "Nahm");
        Payee derekS = new Payee("Derek", "Snyder");
        Payee derekZ = new Payee("Derek", "Zadinsky");
        Payee kenjo = new Payee("Ken", "Johnston");
//        Payee mariaV = new Payee("Maria", "Vinas");
        Payee kentC = new Payee("Kent", "Collier");
        Payee yj = new Payee("YeeJee", "Kim");
//        Payee steve = new Payee("Steve", "Greenman");



        payeeRepo.save(estherNahm);
        payeeRepo.save(derekS);
        payeeRepo.save(derekZ);
        payeeRepo.save(kenjo);
//        payeeRepo.save(mariaV);
        payeeRepo.save(kentC);
        payeeRepo.save(yj);
//        payeeRepo.save(steve);

//        Collection<Payee> testPayees = new ArrayList<>();
//
//        testPayees.add(derekZ);
//        testPayees.add(derekS);
//
//        Collection<Payee> payees1 = new ArrayList<>();
//
//        payees1.add(kenjo);
//        payees1.add(kentC);
//        payees1.add(yj);
//
//
//        Transaction first = new Transaction(7500, albertBilstein);
//        Transaction second = new Transaction(260, estelle);
//
//        Transaction third = new Transaction(7200, esther);
//        Transaction fourth = new Transaction(9300, carol);
//
//        Transaction fifth = new Transaction(2783, sheryl);
//        Transaction sixth = new Transaction(9244, senkfor);
//
//        Transaction seventh = new Transaction(20000, mollyCharles);
//
//        transactionRepo.save(first);
//        transactionRepo.save(second);
//        transactionRepo.save(third);
//        transactionRepo.save(fourth);
//        transactionRepo.save(fifth);
//        transactionRepo.save(sixth);
//        transactionRepo.save(seventh);
//
//        FoundationItem firstEvent = new FoundationItem("Maria and Ginger", LocalDate.now(), 1500, entertainment);
//        foundationItemRepo.save(firstEvent);
//
//        FoundationItem secondEvent = new FoundationItem("Derek and Ginger", LocalDate.now(), 2500, testPayees, classical);
//        foundationItemRepo.save(secondEvent);
//
//        FoundationItem thirdEvent = new FoundationItem("Ginger Show", LocalDate.of(2021, 10, 21),7500, payees1 , taiChi);
//        foundationItemRepo.save(thirdEvent);
//
//        FoundationItem fourthEvent = new FoundationItem("Maria Comedy Night", LocalDate.of(2021, 9, 15), 10000, payees1, newYears);
//        foundationItemRepo.save(fourthEvent);
//
//        FoundationItem fifthEvent = new FoundationItem("Yoga Night", LocalDate.of(2021, 11, 17), 5000, payees1, taiChi);
//        foundationItemRepo.save(fifthEvent);
//
//        FoundationItem sixthEvent = new FoundationItem("Derek Z Recital", LocalDate.of(2021, 9, 9), 15000, testPayees, entertainment);
//        foundationItemRepo.save(sixthEvent);
//
//        FoundationItem seventhEvent = new FoundationItem("Jack's Lunch", LocalDate.of(2021, 8, 9), 20000, outings);
//        foundationItemRepo.save(seventhEvent);
//
//        FoundationItem eighthEvent = new FoundationItem("GoodTime Cruise", LocalDate.of(2021, 10, 19), 60000, outings);
//        foundationItemRepo.save(eighthEvent);
//
//        FoundationItem ninthEvent = new FoundationItem("GoodTime Food", LocalDate.of(2021, 10, 19), 20000, outings);
//        foundationItemRepo.save(ninthEvent);
//
//
//
//        Receipt receipt1 = new Receipt(first.getId(), firstEvent);
//        Receipt receipt2 = new Receipt(second.getId(), firstEvent);
//        Receipt receipt3 = new Receipt(third.getId(), firstEvent);
//        Receipt receipt4 = new Receipt(fourth.getId(), secondEvent);
//        Receipt receipt5 = new Receipt(fifth.getId(), secondEvent);
//        Receipt receipt6 = new Receipt(sixth.getId(), secondEvent);
//        Receipt receipt7 = new Receipt(seventh.getId(), ninthEvent);
//
//        receiptRepo.save(receipt1);
//        receiptRepo.save(receipt2);
//        receiptRepo.save(receipt3);
//        receiptRepo.save(receipt4);
//        receiptRepo.save(receipt5);
//        receiptRepo.save(receipt6);
//        receiptRepo.save(receipt7);
//
//        Collection<Receipt> receiptsForFirst = new ArrayList<>();
//        Collection<Receipt> receiptsForSecond = new ArrayList<>();
//
//        receiptsForFirst.add(receipt1);
//        receiptsForFirst.add(receipt2);
//
//        receiptsForSecond.add(receipt3);
//        receiptsForSecond.add(receipt4);
//
//
//
//        firstEvent.setReceipts(receiptsForFirst);
//        secondEvent.setReceipts(receiptsForSecond);
//
//
//
//
//
//        Collection<Transaction> trx = new ArrayList<>();
//
//        trx.add(first);
//        trx.add(second);
//
//        Collection<Transaction> trx1 = new ArrayList<>();
//
//        trx1.add(third);
//        trx1.add(fourth);
//
//        Collection<Transaction> trx2 = new ArrayList<>();
//
//        trx2.add(fifth);
//        trx2.add(sixth);
//
//
//
//        testPayees.add(derekZ);
//
//
//
//        Transaction newTrans1 = new Transaction(5000);
//        Transaction newTrans2 = new Transaction(7500);
//
//        newTrans1.setFoundation(peggy);
//        newTrans2.setFoundation(albertBilstein);
//
//        transactionRepo.save(newTrans1);
//        transactionRepo.save(newTrans2);
//
//        Collection<Transaction> transactionsForDAndGinger = new ArrayList<>();
//        transactionsForDAndGinger.add(newTrans1);
//        transactionsForDAndGinger.add(newTrans2);
//
//
//        secondEvent.setTransactions(transactionsForDAndGinger);
//        foundationItemRepo.save(secondEvent);
//
//        MasterBudgetItem testItem = new MasterBudgetItem("Triple A Batteries", LocalDate.of(2021, 10, 10), 5000, "Stone Gardens", "some notes", "3728");
//        MasterBudgetItem testItem2 = new MasterBudgetItem("Zadinsky Method", LocalDate.of(2021, 10, 10), 5000, testPayees, "Stone Gardens", "some notes", "3728");
//
//
//        masterBudgetItemRepo.save(testItem);
//        masterBudgetItemRepo.save(testItem2);
//
//        FoundationItem workingVersion = new FoundationItem();
//
//        workingVersion.setName("shuffle board night");
//
//        workingVersion.setDate(LocalDate.now());
//
//        workingVersion.setTotalCostInCents(7500);
//
//        workingVersion.setPurpose(mensClub);
//
//        workingVersion.setTransactions(trx1);
//
//        workingVersion.setPayees(payees1);
//
//        workingVersion.setNotes("I take excellent notes");
//
//        foundationItemRepo.save(workingVersion);


    }
}
