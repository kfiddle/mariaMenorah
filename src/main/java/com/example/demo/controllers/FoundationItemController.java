package com.example.demo.controllers;


import com.example.demo.models.*;
import com.example.demo.repositories.*;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

@CrossOrigin
@RestController
public class FoundationItemController {

    @Resource
    FoundationRepository foundationRepo;

    @Resource
    TransactionRepository transactionRepo;

    @Resource
    ItemRepository itemRepo;

    @Resource
    FoundationItemRepository foundationItemRepo;

    @Resource
    PurposeRepository purposeRepo;

    @Resource
    PayeeRepository payeeRepo;


    @RequestMapping("/get-foundation-items")
    public Collection<FoundationItem> getAllFoundationItems() {
        return (Collection<FoundationItem>) foundationItemRepo.findAll();
    }

    @PostMapping("/add-or-modify-foundation-item/{addOrModify}")
    public Collection<FoundationItem> addOrModifyFoundationItems(@RequestBody FoundationItem incoming, @PathVariable String addOrModify) {

        FoundationItem workingVersion = new FoundationItem();

        if (addOrModify.equals("modify")) {
            if (foundationItemRepo.findById(incoming.getId()).isPresent()) {
                workingVersion = foundationItemRepo.findById(incoming.getId()).get();
            }
        }

        if (incoming.getName() != null) {
            workingVersion.setName(incoming.getName());
        }

        if (incoming.getDate() != null) {
            workingVersion.setDate(incoming.getDate());
        }

        if (incoming.getTotalCostInCents() != 0) {
            workingVersion.setTotalCostInCents(incoming.getTotalCostInCents());
        }

        if (incoming.getPurpose() != null) {
            workingVersion.setPurpose(incoming.getPurpose());
        }

        if (incoming.getTransactions().size() > 0) {
            Collection<Transaction> transactionsToSave = new ArrayList<>();

            for (Transaction transaction : incoming.getTransactions()) {
                Transaction newTransactionToSave = new Transaction(transaction.getTotalPennies(), transaction.getFoundation());

                Foundation foundationToDebit = foundationRepo.findById(transaction.getFoundation().getId()).get();
                foundationToDebit.debitLotsOfPennies(transaction.getTotalPennies());
                foundationRepo.save(foundationToDebit);

                transactionsToSave.add(newTransactionToSave);
                transactionRepo.save(newTransactionToSave);
            }
            workingVersion.setTransactions(transactionsToSave);
        }

        if (incoming.getPayees().size() > 0) {
            Collection<Payee> payeesToAdd = new ArrayList<>();

            for (Payee payee : incoming.getPayees()) {
                if (payeeRepo.findById(payee.getId()).isPresent()) {
                    Payee payeeToAdd = payeeRepo.findById(payee.getId()).get();
                    payeesToAdd.add(payeeToAdd);
                    payeeRepo.save(payeeToAdd);
                }
            }
            workingVersion.setPayees(payeesToAdd);
        }

        if (incoming.getNotes() != null) {
            workingVersion.setNotes(incoming.getNotes());

        }


        foundationItemRepo.save(workingVersion);
        System.out.println(workingVersion.getId() + " , " + workingVersion.getName() + "  , " + workingVersion.getTransactions());
        return (Collection<FoundationItem>) foundationItemRepo.findAll();

    }


}