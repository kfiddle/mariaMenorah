package com.example.demo;


import com.example.demo.models.Foundation;
import com.example.demo.models.Purpose;
import com.example.demo.repositories.FoundationRepository;
import com.example.demo.repositories.PurposeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    FoundationRepository foundationRepo;

    @Resource
    PurposeRepository purposeRepo;


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
        Purpose b7 = new Purpose("Reform or Conversative visiting rabbis");
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
        

        Foundation mAndm = new Foundation("Marilyn & Marshall Bedol youth Special Needs", a6);
        Foundation rayeMorris = new Foundation("Raye & Morris Blane Activities Fund", a7);
        Foundation albertBilstein = new Foundation("Albert Bilstein: Garden Fund for SG", a8);
        Foundation helenHerb = new Foundation("Helen & Herb Brown", a9);
        Foundation mollyCharles = new Foundation("Molly & Charles Goodman", a10);
        Foundation barbaraGross = new Foundation("Barbara Gross", a4);
        Foundation june = new Foundation("June Isquick", b1 );
        Foundation barbaraStanley = new Foundation("Barbara & Stanley Meisel Art Studio Fund", b2);
        Foundation hortense = new Foundation("Hortense Meyer Family Dreams Fund", b3 );
        Foundation munitz = new Foundation("A Munitz, L & L Rich Family Jewish Holiday", b4);
        Foundation rena = new Foundation("Rena 'Mimmi' Reich Fund", a4);
        Foundation larry = new Foundation("Larry Reiss Men's Club Fund", b5);
        Foundation zelda = new Foundation("Morris, Zelda, Esther Rice", b6);
        Foundation sayre = new Foundation("Sayre Family Activities Fund", a7);
        Foundation schnerb = new Foundation("Schnerb & Sokel Reform / Conservative", b7);
        Foundation senkfor = new Foundation("Senkfor Family", b1);
        Foundation sheryl = new Foundation("Sheryl & Bart Simon", b8);
        Foundation carol = new Foundation("Carol P. and Irwin N. Sokol Edu. Fund", b9);
        Foundation sylvia = new Foundation("Sylvia Swerdlow Memorial Fund", b9);
        Foundation laya = new Foundation("Laya & Leonard Tanenbaum Good Times Fund", a10);
        Foundation peggy = new Foundation("Peggy & Philip Wasserstrom Fund", a5);
        Foundation esther = new Foundation("Esther G. & Joseph S. Weil En. Fund", a4);
        Foundation weisz = new Foundation("Weisz Family Mitzvah Corps Fund", c1);
        Foundation estelle = new Foundation("Estselle & Allen Wolfe Fund", c2);




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




    }

}
