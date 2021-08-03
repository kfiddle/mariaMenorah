package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Payee {

    @Id
    @GeneratedValue
    private Long id;

    private String lastName;
    private String firstName;

    private String phoneNumber;
    private String email;
    private String streetNumber;

    private String street;
    private String apartmentNumber;
    private String city;
    private String zip;

    private boolean w9ed;

    @JsonIgnore
    @ManyToMany(mappedBy = "payees")
    private Collection<Event> events;

    @OneToOne
    private BudgetItem budgetItem;


    public Payee() {
    }

    public Payee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Payee(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Payee(String firstName, String lastName, String phoneNumber, String email, String streetNumber,
                 String street, String apartmentNumber, String city, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.streetNumber = streetNumber;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.zip = zip;
    }

    public void setEvent(Event eventToAdd) {
        events.add(eventToAdd);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public boolean isW9ed() {
        return w9ed;
    }

    public Collection<Event> getEvents() {
        return events;
    }

    public BudgetItem getBudgetItem() {
        return budgetItem;
    }


}
