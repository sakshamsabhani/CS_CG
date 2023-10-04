package com.CaseStudy.rateservice.Repository;

import com.CaseStudy.rateservice.Model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, String> {
    Rate findByRoomType(String roomType);
}
