package com.backbase.training.service;

import com.backbase.training.domain.Address;
import com.backbase.training.domain.Coordinate;
import com.backbase.training.domain.Location;
import com.backbase.training.model.RawLocation;
import com.backbase.training.repository.AddressRepository;
import com.backbase.training.repository.CoordinatesRepository;
import com.backbase.training.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocationsServiceImpl implements LocationsService{

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CoordinatesRepository coordinatesRepository;


    @Override
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocation(String id) {
        return locationRepository.findById(id).orElseThrow();
    }

    @Override
    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void addRawLocation(RawLocation rawLocation){
        Address address = new Address();
        //address.setNameOrNumber(rawLocation.getAddress().getNameOrNumber());
        address.setPostCode(rawLocation.getAddress().getPostCode());
        address.setStreet(rawLocation.getAddress().getStreet());
        address.setTown(rawLocation.getAddress().getTown());
        address.setCountry(rawLocation.getAddress().getCountry());
        // THIS IS A CRIME
        address.setId(UUID.randomUUID().toString());
        addressRepository.save(address);


        Coordinate coordinate = new Coordinate();
        coordinate.setLatitude(rawLocation.getCoordinate().getLatitude());
        coordinate.setLongitude(rawLocation.getCoordinate().getLongitude());
        coordinate.setId(UUID.randomUUID().toString());
        coordinatesRepository.save(coordinate);

        Location location = new Location();
        location.setId(rawLocation.getId());
        location.setName(rawLocation.getName());
        location.setType(rawLocation.getType());
        location.setAddress(address);
        location.setCoordinate(coordinate);

        this.addLocation(location);
    }

    @Override
    public void addLocations(RawLocation.RawLocationList rawLocationList) {
        rawLocationList.getLocations().forEach(this::addRawLocation);
    }


}
