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

//    public static class TransactionPair {
//        int pennies;
//        Foundation foundation;
//
//        public TransactionPair(int pennies, Foundation foundation) {
//            this.pennies = pennies;
//            this.foundation = foundation;
//        }
//    }

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


    @RequestMapping("/get-stringable-events")
    public Collection<String> getStringableEvents() {

        Collection<String> stringsToSendBack = new ArrayList<>();

        for (Event event : eventRepo.findAll()) {
            String stringToReturn =
                    event.getTitle() + "," + event.getDate() + "," + event.getPurpose().getTitle() + "," + event.getTotalCostInCents() + event.getId();
            stringsToSendBack.add(stringToReturn);
        }
        return stringsToSendBack;

    }


    @PostMapping("/add-event")
    public Collection<Event> addEventWithItsTransactions(@RequestBody Event incomingEvent) throws IOException {

//        if (!eventRepo.existsByTitle(incomingEvent.getTitle()) && !eventRepo.existsByDate(incomingEvent.getDate())) {
//
//            Collection<Transaction> transactionsToPutInEvent = new ArrayList<>(incomingEvent.getTransactions());

//            for (Transaction transaction : transactionsToPutInEvent) {
//                Transaction newTransactionToSave = new Transaction(transaction.getTotalPennies());
//                transaction.getFoundation().addTransaction(newTransactionToSave);
//                transactionRepo.save(newTransactionToSave);
//                System.out.println(newTransactionToSave.getFoundation().getName() + " will give " + newTransactionToSave.getTotalPennies());
//                System.out.println(newTransactionToSave.getFoundation().getTransactions().size());


//                if (foundationRepo.existsByName(transaction.getFoundationName())) {
//
//                    Foundation foundationToConnect = foundationRepo.findByName(transaction.getFoundationName());
//                    foundationToConnect.addTransaction(transaction);
//                    System.out.println(foundationToConnect.getName() + " has " + foundationToConnect.getTransactions().size() + " transactions");

//                    foundationToConnect.setLeftOverPennies(transaction.getTotalPennies());
//                    foundationRepo.save(foundationToConnect);

//            }
//        }
//            Event eventToAdd = new Event(incomingEvent.getTitle(),
//                    incomingEvent.getDate(),
//                    incomingEvent.getPurpose(),
//                    incomingEvent.getTotalCostInCents(),
//                    transactionsToPutInEvent);
//
//            eventRepo.save(eventToAdd);


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
