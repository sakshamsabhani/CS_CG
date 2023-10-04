package com.CaseStudy.incomereportservice.Service;

import com.CaseStudy.incomereportservice.Model.IncomeReport;

import java.util.List;

public interface IncomeReportService {
    IncomeReport calculateIncome();

    IncomeReport getIncomeReport(String month);

    List<IncomeReport> getAllIncomeReports();
}
