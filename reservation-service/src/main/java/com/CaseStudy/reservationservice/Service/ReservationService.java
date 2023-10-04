package com.CaseStudy.reservationservice.Service;

import com.CaseStudy.reservationservice.Model.Reservation;

import java.util.List;

public interface ReservationService {
    String reserveRoom(Reservation reservation);
    Reservation getReservation(String bookingId);
    Reservation getReservationByGuestId(int guestId);
    Reservation getReservationByRoomNumber(int roomNumber);

    String getRoomTypeByBookingId(String bookingId) ;

    void updateReservation(Reservation reservation);
    void cancelReservation(int roomNumber);

    List<Reservation> getAllReservations();
}
