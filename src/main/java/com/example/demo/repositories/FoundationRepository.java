package com.example.demo.repositories;

import com.example.demo.models.Foundation;
import com.example.demo.models.Purpose;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface FoundationRepository extends CrudRepository<Foundation, Long> {

    boolean existsByName(String name);

    Collection<Foundation> findByPurpose(Purpose purpose);

    Foundation findByName(String foundationName);
}
