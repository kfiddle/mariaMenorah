package com.example.demo.controllers;


import com.example.demo.models.Event;
import com.example.demo.models.Foundation;
import com.example.demo.models.Purpose;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.FoundationRepository;
import com.example.demo.repositories.PurposeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;


@CrossOrigin
@RestController
public class RestEvent {

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



    @RequestMapping("/get-events")
    public Collection<Event> getAllEvents() {
        return (Collection<Event>) eventRepo.findAll();
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





}
