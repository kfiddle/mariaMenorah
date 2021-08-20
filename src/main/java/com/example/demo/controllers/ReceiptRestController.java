package com.example.demo.controllers;


import com.example.demo.models.Item;
import com.example.demo.models.Receipt;
import com.example.demo.models.Transaction;
import com.example.demo.repositories.FoundationRepository;
import com.example.demo.repositories.ReceiptRepository;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@CrossOrigin
@RestController
public class ReceiptRestController {

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

        System.out.println(transactionToReturn.getTotalPennies() + "   " + transactionToReturn.getFoundation().getName());
        return transactionToReturn;
    }
}
