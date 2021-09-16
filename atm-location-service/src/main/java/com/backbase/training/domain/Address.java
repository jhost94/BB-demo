package com.backbase.training.domain;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "nameOrNumber")
    private String nameOrNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "town")
    private String town;

    @Column(name = "country")
    private String country;

    @Column(name = "postCode")
    private String postCode;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOrNumber() {
        return nameOrNumber;
    }

    public void setNameOrNumber(String nameOrNumber) {
        this.nameOrNumber = nameOrNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
