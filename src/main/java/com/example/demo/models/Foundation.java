package com.example.demo.models;

import javax.persistence.*;
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

    @OneToOne
    private Purpose purpose;

    public Foundation() {
    }

    public Foundation(String name) {
        this.name = name;
    }

    public Foundation(String name, Purpose purpose) {
        this.name = name;
        this.purpose = purpose;
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

    public Purpose getPurpose() { return purpose; }
}
