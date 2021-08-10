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

    private String community;
    private String item;
    private int costInPennies;
    private LocalDate dateOfPurchase;
    private String notes;
    private String accountNum;


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

    public BudgetItem(String community, String item, Collection<Payee> payees, LocalDate dateOfPurchase, int costInPennies, String notes) {
        this.community = community;
        this.item = item;
        this.payees = payees;
        this.dateOfPurchase = dateOfPurchase;
        this.costInPennies = costInPennies;
        this.notes = notes;
    }

    public BudgetItem(String community, String item, Collection<Payee> payees, LocalDate dateOfPurchase, int costInPennies, String notes, String accountNum) {
        this.community = community;
        this.item = item;
        this.payees = payees;
        this.dateOfPurchase = dateOfPurchase;
        this.costInPennies = costInPennies;
        this.notes = notes;
        this.accountNum = accountNum;
    }


    public BudgetItem(String item, int costInPennies, LocalDate dateOfPurchase) {
        this.item = item;
        this.costInPennies = costInPennies;
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public String getNotes() { return notes; }
}
