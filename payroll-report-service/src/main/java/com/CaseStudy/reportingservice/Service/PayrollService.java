package com.CaseStudy.reportingservice.Service;

import com.CaseStudy.reportingservice.Model.PayrollReport;

import java.math.BigDecimal;

public interface PayrollService {
    PayrollReport retrievePayrollReport(String staffId);
    void addPayrollReport(String staffId);
    BigDecimal calculatePayroll(String staffId);
    BigDecimal getTotalPayroll();
}
