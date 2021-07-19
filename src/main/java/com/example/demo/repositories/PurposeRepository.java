package com.example.demo.repositories;

import com.example.demo.models.Purpose;
import org.springframework.data.repository.CrudRepository;

public interface PurposeRepository extends CrudRepository<Purpose, Long> {

    boolean existsByTitle(String title);
}
