package com.backbase.training;

import com.backbase.training.domain.Greeting;
import com.backbase.training.mappers.GreetingsMapper;
import com.backbase.training.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ExampleController  {

    @Autowired
    private GreetingService greetingService;

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

//    @RequestMapping(method = RequestMethod.GET, value = "/locations")
//    @ResponseStatus(HttpStatus.OK)
//    public String getLocations(){
//
//    }
}