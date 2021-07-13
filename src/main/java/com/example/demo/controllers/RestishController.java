package com.example.demo.controllers;


import com.example.demo.models.Event;
import com.example.demo.models.Foundation;
import com.example.demo.models.Purpose;
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
    PurposeRepository purposeRepo;

    public static class Debit {
        Long id;
        int amountToAdjust;

        public Debit(Long id, int amountToAdjust) {
            this.id = id;
            this.amountToAdjust = amountToAdjust;
        }
    }


    @RequestMapping("/get-foundations")
    public Collection<Foundation> getAllFoundations() {
        return (Collection<Foundation>) foundationRepo.findAll();
    }

    @RequestMapping("/get-purposes")
    public Collection<Purpose> getAllPurposes() {
        return (Collection<Purpose>) purposeRepo.findAll();
    }

    @RequestMapping("/get-events")
    public Collection<Event> getAllEvents() {
        return (Collection<Event>) eventRepo.findAll();
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


    @PostMapping("/add-event")
    public Collection<Event> addEventToDatabase(@RequestBody Event incomingEvent) throws IOException {

        if (!eventRepo.existsByTitle(incomingEvent.getTitle()) && !eventRepo.existsByDate(incomingEvent.getDate())) {
            eventRepo.save(incomingEvent);
        }
        return (Collection<Event>) eventRepo.findAll();
    }

    @PostMapping("/delete-event")
    public Collection<Event> deleteAnEventInDatabase(@RequestBody Long eventToDeleteID) throws IOException {

        if (eventRepo.findById(eventToDeleteID).isPresent()) {
            eventRepo.deleteById(eventToDeleteID);
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


    @PostMapping("/deduct-contribution")
    public Collection<Foundation> deductAmountsFromFoundations(@RequestBody Debit debit) {

        if (foundationRepo.findById(debit.id).isPresent()) {
            Foundation foundationToAdjust = foundationRepo.findById(debit.id).get();

            foundationToAdjust.debitPenniesFromTotal(debit.amountToAdjust);

            foundationRepo.save(foundationToAdjust);
        }

        return (Collection<Foundation>) foundationRepo.findAll();
    }


}
