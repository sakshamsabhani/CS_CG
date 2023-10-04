package com.CaseStudy.rateservice.Repository;

import com.CaseStudy.rateservice.Model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
    Holiday findByDate(LocalDate date);
}
