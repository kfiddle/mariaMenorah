package com.example.demo.repositories;

import com.example.demo.models.Event;
import com.example.demo.models.Purpose;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.Collection;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    boolean existsByTitle(String title);

    boolean existsByDate(LocalDate date);


}
