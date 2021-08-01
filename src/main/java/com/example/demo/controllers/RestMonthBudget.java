package com.example.demo.controllers;


import com.example.demo.models.BudgetItem;
import com.example.demo.models.MonthBudget;
import com.example.demo.repositories.BudgetItemRepository;
import com.example.demo.repositories.MonthBudgetRepository;
import com.example.demo.repositories.PayeeRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@CrossOrigin
@RestController

public class RestMonthBudget {

    @Resource
    MonthBudgetRepository monthBudgetRepo;

    @Resource
    BudgetItemRepository budgetItemRepo;

    @Resource
    PayeeRepository payeeRepo;


    @RequestMapping("/stone-gardens/{month}")
    public MonthBudget getMonthBudgetFromMonth(@PathVariable String month) {
//        System.out.println(monthBudgetRepo.findByCommunityNameAndMonth("Stone Gardens", month).getMonth());
//        System.out.println(monthBudgetRepo.findByCommunityNameAndMonth("Stone Gardens", month).getCommunityName());
        return monthBudgetRepo.findByCommunityNameAndMonth("Stone Gardens", month);
    }

//    MonthBudget monthBudgetToReturn = new MonthBudget();
//
//        for (MonthBudget monthBudget : monthBudgetRepo.findAll()) {
//            if (monthBudget.getCommunityName().equals("Stone Gardens") && monthBudget.getMonth().equals(month)) {
//                return monthBudget;
//            }
//        }


}
