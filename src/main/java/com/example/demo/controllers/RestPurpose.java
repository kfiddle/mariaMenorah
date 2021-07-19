package com.example.demo.controllers;


import com.example.demo.models.Purpose;
import com.example.demo.repositories.PurposeRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@CrossOrigin
@RestController
public class RestPurpose {


    @Resource
    PurposeRepository purposeRepo;

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


}
