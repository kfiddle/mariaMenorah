package com.example.demo.controllers;

import com.example.demo.models.Receipt;
import com.example.demo.models.Transaction;
import com.example.demo.repositories.FoundationRepository;
import com.example.demo.repositories.ReceiptRepository;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@CrossOrigin
@RestController
public class RestReceipt {

    @Resource
    ReceiptRepository receiptRepo;

    @Resource
    FoundationRepository foundationRepo;

    @Resource
    TransactionRepository transactionRepo;

    @PostMapping("/get-transaction-from-receipt")
    public Transaction retrieveATransaction(@RequestBody Receipt receipt) {
        Transaction transactionToReturn = new Transaction();
        if (receiptRepo.findById(receipt.getId()).isPresent()) {
            transactionToReturn = transactionRepo.findById(receipt.getTransactionId()).get();
        }

        return transactionToReturn;
    }


    @PostMapping("/delete-receipt")
    public Collection<Receipt> deleteReceiptFromDatabase(@RequestBody Receipt receipt) {
        if (receiptRepo.findById(receipt.getId()).isPresent()) {
            transactionRepo.deleteById(receipt.getTransactionId());
            receiptRepo.delete(receipt);
        }
        System.out.println("got it");
        return (Collection<Receipt>) receiptRepo.findAll();
    }
}



