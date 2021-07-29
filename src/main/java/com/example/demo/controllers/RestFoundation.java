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

    @PostMapping("/get-foundation-from-id")
    public Foundation getFoundationFromId(@RequestBody Long incomingId) throws IOException {
        if (foundationRepo.existsById(incomingId)) {
            return foundationRepo.findById(incomingId).get();
        } else {
            return null;
        }
    }
}
