package com.example.demo.models;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class MasterBudgetItem extends Item{

    private String community;

    private String notes;
    private String accountNum;

    public MasterBudgetItem() {}

    public MasterBudgetItem(String name, LocalDate date, int totalCostInCents, Collection<Payee> payees, String community, String notes, String accountNum) {
        super(name, date, totalCostInCents, payees);
        this.community = community;
        this.notes = notes;
        this.accountNum = accountNum;
    }

    public MasterBudgetItem(String name, LocalDate date, int totalCostInCents, String community, String notes, String accountNum) {
        super(name, date, totalCostInCents);
        this.community = community;
        this.notes = notes;
        this.accountNum = accountNum;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getCommunity() {
        return community;
    }

    public String getNotes() {
        return notes;
    }

    public String getAccountNum() {
        return accountNum;
    }
}
