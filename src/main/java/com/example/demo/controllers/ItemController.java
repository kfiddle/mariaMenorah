package com.example.demo.controllers;


import com.example.demo.models.FoundationItem;
import com.example.demo.models.Item;
import com.example.demo.models.Transaction;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@CrossOrigin
@RestController
public class ItemController {

    @Resource
    ItemRepository itemRepo;

    @Resource
    TransactionRepository transactionRepo;

    @RequestMapping("/get-items")
    public Collection<Item> getAllItems() {
//        return (Collection<Item>) itemRepo.findAll();
        return itemRepo.findByOrderByDate();
    }

    @PostMapping("/edit-item-completion")
    public Collection<Item> editItemCompletion(@RequestBody Item incoming) {
        if (itemRepo.findById(incoming.getId()).isPresent()) {
            Item itemToEdit = itemRepo.findById(incoming.getId()).get();
            itemToEdit.setCompleted(incoming.isCompleted());
            itemRepo.save(itemToEdit);
        }
        return (Collection<Item>) itemRepo.findAll();
    }

    @PostMapping("/delete-item")
    public Collection<Item> deleteItem(@RequestBody Item incomingItem) {
        if (itemRepo.findById(incomingItem.getId()).isPresent()) {
            itemRepo.deleteById(incomingItem.getId());
        }
        return (Collection<Item>) itemRepo.findAll();
    }

}
