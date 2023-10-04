package com.CaseStudy.guestservice.CML;

import com.CaseStudy.guestservice.Model.Guest;
import com.CaseStudy.guestservice.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GuestCommandLineRunner implements CommandLineRunner {

    @Autowired
    GuestRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Guest("Saksham", "sabhanisaksham@gmail.com", "9090808099", "Stark Tower", 403));
        repository.save(new Guest("Tony Stark", "tony@starkindustries.com", "9090808099", "Stark Tower", 402));
        repository.save(new Guest("Bruce Wayne", "bruce@wayneindustries.com", "9999888899", "Wayne Mansion", 504));
        repository.save(new Guest("Albus Dumbledore", "dumbledore@hogwarts.com", "0000000000", "Hogwarts", 301));

//        System.out.println(repository.findById("1"));

    }
}
