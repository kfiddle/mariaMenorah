package com.example.demo.controllers;


import com.example.demo.models.*;
import com.example.demo.repositories.*;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@CrossOrigin
@RestController
public class RestEvent {


    @Resource
    FoundationRepository foundationRepo;

    @Resource
    TransactionRepository transactionRepo;

    @Resource
    EventRepository eventRepo;

    @Resource
    PurposeRepository purposeRepo;

    @Resource
    PayeeRepository payeeRepo;


    @RequestMapping("/get-events")
    public Collection<Event> getAllEvents() {

        return (Collection<Event>) eventRepo.findAll();
    }


    @PostMapping("/add-event")
    public Collection<Event> addEventWithItsTransactions(@RequestBody Event incomingEvent) throws IOException {

        if (!eventRepo.existsByTitle(incomingEvent.getTitle()) && !eventRepo.existsByDate(incomingEvent.getDate())) {
            Collection<Transaction> transactionsToSave = new ArrayList<>();
            Collection<Payee> payeesToAdd = new ArrayList<>();

            if (incomingEvent.getTransactions().size() > 0) {
                for (Transaction transaction : incomingEvent.getTransactions()) {
                    Transaction newTransactionToSave = new Transaction(transaction.getTotalPennies(), transaction.getFoundation());

                    Foundation foundationToDebit = foundationRepo.findById(transaction.getFoundation().getId()).get();
                    foundationToDebit.debitLotsOfPennies(transaction.getTotalPennies());
                    foundationRepo.save(foundationToDebit);

                    transactionsToSave.add(newTransactionToSave);
                    transactionRepo.save(newTransactionToSave);
                }
            }

            if (incomingEvent.getPayees().size() > 0) {

                for (Payee payee : incomingEvent.getPayees()) {
                    if (payeeRepo.findById(payee.getId()).isPresent()) {
                        Payee payeeToAdd = payeeRepo.findById(payee.getId()).get();
                        payeesToAdd.add(payeeToAdd);
                        payeeRepo.save(payeeToAdd);
                    }
                }
            }


            Event eventToAdd = new Event(incomingEvent.getTitle(),
                    incomingEvent.getDate(),
                    incomingEvent.getPurpose(),
                    incomingEvent.getTotalCostInCents(),
                    transactionsToSave, payeesToAdd);
            eventRepo.save(eventToAdd);


        }
        return (Collection<Event>) eventRepo.findAll();
    }


    @PostMapping("/delete-event")
    public Collection<Event> deleteAnEventInDatabase(@RequestBody Event eventToDelete) throws IOException {

        if (eventRepo.findById(eventToDelete.getId()).isPresent()) {

            for (Transaction transaction : eventRepo.findById(eventToDelete.getId()).get().getTransactions()) {
                Foundation foundationToRefund = foundationRepo.findById(transaction.getFoundation().getId()).get();
                foundationToRefund.returnThosePennies(transaction.getTotalPennies());
                foundationRepo.save(foundationToRefund);
//                transactionRepo.deleteById(transaction.getId());
            }


            eventRepo.deleteById(eventToDelete.getId());
        }

        return (Collection<Event>) eventRepo.findAll();
    }

    @PostMapping("/edit-event")
    public Collection<Event> editAnEventInDatabase(@RequestBody Event eventToEdit) throws IOException {

        if (eventRepo.findById(eventToEdit.getId()).isPresent()) {
            eventRepo.deleteById(eventToEdit.getId());

        }
        return (Collection<Event>) eventRepo.findAll();

    }


}
