package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class FoundationItem extends Item{

    @OneToOne
    private Purpose purpose;

    @OneToMany
    private Collection<Transaction> transactions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "foundationItem")
    private Collection<Receipt> receipts;


    public FoundationItem() {}

    public FoundationItem(String name, LocalDate date, int totalCostInCents) {
        super(name, date, totalCostInCents);
    }

    public FoundationItem(String name, LocalDate date, int totalCostInCents, Purpose purpose) {
        super(name, date, totalCostInCents);
        this.purpose = purpose;
    }



    public FoundationItem(String name, LocalDate date, int totalCostInCents, Collection<Payee> payees) {
        super(name, date, totalCostInCents, payees);
    }

    public FoundationItem(String name, LocalDate date, int totalCostInCents, Purpose purpose, Collection<Transaction> transactions) {
        super(name, date, totalCostInCents);
        this.purpose = purpose;
        this.transactions = transactions;
    }

    public FoundationItem(String name, LocalDate date, int totalCostInCents, Collection<Payee> payees, Purpose purpose, Collection<Transaction> transactions) {
        super(name, date, totalCostInCents, payees);
        this.purpose = purpose;
        this.transactions = transactions;
    }

    public FoundationItem(String name, LocalDate date, int totalCostInCents, Collection<Payee> payees, Purpose purpose) {
        super(name, date, totalCostInCents, payees);
        this.purpose = purpose;

    }
    public FoundationItem(String name, LocalDate date, int totalCostInCents, Collection<Payee> payees, Purpose purpose, Collection<Transaction> transactions, String notes) {
        super(name, date, totalCostInCents, payees, notes);
        this.purpose = purpose;
        this.transactions = transactions;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public void setTransactions(Collection<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setReceipts(Collection<Receipt> receipts) {
        this.receipts = receipts;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    public Collection<Receipt> getReceipts() {
        return receipts;
    }


}
