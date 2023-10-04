package com.CaseStudy.rateservice.Service;

import com.CaseStudy.rateservice.Model.Holiday;

import java.time.LocalDate;
import java.util.List;

public interface HolidayService{
    public void addHoliday(LocalDate date);
    public List<Holiday> getHolidays();
    public void updateHoliday(LocalDate date);
    public void deleteHoliday(LocalDate date);

}
