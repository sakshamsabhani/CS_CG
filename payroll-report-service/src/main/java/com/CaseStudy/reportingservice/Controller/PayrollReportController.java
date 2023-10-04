package com.CaseStudy.reportingservice.Controller;

import com.CaseStudy.reportingservice.Model.PayrollReport;
import com.CaseStudy.reportingservice.Service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PayrollReportController {

    @Autowired
    PayrollService service;

    @GetMapping("/report/payroll/get/{staffId}")
    public PayrollReport retrievePayroll(String staffId) {
        return service.retrievePayrollReport(staffId);
    }

    @PostMapping("/report/payroll/add/{staffId}")
    public void addPayrollReport(String staffId) {
        service.addPayrollReport(staffId);
    }

    @GetMapping("/report/payroll/get/total")
    public BigDecimal getTotalPayroll() {
        return service.getTotalPayroll();
    }
}
