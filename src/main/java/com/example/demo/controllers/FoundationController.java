package com.example.demo.controllers;


import com.example.demo.repositories.FoundationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Controller
public class FoundationController {


    @Resource
    FoundationRepository foundationRepo;

}
