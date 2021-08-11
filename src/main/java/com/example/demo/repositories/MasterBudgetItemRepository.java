package com.example.demo.repositories;

import com.example.demo.models.MasterBudgetItem;
import org.springframework.data.repository.CrudRepository;

public interface MasterBudgetItemRepository extends CrudRepository<MasterBudgetItem, Long> {
}
