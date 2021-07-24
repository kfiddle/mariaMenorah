package com.example.demo.controllers;


import com.example.demo.models.Event;
import com.example.demo.models.Foundation;
import com.example.demo.models.Purpose;
import com.example.demo.models.Transaction;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.FoundationRepository;
import com.example.demo.repositories.PurposeRepository;
import com.example.demo.repositories.TransactionRepository;
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


    @RequestMapping("/get-events")
    public Collection<Event> getAllEvents() {
        return (Collection<Event>) eventRepo.findAll();
    }


    @PostMapping("/add-event")
    public Collection<Event> addEventWithItsTransactions(@RequestBody Event incomingEvent) throws IOException {

        if (!eventRepo.existsByTitle(incomingEvent.getTitle()) && !eventRepo.existsByDate(incomingEvent.getDate())) {


            Collection<Transaction> transactionsToPutInEvent = new ArrayList<>(incomingEvent.getTransactions());
            transactionRepo.saveAll(incomingEvent.getTransactions());


//            for (Transaction transaction : transactionsToPutInEvent) {
//                if (foundationRepo.findById(transaction.getFoundation().getId()).isPresent()) {
//                    Foundation foundationToDebit = foundationRepo.findById(transaction.getFoundation().getId()).get();
//                    foundationToDebit.setLeftOverPennies(transaction.getTotalPennies());
//                    foundationRepo.save(foundationToDebit);
//                }
//            }

            for (Transaction transaction : transactionsToPutInEvent) {
                if (foundationRepo.findById(transaction.getFoundation().getId()).isPresent()) {
                    Foundation foundationToGetTransaction = foundationRepo.findById(transaction.getFoundation().getId()).get();
                    foundationToGetTransaction.addTransaction(transaction);
                    foundationRepo.save(foundationToGetTransaction);
                }
            }

            Event eventToAdd = new Event(incomingEvent.getTitle(),
                    incomingEvent.getDate(),
                    incomingEvent.getPurpose(),
                    incomingEvent.getTotalCostInCents(),
                    transactionsToPutInEvent);

            eventRepo.save(eventToAdd);
            System.out.println(eventToAdd.getTotalCostInCents());

        }
        return (Collection<Event>) eventRepo.findAll();


    }



    @PostMapping("/delete-event")
    public Collection<Event> deleteAnEventInDatabase(@RequestBody Event eventToDelete) throws IOException {

        if (eventRepo.findById(eventToDelete.getId()).isPresent()) {



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
