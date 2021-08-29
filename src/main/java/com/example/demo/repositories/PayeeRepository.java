package com.example.demo.repositories;

import com.example.demo.models.Payee;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PayeeRepository extends CrudRepository<Payee, Long> {

    boolean existsByLastName(String lastName);

    boolean existsByFirstName(String firstName);


}
