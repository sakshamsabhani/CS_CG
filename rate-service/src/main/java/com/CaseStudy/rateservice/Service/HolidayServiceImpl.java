package com.CaseStudy.rateservice.Service;

import com.CaseStudy.rateservice.Model.Holiday;
import com.CaseStudy.rateservice.Repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService{

    @Autowired
    public HolidayRepository holidayRepository;

    @Override
    public void addHoliday(LocalDate date) {
        Holiday holiday = new Holiday(date);
        holidayRepository.save(holiday);
    }


    @Override
    public List<Holiday> getHolidays() {
        return holidayRepository.findAll();
    }


    @Override
    public void updateHoliday(LocalDate date) {
        Holiday holiday = holidayRepository.findByDate(date);
        if(holiday == null) {
            throw new RuntimeException("No Holiday found on " + date);
        }
        else {
            holidayRepository.delete(holiday);
            holiday.setDate(date);
            holidayRepository.save(holiday);
        }
    }

    @Override
    public void deleteHoliday(LocalDate date) {
        Holiday holiday = holidayRepository.findByDate(date);
        if (holiday != null) {
            holidayRepository.delete(holiday);
        }
        else {
            throw new RuntimeException("No Holiday found on " + date);
        }
    }

}
