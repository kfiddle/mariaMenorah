package com.example.demo;


import com.example.demo.models.Event;
import com.example.demo.models.Foundation;
import com.example.demo.models.Purpose;
import com.example.demo.models.Transaction;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.FoundationRepository;
import com.example.demo.repositories.PurposeRepository;
import com.example.demo.repositories.TransactionRepository;
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
    EventRepository eventRepo;




    @Override
    public void run(String... args) throws Exception {



        Purpose a1 = new Purpose("Exercise");
        Purpose a2 = new Purpose("Speaker Series");
        Purpose a3 = new Purpose("Distance Learning");
        Purpose a4 = new Purpose("Entertainment");
        Purpose a5 = new Purpose("Classical Music");
        Purpose a6 = new Purpose("Special Needs");
        Purpose a7 = new Purpose("Activities");
        Purpose a8 = new Purpose("Raised Bed Garden");
        Purpose a9 = new Purpose("Father's Day");
        Purpose a10 = new Purpose("Outings");
        Purpose b1 = new Purpose("Intergenerational Programs");
        Purpose b2 = new Purpose("Art Studio Supplies");
        Purpose b3 = new Purpose("Dreams");
        Purpose b4 = new Purpose("Jewish Holidays");
        Purpose b5 = new Purpose("Men's Club");
        Purpose b6 = new Purpose("New Year's Eve Party");
        Purpose b7 = new Purpose("Reform or Conservative visiting rabbis");
        Purpose b8 = new Purpose("Mother's Day");
        Purpose b9 = new Purpose("Educational Lectures");
        Purpose c1 = new Purpose("Mitzvah Corps");
        Purpose c2 = new Purpose("Athletic Activities");

        purposeRepo.save(a1);
        purposeRepo.save(a2);
        purposeRepo.save(a3);
        purposeRepo.save(a4);
        purposeRepo.save(a5);
        purposeRepo.save(a6);
        purposeRepo.save(a7);
        purposeRepo.save(a8);
        purposeRepo.save(a9);
        purposeRepo.save(a10);
        purposeRepo.save(b1);
        purposeRepo.save(b1);
        purposeRepo.save(b2);
        purposeRepo.save(b3);
        purposeRepo.save(b4);
        purposeRepo.save(b5);
        purposeRepo.save(b6);
        purposeRepo.save(b7);
        purposeRepo.save(b8);
        purposeRepo.save(b9);
        purposeRepo.save(c1);
        purposeRepo.save(c2);


        Foundation mAndm = new Foundation("Marilyn & Marshall Bedol youth Special Needs", 42500, a6);
        Foundation rayeMorris = new Foundation("Raye & Morris Blane Activities Fund", 29900, a7);
        Foundation albertBilstein = new Foundation("Albert Bilstein: Garden Fund for SG", 55800, a8);
        Foundation helenHerb = new Foundation("Helen & Herb Brown", 56900, a9);
        Foundation mollyCharles = new Foundation("Molly & Charles Goodman", 38700, a10);
        Foundation barbaraGross = new Foundation("Barbara Gross", 70400, a4);
        Foundation june = new Foundation("June Isquick", 29500, b1 );
        Foundation barbaraStanley = new Foundation("Barbara & Stanley Meisel Art Studio Fund", 83100, b2);
        Foundation hortense = new Foundation("Hortense Meyer Family Dreams Fund", 72700, b3 );
        Foundation munitz = new Foundation("A Munitz, L & L Rich Family Jewish Holiday", 55100, b4);
        Foundation rena = new Foundation("Rena 'Mimmi' Reich Fund", 64100, a4);
        Foundation larry = new Foundation("Larry Reiss Men's Club Fund", 48000, b5);
        Foundation zelda = new Foundation("Morris, Zelda, Esther Rice", 31600, b6);
        Foundation sayre = new Foundation("Sayre Family Activities Fund", 212400, a7);
        Foundation schnerb = new Foundation("Schnerb & Sokel Reform / Conservative", 59600, b7);
        Foundation senkfor = new Foundation("Senkfor Family", 21400, b1);
        Foundation sheryl = new Foundation("Sheryl & Bart Simon", 47300, b8);
        Foundation carol = new Foundation("Carol P. and Irwin N. Sokol Edu. Fund", 214100, b9);
        Foundation sylvia = new Foundation("Sylvia Swerdlow Memorial Fund", 39300, b9);
        Foundation laya = new Foundation("Laya & Leonard Tanenbaum Good Times Fund", 74400, a10);
        Foundation peggy = new Foundation("Peggy & Philip Wasserstrom Fund", 30700, a5);
        Foundation esther = new Foundation("Esther G. & Joseph S. Weil En. Fund", 34700, a4);
        Foundation weisz = new Foundation("Weisz Family Mitzvah Corps Fund", 29900, c1);
        Foundation estelle = new Foundation("Estelle & Allen Wolfe Fund", 14200, c2);


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

        Transaction t1 = new Transaction(450, weisz);
        Transaction t2 = new Transaction(1000, estelle);
        Transaction t3 = new Transaction(2300, peggy);

        Transaction t4 = new Transaction(348, carol);
        Transaction t5 = new Transaction(492, senkfor);

        transactionRepo.save(t1);
        transactionRepo.save(t2);
        transactionRepo.save(t3);
        transactionRepo.save(t4);
        transactionRepo.save(t5);



        Collection<Transaction> transax = new ArrayList<>();
        transax.add(t1);
        transax.add(t2);
        transax.add(t3);

        Collection<Transaction> transax1 = new ArrayList<>();
        transax1.add(t4);
        transax1.add(t5);



        Event a = new Event("one big party", LocalDate.now(), a4, 305300);
        Event b = new Event("another big party", LocalDate.of(2021, 9, 15), a4, 305300);
        Event c = new Event("a comedy", LocalDate.of(2021, 8, 5), a4, 5383);
        Event d = new Event("a lecture", LocalDate.of(2021, 9, 15), b9, 8353);
        Event e = new Event("pilates", LocalDate.of(2021, 7, 25), a1, 3053);
        Event f = new Event("bar hopping", LocalDate.of(2021, 9, 17), a9, 76820);
        Event g = new Event("garden hoe-ing", LocalDate.of(2021, 7, 27), a8, 76820, transax1);
        Event h = new Event("derek bass lecture", LocalDate.of(2021, 7, 19), b9, 9800);
        Event i = new Event("mother's day random", LocalDate.of(2021, 9, 27), b8, 7298);
        Event j = new Event("running a marathon", LocalDate.of(2021, 8, 2), a1, 5000);
        Event k = new Event("the trio", LocalDate.of(2021, 8, 14), a5, 20000);
        Event l = new Event("the duo", LocalDate.of(2021, 8, 4), a5, 16000, transax);


        eventRepo.save(a);
        eventRepo.save(b);
        eventRepo.save(c);
        eventRepo.save(d);
        eventRepo.save(e);
        eventRepo.save(f);
        eventRepo.save(g);
        eventRepo.save(h);
        eventRepo.save(i);
        eventRepo.save(j);
        eventRepo.save(k);
        eventRepo.save(l);


    }

}
