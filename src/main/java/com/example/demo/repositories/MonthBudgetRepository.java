package com.example.demo.repositories;

import com.example.demo.models.MonthBudget;
import org.springframework.data.repository.CrudRepository;

public interface MonthBudgetRepository extends CrudRepository<MonthBudget, Long> {

}
