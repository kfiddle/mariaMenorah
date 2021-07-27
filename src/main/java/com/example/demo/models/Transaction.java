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
    private Long foundationId;

    @ManyToOne
    private Event event;


//    @ManyToOne
//    private Foundation foundation;

    public Transaction() {
    }

//    public Transaction(int totalPennies, Foundation foundation) {
//        this.totalPennies = totalPennies;
//        this.foundation = foundation;
//    }

    public Transaction(int totalPennies, Long foundationId) {
        this.totalPennies = totalPennies;
        this.foundationId = foundationId;
    }

    public Long getId() {
        return id;
    }

    public int getTotalPennies() {
        return totalPennies;
    }


//    public Foundation getFoundation() {
//        return foundation;
//    }

    public Long getFoundationId() {
        return foundationId;
    }

    public Event getEvent() {
        return event;
    }
}
