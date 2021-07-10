package com.example.demo.controllers;


import com.example.demo.models.Event;
import com.example.demo.models.Foundation;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.FoundationRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
            eventRepo.save(incomingEvent);
        }
        return (Collection<Event>) eventRepo.findAll();
    }


}
