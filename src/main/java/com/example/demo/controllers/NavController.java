package com.example.demo.controllers;


import com.example.demo.models.Foundation;
import com.example.demo.models.Transaction;
import com.example.demo.repositories.FoundationRepository;
import com.example.demo.repositories.PurposeRepository;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class NavController {

    @Resource
    FoundationRepository foundationRepo;

    @Resource
    PurposeRepository purposeRepo;

    @Resource
    TransactionRepository transactionRepo;

    @RequestMapping("/")
    public String showPageToAddEventsAndFoundations() {
        return "entry";
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

    @RequestMapping("/all-transactions")
    public String showAllTransactionsPage(Model model) {
        model.addAttribute("allTransactions", transactionRepo.findAll());
        return "allTransactions";
    }



}
