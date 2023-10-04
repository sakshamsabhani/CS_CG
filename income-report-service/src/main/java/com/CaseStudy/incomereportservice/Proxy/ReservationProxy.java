package com.CaseStudy.incomereportservice.Proxy;

import com.CaseStudy.incomereportservice.Model.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "reservation-service")
public interface ReservationProxy {

    @GetMapping("/reservations/getByBookingId/{bookingId}")
    public Reservation getReservation(@PathVariable String bookingId);

    @GetMapping("/reservations/getRoomType/{bookingId}")
    public String getRoomTypeByBookingId(@PathVariable String bookingId);

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations();

}
