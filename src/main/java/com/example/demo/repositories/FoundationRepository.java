package com.example.demo.repositories;

import com.example.demo.models.Foundation;
import org.springframework.data.repository.CrudRepository;

public interface FoundationRepository extends CrudRepository<Foundation, Long> {

    boolean existsByName(String name);
}
