package com.example.demo.controllers;


import com.example.demo.models.Event;
import com.example.demo.models.Foundation;
import com.example.demo.models.Payee;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.PayeeRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@CrossOrigin
@RestController
public class RestPayee {

    @Resource
    PayeeRepository payeeRepo;

    @Resource
    EventRepository eventRepo;


    @RequestMapping("/get-payees")
    public Collection<Payee> getAllPayees() {
        return (Collection<Payee>) payeeRepo.findAll();
    }

    @PostMapping("/add-payee")
    public Collection<Payee> addPayeeToDatabase(@RequestBody Payee incomingPayee) throws IOException {

        if (!payeeRepo.existsByLastName(incomingPayee.getLastName()) && !payeeRepo.existsByFirstName(incomingPayee.getFirstName())) {
            Payee payeeToAdd = new Payee(incomingPayee.getFirstName(), incomingPayee.getLastName());
            payeeRepo.save(payeeToAdd);
        }

        return (Collection<Payee>) payeeRepo.findAll();
    }

    @PostMapping("/get-events-from-payee")
    public Collection<Event> getAllEventsOfPayee(@RequestBody Payee incomingPayee) throws IOException {
        Collection<Event> eventsToSendBack = new ArrayList<>();

        if (payeeRepo.findById(incomingPayee.getId()).isPresent()) {
            Payee payeeToOfferEvents = payeeRepo.findById(incomingPayee.getId()).get();
            eventsToSendBack.addAll(payeeToOfferEvents.getEvents());
        }
        return eventsToSendBack;
    }

}
