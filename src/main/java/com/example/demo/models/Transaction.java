package com.example.demo.models;


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

    @ManyToOne
    private Foundation foundation;

    public Transaction() {
    }

    public Transaction(int totalPennies, Foundation foundation) {
        this.totalPennies = totalPennies;
        this.foundation = foundation;
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