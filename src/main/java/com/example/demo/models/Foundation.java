package com.example.demo.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Foundation {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    private Purpose purpose;

    @OneToOne
    private AmountOfMoney contributionAmount;

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

    public Foundation(String name, AmountOfMoney contributionAmount) {
        this.name = name;
        this.contributionAmount = contributionAmount;
    }

    public Foundation(String name, AmountOfMoney contributionAmount, Purpose purpose) {
        this.name = name;
        this.contributionAmount = contributionAmount;
        this.purpose = purpose;
    }



    public void setContributionAmount(AmountOfMoney contributionAmount) {
        this.contributionAmount = contributionAmount;
    }




    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContributionAmount() {
        return contributionAmount.toString();
    }

    public AmountOfMoney getOriginalMoneyObject() {
        return contributionAmount;
    }

    public Purpose getPurpose() { return purpose; }
}
