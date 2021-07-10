package com.example.demo.repositories;

import com.example.demo.models.Event;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface EventRepository extends CrudRepository<Event, Long> {

    boolean existsByTitle(String title);

    boolean existsByDate(LocalDate date);
}
