package com.CaseStudy.reservationservice.CML;


import com.CaseStudy.reservationservice.Model.Reservation;
import com.CaseStudy.reservationservice.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReservationCommandLineRunner implements CommandLineRunner {

    @Autowired
    ReservationRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Reservation(1, 101, LocalDate.of(2023, 9, 15), LocalDate.of(2023, 9, 15), LocalDate.of(2023, 9, 25)));
        repository.save(new Reservation(2, 203, LocalDate.of(2023, 9, 16), LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 26)));
        repository.save(new Reservation(3, 305, LocalDate.of(2023, 9, 17), LocalDate.of(2023, 9, 22), LocalDate.of(2023, 9, 27)));
        repository.save(new Reservation(4, 407, LocalDate.of(2023, 9, 18), LocalDate.of(2023, 9, 24), LocalDate.of(2023, 9, 28)));
        repository.save(new Reservation(5, 509, LocalDate.of(2023, 9, 19), LocalDate.of(2023, 9, 26), LocalDate.of(2023, 9, 29)));
        repository.save(new Reservation(6, 113, LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 28), LocalDate.of(2023, 9, 30)));
        repository.save(new Reservation(7, 303, LocalDate.of(2023, 9, 21), LocalDate.of(2023, 9, 30), LocalDate.of(2023, 10, 1)));
        repository.save(new Reservation(8, 406, LocalDate.of(2023, 9, 22), LocalDate.of(2023, 10, 2), LocalDate.of(2023, 10, 2)));
        repository.save(new Reservation(9, 502, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 10, 4), LocalDate.of(2023, 10, 3)));
        repository.save(new Reservation(10, 505, LocalDate.of(2023, 9, 24), LocalDate.of(2023, 10, 6), LocalDate.of(2023, 10, 4)));

    }
}
