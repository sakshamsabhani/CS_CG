package com.CaseStudy.reportingservice.Repository;

import com.CaseStudy.reportingservice.Model.PayrollReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollReportRepository extends JpaRepository<PayrollReport, String> {

    PayrollReport findByStaffId(String staffId);

}
