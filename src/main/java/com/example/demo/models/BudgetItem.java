package com.example.demo.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;

@Entity
public class BudgetItem {

    @Id
    @GeneratedValue
    private Long id;

    private String item;
    private int costInPennies;

    private LocalDate dateOfPurchase;

    private String community;

    @OneToOne
    private Payee payee;

    @ManyToOne
    private MonthBudget monthBudget;

    public BudgetItem() {
    }

    public BudgetItem(String community, String item, LocalDate dateOfPurchase, int costInPennies) {
        this.community = community;
        this.item = item;
        this.dateOfPurchase = dateOfPurchase;
        this.costInPennies = costInPennies;
    }

    public BudgetItem(String community, Payee payee, LocalDate dateOfPurchase, int costInPennies) {
        this.community = community;
        this.payee = payee;
        this.dateOfPurchase = dateOfPurchase;
        this.costInPennies = costInPennies;
    }


    public BudgetItem(MonthBudget monthBudget, String item, int costInPennies) {
        this.monthBudget = monthBudget;
        this.item = item;

        this.costInPennies = costInPennies;
    }

    public BudgetItem(MonthBudget monthBudget, Payee payee, int costInPennies) {
        this.monthBudget = monthBudget;
        this.payee = payee;
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

    public MonthBudget getMonthBudget() {
        return monthBudget;
    }

    public String getItem() {
        return item;
    }

    public String getCommunity() {
        return community;
    }

    public Payee getPayee() {
        return payee;
    }

    public int getCostInPennies() {
        return costInPennies;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }
}
