package com.example.demo.controllers;


import com.example.demo.models.Foundation;
import com.example.demo.models.Payee;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.PayeeRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;

@CrossOrigin
@RestController
public class RestPayee {

    @Resource
    PayeeRepository payeeRepo;

    @Resource
    EventRepository eventRepo;


    @PostMapping("/add-payee")
    public Collection<Payee> addPayeeToDatabase(@RequestBody Payee incomingPayee) throws IOException {

        if (!payeeRepo.existsByLastName(incomingPayee.getLastName()) && !payeeRepo.existsByFirstName(incomingPayee.getFirstName())) {
            Payee payeeToAdd = new Payee(incomingPayee.getFirstName(), incomingPayee.getLastName());
            payeeRepo.save(payeeToAdd);
        }

        return (Collection<Payee>) payeeRepo.findAll();
    }


}
