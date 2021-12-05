package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingDto;
import com.bridgelabz.greetingapp.entity.GreetingEntity;
import com.bridgelabz.greetingapp.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepo greetingRepo;

    public GreetingEntity addMessage(GreetingDto greetingDto) {
        GreetingEntity greetingEntity = new GreetingEntity();
        greetingEntity.setMessage(greetingDto.getMessage());
        return greetingRepo.save(greetingEntity);
    }
}
