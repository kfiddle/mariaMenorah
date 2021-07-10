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




    }

}
