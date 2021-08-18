package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.repositories.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

@CrossOrigin
@RestController
public class MasterBudgetItemController {

    @Resource
    FoundationRepository foundationRepo;

    @Resource
    TransactionRepository transactionRepo;

    @Resource
    ItemRepository itemRepo;

    @Resource
    FoundationItemRepository foundationItemRepo;

    @Resource
    MasterBudgetItemRepository masterBudgetItemRepo;

    @Resource
    PurposeRepository purposeRepo;

    @Resource
    PayeeRepository payeeRepo;

    @RequestMapping("/get-master-budget-items")
    public Collection<MasterBudgetItem> getAllMasterBudgetItems() {
        return (Collection<MasterBudgetItem>) masterBudgetItemRepo.findAll();
    }

    @RequestMapping("/{community}/{month}")
    public Collection<MasterBudgetItem> getAllMasterBudgetItemsByCommunityAndMonth(@PathVariable String community,
                                                                                   @PathVariable int month) {
        Collection<MasterBudgetItem> masterBudgetItemsToReturn = new ArrayList<>();

        for (MasterBudgetItem masterBudgetItem : masterBudgetItemRepo.findByCommunity(community)) {
            if (masterBudgetItem.getDate().getMonthValue() == month) {
                masterBudgetItemsToReturn.add(masterBudgetItem);
            }
        }
        return masterBudgetItemsToReturn;
    }


    @PostMapping("/add-or-modify-master-budget-item/{addOrModify}")
    public Collection<MasterBudgetItem> addOrModifyMasterBudgetItems(@RequestBody MasterBudgetItem incoming, @PathVariable String addOrModify) {

        MasterBudgetItem workingVersion = new MasterBudgetItem();

        if (addOrModify.equals("modify")) {
            if (masterBudgetItemRepo.findById(incoming.getId()).isPresent()) {
                workingVersion = masterBudgetItemRepo.findById(incoming.getId()).get();
            }
        }

        if (!incoming.getName().equals("")) {
            workingVersion.setName(incoming.getName());
        }

        if (incoming.getCommunity() != null) {
            workingVersion.setCommunity(incoming.getCommunity());
        }

        if (incoming.getDate() != null) {
            workingVersion.setDate(incoming.getDate());
        }

        if (incoming.getTotalCostInCents() != 0) {
            workingVersion.setTotalCostInCents(incoming.getTotalCostInCents());
        }

        if (incoming.getPayees().size() > 0) {
            Collection<Payee> payeesToAdd = new ArrayList<>();

            for (Payee payee : incoming.getPayees()) {
                if (payeeRepo.findById(payee.getId()).isPresent()) {
                    Payee payeeToAdd = payeeRepo.findById(payee.getId()).get();
                    payeesToAdd.add(payeeToAdd);
                    payeeRepo.save(payeeToAdd);
                }
            }
            workingVersion.setPayees(payeesToAdd);
        }

        if (incoming.getNotes() != null) {
            workingVersion.setNotes(incoming.getNotes());
        }

        if (incoming.getAccountNum() != null) {
            workingVersion.setAccountNum(incoming.getAccountNum());
        }

        if (incoming.isCompleted()) {
            workingVersion.setCompleted(true);
        }

        masterBudgetItemRepo.save(workingVersion);
        return (Collection<MasterBudgetItem>) masterBudgetItemRepo.findAll();
    }


}
