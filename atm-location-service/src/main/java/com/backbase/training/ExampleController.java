package com.backbase.training;

import com.backbase.training.domain.Greeting;
import com.backbase.training.domain.Location;
import com.backbase.training.mappers.GreetingsMapper;
import com.backbase.training.model.RawLocation;
import com.backbase.training.service.GreetingService;
import com.backbase.training.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ExampleController  {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private LocationsService locationsService;

    @RequestMapping(method = RequestMethod.GET, value = "/message", produces = {
                    "application/json"
    })
    @ResponseStatus(HttpStatus.OK)
    public Message getMessage() {
        return new Message("Hello World");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/messages", produces = {
            "application/json"
    })
    @ResponseStatus(HttpStatus.OK)
    public List<Message> getMessages() {
        List<Greeting> greetings = greetingService.getGreetings();
        return GreetingsMapper.INSTANCE.greetingsToMessages(greetings);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/message")
    @ResponseStatus(HttpStatus.CREATED)
    public String addMessage(@RequestBody Message message){
        Greeting greeting = GreetingsMapper.INSTANCE.messageToGreeting(message);
        String id = UUID.randomUUID().toString();
        greeting.setId(id);
        greetingService.addNewGreeting(greeting);
        return id;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/locations")
    @ResponseStatus(HttpStatus.OK)
    public List<Location> getLocations(){
        List<Location> locations = locationsService.getLocations();
        return locations;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/locations")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer addLocations(@RequestBody RawLocation.RawLocationList rawLocationList){
        locationsService.addLocations(rawLocationList);
        return rawLocationList.getLocations().size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/location/{id}", produces = {
            "application/json"
    })
    @ResponseStatus(HttpStatus.OK)
    public Location getLocationById(@PathVariable String id){
        return locationsService.getLocation(id);
    }
}