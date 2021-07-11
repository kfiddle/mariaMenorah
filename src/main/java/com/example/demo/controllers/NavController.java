package com.example.demo.controllers;


import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.FoundationRepository;
import com.example.demo.repositories.PurposeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class NavController {

    @Resource
    FoundationRepository foundationRepo;

    @Resource
    EventRepository eventRepo;

    @Resource
    PurposeRepository purposeRepo;

    @RequestMapping("/entry")
    public String showPageToAddEventsAndFoundations() {
        return "entry";
    }

    @RequestMapping("/all-events")
    public String showAllEventsPage(Model model) {

        model.addAttribute("allEvents", eventRepo.findAll());
        return "allEvents";

    }

    @RequestMapping("/all-foundations")
    public String showAllFoundationsPage(Model model) {

        model.addAttribute("allFoundations", foundationRepo.findAll());
        return "allFoundations";
    }

    @RequestMapping("/all-purposes")
    public String showAllPurposesPage(Model model) {

        model.addAttribute("allPurposes", purposeRepo.findAll());
        return "allPurposes";
    }



}
