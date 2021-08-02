package com.example.demo.controllers;


import com.example.demo.models.BudgetItem;
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


}
