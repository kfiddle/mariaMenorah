package com.example.demo.controllers;


import com.example.demo.models.BudgetItem;
import com.example.demo.models.Payee;
import com.example.demo.repositories.BudgetItemRepository;
import com.example.demo.repositories.PayeeRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;


@CrossOrigin
@RestController

public class RestBudget {


    @Resource
    BudgetItemRepository budgetItemRepo;

    @Resource
    PayeeRepository payeeRepo;


    @PostMapping("/add-budget-item")
    public Collection<BudgetItem> addItem(@RequestBody BudgetItem incomingBudgetItem) {

        if (incomingBudgetItem.getPayees().size() > 0) {
            Collection<Payee> payeesToAdd = new ArrayList<>();

            for (Payee payee : incomingBudgetItem.getPayees()) {
                if (payeeRepo.findById(payee.getId()).isPresent()) {
                    Payee payeeToAdd = payeeRepo.findById(payee.getId()).get();
                    payeesToAdd.add(payeeToAdd);
                    payeeRepo.save(payeeToAdd);
                }
            }
            BudgetItem budgetItemToAdd = new BudgetItem(incomingBudgetItem.getCommunity(), incomingBudgetItem.getItem(),
                    payeesToAdd, incomingBudgetItem.getDateOfPurchase(), incomingBudgetItem.getCostInPennies());

            if (incomingBudgetItem.getNotes() != null) {
                budgetItemToAdd.setNotes(incomingBudgetItem.getNotes());
            }
            budgetItemRepo.save(budgetItemToAdd);
        } else {
            BudgetItem budgetItemToAdd = new BudgetItem(incomingBudgetItem.getCommunity(), incomingBudgetItem.getItem(),
                    incomingBudgetItem.getDateOfPurchase(), incomingBudgetItem.getCostInPennies());

            if (incomingBudgetItem.getNotes() != null) {
                budgetItemToAdd.setNotes(incomingBudgetItem.getNotes());
            }
            budgetItemRepo.save(budgetItemToAdd);
        }


        return (Collection<BudgetItem>) budgetItemRepo.findAll();
    }


    @RequestMapping("/{community}/{month}")
    public Collection<BudgetItem> getAllItemsByCommunityAndMonth(@PathVariable String community, @PathVariable int month) {
        Collection<BudgetItem> budgetItemsToReturn = new ArrayList<>();

        for (BudgetItem budgetItem : budgetItemRepo.findByCommunity(community)) {
            if (budgetItem.getDateOfPurchase().getMonthValue() == month) {
                budgetItemsToReturn.add(budgetItem);
            }
        }
        return budgetItemsToReturn;
    }

    @PostMapping("/delete-budget-item")
    public Collection<BudgetItem> deleteItem(@RequestBody BudgetItem incomingItem) {
        if (budgetItemRepo.findById(incomingItem.getId()).isPresent()) {
            budgetItemRepo.deleteById(incomingItem.getId());
        }
        return (Collection<BudgetItem>) budgetItemRepo.findAll();
    }


}
