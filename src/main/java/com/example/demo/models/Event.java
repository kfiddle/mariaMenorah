package com.example.demo.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private LocalDate date;
    private int totalCostInCents;

    @OneToOne
    private AmountOfMoney cost;

    private int startingHour;
    private int startingMinute;

    private int endingHour;
    private int endingMinute;

    @ManyToMany
    private Collection<Foundation> foundations;

    public Event() {
    }

    public Event(String title) {
        this.title = title;
    }

    public Event(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    public Event(String title, LocalDate date, int totalCostInCents) {
        this.title = title;
        this.date = date;
        this.totalCostInCents = totalCostInCents;
    }


    public Event(String title, LocalDate date, int totalCostInCents, int startingHour, int startingMinute, int endingHour, int endingMinute) {
        this.title = title;
        this.date = date;
        this.totalCostInCents = totalCostInCents;
        this.startingHour = startingHour;
        this.startingMinute = startingMinute;
        this.endingHour = endingHour;
        this.endingMinute = endingMinute;
    }

    public Event(String title, LocalDate date, int totalCostInCents, int startingHour, int startingMinute, int endingHour, int endingMinute, Collection<Foundation> foundations) {
        this.title = title;
        this.date = date;
        this.totalCostInCents = totalCostInCents;
        this.startingHour = startingHour;
        this.startingMinute = startingMinute;
        this.endingHour = endingHour;
        this.endingMinute = endingMinute;
        this.foundations = foundations;
    }

    public void setCost(AmountOfMoney cost) {
        this.cost = cost;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotalCostInCents() {
        return totalCostInCents;
    }

    public int getStartingHour() {
        return startingHour;
    }

    public int getStartingMinute() {
        return startingMinute;
    }

    public int getEndingHour() {
        return endingHour;
    }

    public int getEndingMinute() {
        return endingMinute;
    }

    public Collection<Foundation> getFoundations() {
        return foundations;
    }

    public String getCost() {
        return cost.toString();
    }
}
