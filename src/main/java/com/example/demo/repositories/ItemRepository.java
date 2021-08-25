package com.example.demo.repositories;

import com.example.demo.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

    Collection<Item> findByOrderByDate();
}
