package com.CaseStudy.billingservice.Proxy;

import com.CaseStudy.billingservice.Model.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "reservation-service")
public interface ReservationProxy {

    @GetMapping("/reservations/getByBookingId/{bookingId}")
    public Reservation getReservation(@PathVariable String bookingId);

    @GetMapping("/reservations/getRoomType/{bookingId}")
    public String getRoomTypeByBookingId(@PathVariable String bookingId);

}
