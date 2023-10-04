package com.CaseStudy.incomereportservice.Controller;

import com.CaseStudy.incomereportservice.Model.IncomeReport;
import com.CaseStudy.incomereportservice.Service.IncomeReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IncomeReportController {

    @Autowired
    IncomeReportServiceImpl service;

    @GetMapping("/report/income/{month}")
    IncomeReport getIncomeReport(@PathVariable String month) {
        return service.getIncomeReport(month);
    }

    @GetMapping("/report/income/all")
    List<IncomeReport> getAllIncomeReports() {
        return service.getAllIncomeReports();
    }
}
