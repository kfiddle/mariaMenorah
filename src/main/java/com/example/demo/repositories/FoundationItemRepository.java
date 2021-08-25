package com.example.demo.repositories;

import com.example.demo.models.FoundationItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface FoundationItemRepository extends CrudRepository<FoundationItem, Long> {

    Collection<FoundationItem> findByOrderByDate();
}
