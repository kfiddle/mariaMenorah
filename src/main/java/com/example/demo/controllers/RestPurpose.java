package com.example.demo.controllers;


import com.example.demo.models.FoundationItem;
import com.example.demo.models.Purpose;
import com.example.demo.repositories.FoundationItemRepository;
import com.example.demo.repositories.PurposeRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class RestPurpose {


    @Resource
    PurposeRepository purposeRepo;

    @Resource
    FoundationItemRepository foundationItemRepo;

    @RequestMapping("/get-purposes")
    public Collection<Purpose> getAllPurposes() {
        return (Collection<Purpose>) purposeRepo.findAll();
    }

    @PostMapping("/add-purpose")
    public Collection<Purpose> addAPurpose(@RequestBody Purpose purposeToAdd) {
        if (!purposeRepo.existsByTitle(purposeToAdd.getTitle())) {
            purposeRepo.save(purposeToAdd);
        }
        return (Collection<Purpose>) purposeRepo.findAll();
    }

    @PostMapping("/get-foundation-items-from-purpose")
    public Collection<FoundationItem> getItemsFromPurpose(@RequestBody Purpose incomingPurpose) throws IOException {
        List<FoundationItem> itemsToReturn = new ArrayList<>();

        try {
            if (purposeRepo.findById(incomingPurpose.getId()).isPresent()) {
                Purpose purposeToExtract = purposeRepo.findById(incomingPurpose.getId()).get();

                for (FoundationItem foundationItem : foundationItemRepo.findAll()) {
                    if (foundationItem.getPurpose().equals(purposeToExtract)) {
                        itemsToReturn.add(foundationItem);
                    }
                }
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        Collections.sort(itemsToReturn);
        return itemsToReturn;
    }

}
