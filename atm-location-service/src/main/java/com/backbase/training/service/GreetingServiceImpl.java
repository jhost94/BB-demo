package com.backbase.training.service;

import com.backbase.training.domain.Greeting;
import com.backbase.training.repository.GreetingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingServiceImpl implements GreetingService{

    @Autowired
    private GreetingsRepository greetingsRepository;

    @Override
    public List<Greeting> getGreetings() {
        return greetingsRepository.findAll();
    }

    @Override
    public Greeting getGreetingById(String id) {
        return greetingsRepository.findById(id).get();
    }

    @Override
    public void addNewGreeting(Greeting greeting) {
        greetingsRepository.save(greeting);
    }
}
