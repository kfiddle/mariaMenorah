package com.example.demo.controllers;


import com.example.demo.models.AmountOfMoney;
import com.example.demo.models.Event;
import com.example.demo.models.Foundation;
import com.example.demo.models.Purpose;
import com.example.demo.repositories.AmountOfMoneyRepository;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.FoundationRepository;
import com.example.demo.repositories.PurposeRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;


@CrossOrigin
@RestController
public class RestishController {

    @Resource
    FoundationRepository foundationRepo;

    @Resource
    EventRepository eventRepo;

    @Resource
    AmountOfMoneyRepository amountOfMoneyRepo;

    @Resource
    PurposeRepository purposeRepo;


    @PostMapping("/add-foundation")
    public Collection<Foundation> addFoundationToDatabase(@RequestBody Foundation incomingFoundation) throws IOException {


        Foundation foundationToAdd = new Foundation(incomingFoundation.getName());
        if (!foundationRepo.existsByName(incomingFoundation.getName())) {
            foundationRepo.save(foundationToAdd);
        }

        return (Collection<Foundation>) foundationRepo.findAll();
    }

    @PostMapping("/add-event")
    public Collection<Event> addEventToDatabase(@RequestBody Event incomingEvent) throws IOException {

        if (!eventRepo.existsByTitle(incomingEvent.getTitle()) && !eventRepo.existsByDate(incomingEvent.getDate())) {
            AmountOfMoney incomingMoney = new AmountOfMoney(incomingEvent.getTotalCostInCents());
            amountOfMoneyRepo.save(incomingMoney);
            incomingEvent.setCost(incomingMoney);
            eventRepo.save(incomingEvent);
            System.out.println(incomingEvent.getFoundations().size());
        }
        return (Collection<Event>) eventRepo.findAll();
    }

    @RequestMapping("/get-foundations")
    public Collection<Foundation> getAllFoundations() {
        return (Collection<Foundation>) foundationRepo.findAll();
    }

    @RequestMapping("/get-purposes")
    public Collection<Purpose> getAllPurposes() {
        return (Collection<Purpose>) purposeRepo.findAll();
    }

}
