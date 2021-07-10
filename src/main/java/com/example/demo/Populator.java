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

        Foundation mAndm = new Foundation("Marilyn & Marshall Bedol youth Special Needs");
        Foundation rayeMorris = new Foundation("Raye & Morris Blane Activities Fund");
        Foundation albertBilstein = new Foundation("Albert Bilstein: Garden Fund for SG");
        Foundation helenHerb = new Foundation("Helen & Herb Brown");
        Foundation mollyCharles = new Foundation("Molly & Charles Goodman");
        Foundation barbaraGross = new Foundation("Barbara Gross");
        Foundation june = new Foundation("June Isquick");
        Foundation barbaraStanley = new Foundation("Barbara & Stanley Meisel Art Studio Fund");
        Foundation hortense = new Foundation("Hortense Meyer Family Dreams Fund");
        Foundation munitz = new Foundation("A Munitz, L & L Rich Family Jewish Holiday");

        foundationRepo.save(mAndm);
        foundationRepo.save(rayeMorris);
        foundationRepo.save(albertBilstein);
        foundationRepo.save(helenHerb);
        foundationRepo.save(mollyCharles);
        foundationRepo.save(barbaraGross);
        foundationRepo.save(barbaraStanley);
        foundationRepo.save(hortense);
        foundationRepo.save(munitz);

        Purpose a1 = new Purpose("Exercise");
        Purpose a2 = new Purpose("Speaker Series");
        Purpose a3 = new Purpose("Distance Learning");
        Purpose a4 = new Purpose("Entertainment");
        Purpose a5 = new Purpose("Classical Music");

        purposeRepo.save(a1);
        purposeRepo.save(a2);
        purposeRepo.save(a3);
        purposeRepo.save(a4);
        purposeRepo.save(a5);


    }

}
