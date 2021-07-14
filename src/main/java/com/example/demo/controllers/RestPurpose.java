package com.example.demo.controllers;


import com.example.demo.models.Purpose;
import com.example.demo.repositories.PurposeRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
