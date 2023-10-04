package com.CaseStudy.guestservice.Controller;

import com.CaseStudy.guestservice.Repository.GuestSpringDataJpaRepository;
import com.CaseStudy.guestservice.GuestTemplate.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GuestController {

    @Autowired
    private GuestSpringDataJpaRepository repository;

    @GetMapping("/guests/find/{id}")
    public Optional<Guest> getGuest(@PathVariable int id) {
        return repository.findById(id);
    }

    @GetMapping("/guests/findAll")
    public List<Guest> getAllGuests() {
        return repository.findAll();
    }

    @PostMapping("/guests/add")
    public void addGuest(@RequestBody Guest guest) {
        repository.save(guest);
    }

    @PostMapping("/guests/update")
    public void updateGuest(@RequestBody Guest guest) {
        repository.save(guest);
    }

    @DeleteMapping("/guests/delete/{id}")
    public void deleteGuest(@PathVariable int id) {
        repository.deleteById(id);
    }
    
}
