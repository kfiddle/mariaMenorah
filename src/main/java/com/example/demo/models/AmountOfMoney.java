package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AmountOfMoney {

    @Id
    @GeneratedValue
    private Long id;

    private int totalAmountInCents;
    private int dollars;
    private int cents;

    public AmountOfMoney() {
    }

    public AmountOfMoney(int totalAmountInCents) {
        this.totalAmountInCents = totalAmountInCents;
        this.dollars = totalAmountInCents / 100;
        this.cents = totalAmountInCents % 100;
    }

    @Override
    public String toString() {
        String displayCents;

        if (cents < 10) {
            displayCents = "0" + cents;
        } else {
            displayCents = "" + cents;
        }
        return "$" + dollars + "." + displayCents;
    }


    public int getTotalAmountInCents() {
        return totalAmountInCents;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }
}
