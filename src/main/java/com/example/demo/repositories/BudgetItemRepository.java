package com.example.demo.repositories;

import com.example.demo.models.BudgetItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface BudgetItemRepository extends CrudRepository<BudgetItem, Long> {

    Collection<BudgetItem> findByCommunity(String community);

}
