package com.CaseStudy.rateservice.Controller;

import com.CaseStudy.rateservice.Model.Rate;
import com.CaseStudy.rateservice.Service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class RateController {

    @Autowired
    RateService service;

    @GetMapping("/rate/get/{bookingDate}/{checkInDate}/{roomType}")
    Rate getRoomRate(@PathVariable LocalDate bookingDate, @PathVariable LocalDate checkInDate, @PathVariable String roomType){
        return service.getRoomRate(bookingDate, checkInDate, roomType);
    }

    @PostMapping("/rate/set/{amount}/{roomType}")
    void setRoomRate(@PathVariable BigDecimal amount, @PathVariable String roomType){
        service.setRoomRate(amount, roomType);
    }

}
