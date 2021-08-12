package com.example.demo.repositories;

import com.example.demo.models.BudgetItem;
import com.example.demo.models.MasterBudgetItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface MasterBudgetItemRepository extends CrudRepository<MasterBudgetItem, Long> {

    Collection<MasterBudgetItem> findByCommunity(String community);

}
