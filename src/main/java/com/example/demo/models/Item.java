package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Item implements Comparable<Item>{
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private LocalDate date;
    private int totalCostInCents;

    private String notes;
    private boolean completed;


    @ManyToMany
    private Collection<Payee> payees;

    public Item(){}

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, LocalDate date, int totalCostInCents) {
        this.name = name;
        this.date = date;
        this.totalCostInCents = totalCostInCents;
    }

    public Item(String name, LocalDate date, int totalCostInCents, Collection<Payee> payees) {
        this.name = name;
        this.date = date;
        this.totalCostInCents = totalCostInCents;
        this.payees = payees;
    }

    public Item(String name, LocalDate date, int totalCostInCents, Collection<Payee> payees, String notes) {
        this.name = name;
        this.date = date;
        this.totalCostInCents = totalCostInCents;
        this.payees = payees;
        this.notes = notes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTotalCostInCents(int totalCostInCents) {
        this.totalCostInCents = totalCostInCents;
    }

    public void setPayees(Collection<Payee> payees) {
        this.payees = payees;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotalCostInCents() {
        return totalCostInCents;
    }

    public Collection<Payee> getPayees() {
        return payees;
    }

    public String getNotes() {
        return notes;
    }

    public boolean isCompleted() { return completed; }


    @Override
    public int compareTo(Item otherItem) {
        return date.compareTo(otherItem.getDate());
    }
}

