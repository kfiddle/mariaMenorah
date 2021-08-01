package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;


@Entity
public class MonthBudget {

    @Id
    @GeneratedValue
    private Long id;

    private String communityName;
    private String month;
    private int leftOverPennies;

    @OneToMany
    private Collection<BudgetItem> budgetItems;



    public MonthBudget() {
    }

    public MonthBudget(String communityName, String month) {
        this.communityName = communityName;
        this.month = month;
    }

    public Long getId() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    public int getLeftOverPennies() {
        return leftOverPennies;
    }

    public Collection<BudgetItem> getBudgetItems() {
        return budgetItems;
    }
}
