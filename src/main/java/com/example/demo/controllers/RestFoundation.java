package com.example.demo.controllers;


import com.example.demo.models.Foundation;
import com.example.demo.models.Purpose;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.FoundationRepository;
import com.example.demo.repositories.PurposeRepository;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


@CrossOrigin
@RestController
public class RestFoundation {


    @Resource
    FoundationRepository foundationRepo;

    @Resource
    EventRepository eventRepo;

    @Resource
    PurposeRepository purposeRepo;

    @Resource
    TransactionRepository transactionRepo;

    @RequestMapping("/get-foundations")

    public Collection<Foundation> getAllFoundations() {
        return (Collection<Foundation>) foundationRepo.findAll();
    }

    @RequestMapping("/get-stringable-foundations")
    public Collection<String> getAllStringableFoundations() {
        Collection<String> stringsToSendBack = new ArrayList<>();

        for (Foundation foundation : foundationRepo.findAll()) {
            String stringToReturn =
                    foundation.getName() + "," + foundation.getLeftOverPennies() + "," + foundation.getContributionInPennies() + "," + foundation.getId();
            stringsToSendBack.add(stringToReturn);
        }
        return stringsToSendBack;
    }


    @PostMapping("/add-foundation")
    public Collection<Foundation> addFoundationToDatabase(@RequestBody Foundation incomingFoundation) throws IOException {


        Foundation foundationToAdd = new Foundation(incomingFoundation.getName());
        if (!foundationRepo.existsByName(incomingFoundation.getName())) {
            foundationRepo.save(foundationToAdd);
        }

        return (Collection<Foundation>) foundationRepo.findAll();
    }

    @PostMapping("/get-matching-foundations")
    public Collection<Foundation> getAllFoundationsOfCertainPurpose(@RequestBody Purpose purposeToMatch) throws IOException {
        return foundationRepo.findByPurpose(purposeToMatch);
    }

    @PostMapping("/get-matching-stringable-foundations")
    public Collection<String> getAllStringableFoundationsOfCertainPurpose(@RequestBody Purpose purposeToMatch) throws IOException {

        Collection<Foundation> matchingFoundations = foundationRepo.findByPurpose(purposeToMatch);

        Collection<String> stringsToReturn = new ArrayList<>();

        for (Foundation foundation : matchingFoundations) {
            String stringToPush = foundation.getName() + "," + foundation.getLeftOverPennies();
            stringsToReturn.add(stringToPush);
        }
        return stringsToReturn;
    }


}
