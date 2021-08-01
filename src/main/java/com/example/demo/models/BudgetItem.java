package com.example.demo.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;

@Entity
public class BudgetItem {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int costInPennies;
    private LocalDate dateOfPurchase;

    @OneToOne
    private Payee payee;

    @ManyToOne
    private MonthBudget monthBudget;

    public BudgetItem() {
    }

    public BudgetItem(MonthBudget monthBudget, String name, int costInPennies) {
        this.monthBudget = monthBudget;
        this.name = name;
        this.costInPennies = costInPennies;
    }

    public BudgetItem(MonthBudget monthBudget, Payee payee, int costInPennies) {
        this.monthBudget = monthBudget;
        this.payee = payee;
        this.costInPennies = costInPennies;
    }

    public BudgetItem(String name, int costInPennies, LocalDate dateOfPurchase){
        this.name = name;
        this.costInPennies = costInPennies;
        this.dateOfPurchase = dateOfPurchase;
    }

    public Long getId() {
        return id;
    }

    public MonthBudget getMonthBudget() {
        return monthBudget;
    }

    public String getName() {
        return name;
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
