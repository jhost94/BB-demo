package com.backbase.training.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawLocation {

    @JsonProperty("id")
    @NotNull
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("address")
    private Address address;

    @JsonProperty("coordinates")
    private Coordinate coordinate;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RawLocationList {

        @JsonProperty("locations")
        private List<RawLocation> locations;

        public List<RawLocation> getLocations() {
            return locations;
        }

        public void setLocations(List<RawLocation> locations) {
            this.locations = locations;
        }
    }
}
