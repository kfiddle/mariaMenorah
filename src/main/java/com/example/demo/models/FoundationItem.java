package com.example.demo.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class FoundationItem extends Item{

    @OneToOne
    private Purpose purpose;

    @OneToMany
    private Collection<Transaction> transactions;

    public FoundationItem() {}

    public FoundationItem(String name, LocalDate date, int totalCostInCents) {
        super(name, date, totalCostInCents);
    }

    public FoundationItem(String name, LocalDate date, int totalCostInCents, Collection<Payee> payees, Purpose purpose, Collection<Transaction> transactions) {
        super(name, date, totalCostInCents, payees);
        this.purpose = purpose;
        this.transactions = transactions;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public void setTransactions(Collection<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }
}
