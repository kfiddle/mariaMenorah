package com.example.demo.controllers;


import com.example.demo.models.*;
import com.example.demo.repositories.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@CrossOrigin
@RestController
public class RestFoundation {


    @Resource
    FoundationRepository foundationRepo;

    @Resource
    FoundationItemRepository foundationItemRepo;

    @Resource
    PurposeRepository purposeRepo;

    @Resource
    TransactionRepository transactionRepo;

    @Resource
    ReceiptRepository receiptRepo;

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

    @PostMapping("/edit-foundation")
    public Collection<Foundation> editFoundation(@RequestBody Foundation incomingFoundation) throws IOException {
        if (foundationRepo.findById(incomingFoundation.getId()).isPresent()) {
            Foundation foundationToEdit = foundationRepo.findById(incomingFoundation.getId()).get();
            foundationToEdit.setContributionInPennies(incomingFoundation.getContributionInPennies());

            foundationRepo.save(foundationToEdit);
        }
        return (Collection<Foundation>) foundationRepo.findAll();

    }

    @PostMapping("/get-foundation-items-from-foundation")
    public Collection<FoundationItem> getItemsFromFoundation(@RequestBody Foundation incomingFoundation) {
        List<FoundationItem> itemsToReturn = new ArrayList<>();

        if (foundationRepo.findById(incomingFoundation.getId()).isPresent()) {
            Foundation foundationToExtract = foundationRepo.findById(incomingFoundation.getId()).get();

            if (!foundationToExtract.getTransactions().isEmpty()) {
                for (Transaction transaction : foundationToExtract.getTransactions()) {
                    if (receiptRepo.existsByTransactionId(transaction.getId())) {
                        Receipt receiptToGrab = receiptRepo.findByTransactionId(transaction.getId());
                        FoundationItem itemToReturn = receiptToGrab.getFoundationItem();
                        itemsToReturn.add(itemToReturn);
                    }
                }
            }

        }
        Collections.sort(itemsToReturn);
        return itemsToReturn;
    }

}
