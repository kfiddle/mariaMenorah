package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private int totalPennies;


    @ManyToOne
    private Event event;

    @JsonIgnore
    @ManyToOne
    private Foundation foundation;

    public Transaction() {
    }

    public Transaction(int totalPennies) {
        this.totalPennies = totalPennies;
    }

    public Transaction(int totalPennies, Foundation foundation) {
        this.totalPennies = totalPennies;
    }

    public Long getId() {
        return id;
    }

    public int getTotalPennies() {
        return totalPennies;
    }


    public Foundation getFoundation() {
        return foundation;
    }

    public Event getEvent() {
        return event;
    }
}
