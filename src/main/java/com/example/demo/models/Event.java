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
    private double totalCost;

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

    public Event(String title, LocalDate date, double totalCost) {
        this.title = title;
        this.date = date;
        this.totalCost = totalCost;
    }

    public Event(String title, LocalDate date, double totalCost, int startingHour, int startingMinute, int endingHour, int endingMinute) {
        this.title = title;
        this.date = date;
        this.totalCost = totalCost;
        this.startingHour = startingHour;
        this.startingMinute = startingMinute;
        this.endingHour = endingHour;
        this.endingMinute = endingMinute;
    }

    public Event(String title, LocalDate date, double totalCost, int startingHour, int startingMinute, int endingHour, int endingMinute, Collection<Foundation> foundations) {
        this.title = title;
        this.date = date;
        this.totalCost = totalCost;
        this.startingHour = startingHour;
        this.startingMinute = startingMinute;
        this.endingHour = endingHour;
        this.endingMinute = endingMinute;
        this.foundations = foundations;
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

    public double getTotalCost() {
        return totalCost;
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
}
