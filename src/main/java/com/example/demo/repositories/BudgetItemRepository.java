package com.example.demo.repositories;

import com.example.demo.models.BudgetItem;
import org.springframework.data.repository.CrudRepository;

public interface BudgetItemRepository extends CrudRepository<BudgetItem, Long> {

}
