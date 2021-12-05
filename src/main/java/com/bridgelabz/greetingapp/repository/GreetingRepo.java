package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingapp.entity.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface GreetingRepo extends JpaRepository<GreetingEntity, Integer> {
}
