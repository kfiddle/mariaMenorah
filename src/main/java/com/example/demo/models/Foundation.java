package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Foundation {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int contributionInPennies;
    private int leftOverPennies;

    @OneToOne
    private Purpose purpose;

    @JsonIgnore
    @OneToMany(mappedBy = "foundation")
    private Collection<Transaction> transactions;

    @ManyToMany
    private Collection<Event> events;

    @ManyToMany
    private Collection<FoundationItem> foundationItems;

    public Foundation() {
    }

    public Foundation(String name) {
        this.name = name;
    }

    public Foundation(String name, Purpose purpose) {
        this.name = name;
        this.purpose = purpose;
    }

    public Foundation(String name, int contributionInPennies, Purpose purpose) {
        this.name = name;
        this.contributionInPennies = contributionInPennies;
        this.leftOverPennies = contributionInPennies;
        this.purpose = purpose;
    }

    public void debitLotsOfPennies(int spentOnATransaction) {
        leftOverPennies -= spentOnATransaction;
    }

    public void returnThosePennies(int totalPennies) {
        leftOverPennies += totalPennies;
    }


    public void setContributionInPennies(int contributionInPennies) {
        this.contributionInPennies = contributionInPennies;
    }


    public void setLeftOverPennies(int leftOverPennies) {
        this.leftOverPennies = leftOverPennies;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getContributionInPennies() {
        return contributionInPennies;
    }

    public int getLeftOverPennies() {
        return leftOverPennies;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }


}
