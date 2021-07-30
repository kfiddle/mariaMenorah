package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private LocalDate date;
    private int totalCostInCents;

    @OneToOne
    private Purpose purpose;

    private int startingHour;
    private int startingMinute;

    private int endingHour;
    private int endingMinute;

    @OneToMany
    private Collection<Transaction> transactions;


    @ManyToMany
    private Collection<Payee> payees;


    public Event() {
    }

    public Event(String title) {
        this.title = title;
    }

    public Event(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    public Event(String title, LocalDate date, int totalCostInCents) {
        this.title = title;
        this.date = date;
        this.totalCostInCents = totalCostInCents;
    }

    public Event(String title, LocalDate date, Purpose purpose) {
        this.title = title;
        this.date = date;
        this.purpose = purpose;
    }

    public Event(String title, Purpose purpose) {
        this.title = title;
        this.purpose = purpose;
    }

    public Event(String title, LocalDate date, Purpose purpose, int totalCostInCents) {
        this.title = title;
        this.date = date;
        this.purpose = purpose;
        this.totalCostInCents = totalCostInCents;
    }

    public Event(String title, LocalDate date, Purpose purpose, int totalCostInCents, Collection<Transaction> transactions) {
        this.title = title;
        this.date = date;
        this.purpose = purpose;
        this.totalCostInCents = totalCostInCents;
        this.transactions = transactions;
    }

    public Event(String title, LocalDate date, Purpose purpose, int totalCostInCents, Collection<Transaction> transactions, Collection<Payee> payees) {
        this.title = title;
        this.date = date;
        this.purpose = purpose;
        this.totalCostInCents = totalCostInCents;
        this.transactions = transactions;
        this.payees = payees;
    }


    public Event(String title, LocalDate date, int totalCostInCents, int startingHour, int startingMinute, int endingHour, int endingMinute) {
        this.title = title;
        this.date = date;
        this.totalCostInCents = totalCostInCents;
        this.startingHour = startingHour;
        this.startingMinute = startingMinute;
        this.endingHour = endingHour;
        this.endingMinute = endingMinute;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotalCostInCents() {
        return totalCostInCents;
    }

    public int getStartingHour() {
        return startingHour;
    }

    public int getStartingMinute() {
        return startingMinute;
    }

    public int getEndingHour() {
        return endingHour;
    }

    public int getEndingMinute() {
        return endingMinute;
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public Collection<Payee> getPayees() {
        return payees;
    }
}
