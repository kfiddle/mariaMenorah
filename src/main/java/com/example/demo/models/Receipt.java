package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Collection;

@Entity
public class Receipt {


    @Id
    @GeneratedValue
    private Long id;

    private Long transactionId;

    @JsonIgnore
    @ManyToOne
    private FoundationItem foundationItem;

    public Receipt() {
    }

    public Receipt(Long transactionId, FoundationItem foundationItem) {
        this.transactionId = transactionId;
        this.foundationItem = foundationItem;
    }

    public Long getId() {
        return id;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public FoundationItem getFoundationItem() {
        return foundationItem;
    }
}
