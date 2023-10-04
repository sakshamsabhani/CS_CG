package com.CaseStudy.rateservice.Controller;

import com.CaseStudy.rateservice.Service.HolidayServiceImpl;
import com.CaseStudy.rateservice.Model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class HolidayController {

    @Autowired
    private static HolidayServiceImpl holidayService;

    @PostMapping("/holidays/add")
    public static void addHoliday(@RequestBody LocalDate date) {
        holidayService.addHoliday(date);
    }

    @GetMapping("/holidays/get")
    public static List<Holiday> getHolidays() {
        return holidayService.getHolidays();
    }

    @PutMapping("/holidays/update")
    public static void updateHoliday(@RequestBody LocalDate date) {
        holidayService.updateHoliday(date);
    }

    @DeleteMapping("/holidays/delete")
    public void deleteHoliday(@RequestBody LocalDate date) {
        holidayService.deleteHoliday(date);
    }
}
