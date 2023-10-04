package com.CaseStudy.incomereportservice.Proxy;

import com.CaseStudy.incomereportservice.Model.Rate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@FeignClient(name = "rate-service")
public interface RateProxy {

    @GetMapping("/rate/get/{bookingDate}/{checkInDate}/{roomType}")
    Rate getRoomRate(@PathVariable LocalDate bookingDate, @PathVariable LocalDate checkInDate, @PathVariable String roomType);
}
