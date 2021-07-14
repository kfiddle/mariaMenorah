package com.example.demo.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Foundation {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int contributionInPennies;

    @OneToOne
    private Purpose purpose;

    @OneToMany
    private Collection<Transaction> transactions;

    @ManyToMany
    private Collection<Event> events;

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
        this.purpose = purpose;
    }

    public void debitPenniesFromTotal(int penniesToDebit) {
        this.contributionInPennies -= penniesToDebit;
    }

    public int leftOverPennies() {
        int spentOnTransactions = 0;
        for (Transaction transaction : transactions) {
            spentOnTransactions += transaction.getTotalPennies();
        }
        return contributionInPennies - spentOnTransactions;
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

    public Purpose getPurpose() { return purpose; }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }
}
