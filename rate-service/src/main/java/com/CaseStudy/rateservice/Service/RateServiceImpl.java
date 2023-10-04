package com.CaseStudy.rateservice.Service;

import com.CaseStudy.rateservice.Model.Rate;
import com.CaseStudy.rateservice.Repository.HolidayRepository;
import com.CaseStudy.rateservice.Repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class RateServiceImpl implements RateService{

    @Autowired
    RateRepository repository;
    
    @Autowired
    HolidayRepository holidayRepository;

    @Override
    public void setRoomRate(BigDecimal amount, String roomType) {
        Rate rate = repository.findByRoomType(roomType);
        if(rate != null) {
            repository.delete(rate);
            rate.setAmount(amount);
            rate.setRoomType(roomType);
            repository.save(rate);
        }
        else {
            Rate rateObj = new Rate(amount, roomType, null, null);
            repository.save(rateObj);
        }
    }

    @Override
    public Rate getRoomRate(LocalDate bookingDate, LocalDate checkInDate, String roomType) {
        Rate rate = repository.findByRoomType(roomType);
        BigDecimal amount = rate.getAmount();
        
        long daysDifference = ChronoUnit.DAYS.between(bookingDate, checkInDate);
        
        if(daysDifference == 0) {
            amount = amount.multiply(BigDecimal.valueOf(1.25));
        }
        else if(daysDifference <= 7) {
            amount = amount.multiply(BigDecimal.valueOf(1.15));
        }
        else if(daysDifference <= 15) {
            amount = amount.multiply(BigDecimal.valueOf(1.10));
        }
        else if(daysDifference <= 30) {
            amount = amount.multiply(BigDecimal.valueOf(1.05));
        }
        
        if(holidayRepository.findByDate(checkInDate) != null) {
            amount = amount.multiply(BigDecimal.valueOf(1.10));
        }

        rate.setBookingDate(bookingDate);
        rate.setRoomType(roomType);
        rate.setCheckInDate(checkInDate);
        rate.setAmount(amount);
        return rate;
    }

    public static long daysDifference(Date bookingDate, Date checkInDate) {

        long differenceInDays, differenceInMillis;
        differenceInMillis = checkInDate.getTime() - bookingDate.getTime();
        differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInMillis);

        return differenceInDays;
    }
    
}
