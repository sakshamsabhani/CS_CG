package com.CaseStudy.guestservice.CML;

import com.CaseStudy.guestservice.GuestTemplate.Guest;
import com.CaseStudy.guestservice.Repository.GuestSpringDataJpaRepository;
import com.CaseStudy.guestservice.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GuestCommandLineRunner implements CommandLineRunner {

    @Autowired
    GuestSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Guest("Tony Stark", "tony@starkindustries.com", "9090808099", 101, new Date(), new Date()));
        repository.save(new Guest("Bruce Wayne", "bruce@wayneindustries.com", "9999888899", 102, new Date(), new Date()));
        repository.save(new Guest("Albus Dumbledore", "dumbledore@hogwarts.com", "0000000000", 934, new Date(), new Date()));

        System.out.println(repository.findById(1));

    }
}
