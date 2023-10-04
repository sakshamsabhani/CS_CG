package com.CaseStudy.reservationservice.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookingId;

    private int guestId;
    private int roomNumber;
    private LocalDate bookingDate;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Reservation(int guestId, int roomNumber, LocalDate bookingDate, LocalDate checkInDate, LocalDate checkOutDate) {
        this.guestId = guestId;
        this.roomNumber = roomNumber;
        this.bookingDate = bookingDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
}