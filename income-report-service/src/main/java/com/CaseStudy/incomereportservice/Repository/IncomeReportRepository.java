package com.CaseStudy.incomereportservice.Repository;

import com.CaseStudy.incomereportservice.Model.IncomeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeReportRepository extends JpaRepository<IncomeReport, String> {
    IncomeReport findByMonth(String month);
}
