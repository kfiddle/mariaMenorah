package com.example.demo.models;

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

    @ManyToOne
    private FoundationItem foundationItem;

    public Receipt() {
    }

    public Receipt(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getId() {
        return id;
    }

    public Long getTransactionId() {
        return transactionId;
    }
}
