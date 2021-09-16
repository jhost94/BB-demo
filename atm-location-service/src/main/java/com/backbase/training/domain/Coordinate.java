package com.backbase.training.domain;

import javax.persistence.*;

@Entity
@Table(name = "coordinates")
public class Coordinate {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
