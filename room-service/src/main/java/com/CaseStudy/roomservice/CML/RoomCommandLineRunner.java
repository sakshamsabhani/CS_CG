package com.CaseStudy.roomservice.CML;

import com.CaseStudy.roomservice.Model.Room;
import com.CaseStudy.roomservice.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoomCommandLineRunner implements CommandLineRunner {

    @Autowired
    RoomRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        repository.save(new Room(101, "Deluxe", true));
        repository.save(new Room(102, "Deluxe", true));
        repository.save(new Room(103, "Deluxe", true));
        repository.save(new Room(104, "Deluxe", true));
        repository.save(new Room(105, "Deluxe", true));
        repository.save(new Room(111, "Twin", true));
        repository.save(new Room(112, "Twin", true));
        repository.save(new Room(113, "Twin", true));
        repository.save(new Room(114, "Twin", true));
        repository.save(new Room(115, "Twin", true));
        repository.save(new Room(201, "Deluxe", true));
        repository.save(new Room(202, "Deluxe", true));
        repository.save(new Room(203, "Deluxe", true));
        repository.save(new Room(204, "Deluxe", true));
        repository.save(new Room(205, "Deluxe", true));
        repository.save(new Room(301, "Executive", true));
        repository.save(new Room(302, "Executive", true));
        repository.save(new Room(303, "Executive", true));
        repository.save(new Room(304, "Executive", true));
        repository.save(new Room(305, "Executive", true));
        repository.save(new Room(401, "Suite", true));
        repository.save(new Room(402, "Suite", true));
        repository.save(new Room(403, "Suite", true));
        repository.save(new Room(404, "Suite", true));
        repository.save(new Room(405, "Suite", true));
        repository.save(new Room(501, "Presidential Suite", true));
        repository.save(new Room(502, "Presidential Suite", true));
        repository.save(new Room(503, "Presidential Suite", true));
        repository.save(new Room(504, "Presidential Suite", true));
        repository.save(new Room(505, "Presidential Suite", true));
    }
}
