package com.example.demo.controllers;


import com.example.demo.models.Event;
import com.example.demo.models.Transaction;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;

@CrossOrigin
@RestController
public class RestTransaction {

    @Resource
    TransactionRepository transactionRepo;

    @RequestMapping("/get-transactions")
    public Collection<Transaction> getAllTransactions() {
        return (Collection<Transaction>) transactionRepo.findAll();
    }

    @PostMapping("/add-transaction")
    public Collection<Transaction> addTransaction(@RequestBody Transaction transactionToAdd) {
        transactionRepo.save(transactionToAdd);
        return (Collection<Transaction>) transactionRepo.findAll();
    }

    @PostMapping("delete-transaction")
    public Collection<Transaction> deleteATransactionInDatabase(@RequestBody Long eventToDeleteID) throws IOException {

        if (transactionRepo.findById(eventToDeleteID).isPresent()) {
            transactionRepo.deleteById(eventToDeleteID);
        }
        return (Collection<Transaction>) transactionRepo.findAll();
    }


    @PostMapping("/get-transaction-from-id")
    public Transaction getTransactionFromId(@RequestBody Long incomingId) throws IOException {

        if (transactionRepo.findById(incomingId).isPresent()) {
            return transactionRepo.findById(incomingId).get();
        } else {
            return null;
        }

    }


}
