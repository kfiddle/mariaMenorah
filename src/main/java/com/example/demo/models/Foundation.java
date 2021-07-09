package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Foundation {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double contributionAmount;

    @ManyToMany
    private Collection<Event> events;

    public Foundation() {
    }

    public Foundation(String name) {
        this.name = name;
    }

    public Foundation(String name, double contributionAmount) {
        this.name = name;
        this.contributionAmount = contributionAmount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getContributionAmount() {
        return contributionAmount;
    }
}
