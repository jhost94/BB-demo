package com.backbase.training.domain;

import javax.persistence.*;

@Entity
@Table(name = "coordinates")
public class Coordinate {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
