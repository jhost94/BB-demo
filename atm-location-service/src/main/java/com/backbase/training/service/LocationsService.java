package com.backbase.training.service;

import com.backbase.training.domain.Location;
import com.backbase.training.model.RawLocation;

import java.util.List;

public interface LocationsService {

    List<Location> getLocations();
    Location getLocation(String id);
    void addLocation(Location location);
    void addRawLocation(RawLocation rawLocation);
    void addLocations(RawLocation.RawLocationList rawLocationList);
}
