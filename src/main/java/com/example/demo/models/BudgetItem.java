package com.example.demo.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;

@Entity
public class BudgetItem {

    @Id
    @GeneratedValue
    private Long id;

    private String item;
    private int costInPennies;

    private LocalDate dateOfPurchase;

    private String community;

    @ManyToMany
    private Collection<Payee> payees;


    public BudgetItem() {
    }

    public BudgetItem(String community, String item, LocalDate dateOfPurchase, int costInPennies) {
        this.community = community;
        this.item = item;
        this.dateOfPurchase = dateOfPurchase;
        this.costInPennies = costInPennies;
    }

    public BudgetItem(String community, String item, Collection<Payee> payees, LocalDate dateOfPurchase, int costInPennies) {
        this.community = community;
        this.item = item;
        this.payees = payees;
        this.dateOfPurchase = dateOfPurchase;
        this.costInPennies = costInPennies;
    }


    public BudgetItem(String item, int costInPennies, LocalDate dateOfPurchase) {
        this.item = item;
        this.costInPennies = costInPennies;
        this.dateOfPurchase = dateOfPurchase;
    }

    public Long getId() {
        return id;
    }


    public String getItem() {
        return item;
    }

    public String getCommunity() {
        return community;
    }

    public Collection<Payee> getPayees() {
        return payees;
    }

    public int getCostInPennies() {
        return costInPennies;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }
}
