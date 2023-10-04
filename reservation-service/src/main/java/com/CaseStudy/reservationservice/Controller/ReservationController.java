package com.CaseStudy.reservationservice.Controller;

import com.CaseStudy.reservationservice.Model.Reservation;
import com.CaseStudy.reservationservice.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    ReservationService service;

    @GetMapping("/reservations/getByBookingId/{bookingId}")
    public Reservation getReservation(@PathVariable String bookingId) {
        return service.getReservation(bookingId);
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return service.getAllReservations();
    }


    @GetMapping("/reservations/getByGuestId/{guestId}")
    public Reservation getReservationByUserId(@PathVariable int guestId) {
        return service.getReservationByGuestId(guestId);
    }

    @GetMapping("/reservations/{roomNumber}")
    public Reservation getReservationByRoomNumber(@PathVariable int roomNumber) {
        return service.getReservationByRoomNumber(roomNumber);
    }

    @GetMapping("/reservations/getRoomType/{bookingId}")
    public String getRoomTypeByBookingId(@PathVariable String bookingId) {
        return service.getRoomTypeByBookingId(bookingId);
    }


    @PostMapping("/reservations/book")
    public void reserveRoom(@RequestBody Reservation reservation) {
        service.reserveRoom(reservation);
    }

    @PutMapping("/reservations/update")
    public void updateReservation(@RequestBody Reservation reservation) {
        service.updateReservation(reservation);
    }

    @DeleteMapping("/reservations/delete/{roomNumber}")
    public void cancelReservation(@PathVariable int roomNumber) {
        service.cancelReservation(roomNumber);
    }
}
