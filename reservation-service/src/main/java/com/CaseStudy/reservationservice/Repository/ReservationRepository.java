package com.CaseStudy.reservationservice.Repository;

import com.CaseStudy.reservationservice.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    Reservation findByBookingId(String bookingId);
    Reservation findByGuestId(int guestId);
    Reservation findByRoomNumber(int roomNumber);

}
