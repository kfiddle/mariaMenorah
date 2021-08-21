package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
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


    public void setContributionInPennies(int totalPennies) {
        contributionInPennies = totalPennies;
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

    public void setLeftOverPennies() {
        leftOverPennies = contributionInPennies;

        if (transactions.size() > 0) {
            for (Transaction transaction : transactions) {
                leftOverPennies -= transaction.getTotalPennies();
            }
        }
    }

    public int getLeftOverPennies() {
        setLeftOverPennies();
        return leftOverPennies;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }
}
