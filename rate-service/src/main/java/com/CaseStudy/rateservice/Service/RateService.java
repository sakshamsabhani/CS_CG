package com.CaseStudy.rateservice.Service;

import com.CaseStudy.rateservice.Model.Rate;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface RateService {

    void setRoomRate(BigDecimal amount, String roomType);
    Rate getRoomRate(LocalDate bookingDate, LocalDate checkInDate, String roomType);
}
