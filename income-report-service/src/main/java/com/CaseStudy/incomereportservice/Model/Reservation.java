package com.CaseStudy.incomereportservice.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
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