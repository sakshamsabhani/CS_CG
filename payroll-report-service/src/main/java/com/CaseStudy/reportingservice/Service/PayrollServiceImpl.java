package com.CaseStudy.reportingservice.Service;

import com.CaseStudy.reportingservice.Model.PayrollReport;
import com.CaseStudy.reportingservice.Model.Salary;
import com.CaseStudy.reportingservice.Model.Staff;
import com.CaseStudy.reportingservice.Repository.PayrollReportRepository;
import com.CaseStudy.reportingservice.Proxy.SalaryProxy;
import com.CaseStudy.reportingservice.Proxy.StaffProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    PayrollReportRepository repository;

    @Autowired
    StaffProxy staffProxy;

    @Autowired
    SalaryProxy salaryProxy;

    public final double increment = 2.5;

    @Override
    public PayrollReport retrievePayrollReport(String staffId) {
        PayrollReport payrollReport = repository.findByStaffId(staffId);

        if(payrollReport == null) {
            throw new RuntimeException("No Payroll Report for Staff ID " + staffId + " found.");
        }

        return payrollReport;
    }

    @Override
    public void addPayrollReport(String staffId) {
        PayrollReport payrollReport = new PayrollReport();

        payrollReport.setStaffId(staffId);

        Date generationDate = new Date();
        payrollReport.setGenerationDate(generationDate);

        String month = extractMonthFromDate(generationDate);
        payrollReport.setMonthName(month);

        payrollReport.setPayroll(calculatePayroll(staffId));

        repository.save(payrollReport);

    }


    @Override
    public BigDecimal calculatePayroll(String staffId) {
        Staff staff = staffProxy.getStaff(staffId);
        int experience = staff.getExperience();
        Salary salary = salaryProxy.getSalary(staff.getPosition());

        BigDecimal payroll = salary.getSalary().add(BigDecimal.valueOf(experience * increment / 100.0).multiply(salary.getSalary()));

        return payroll;
    }

    @Override
    public BigDecimal getTotalPayroll() {

        List<Staff> staffList = staffProxy.getAllStaff();

        BigDecimal totalPayroll = BigDecimal.valueOf(0);

        for (Staff staff : staffList) {
            totalPayroll = totalPayroll.add(calculatePayroll(staff.getStaffId()));
        }

        return totalPayroll;
    }


    public String extractMonthFromDate(Date date) {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        return monthFormat.format(date);
    }
}
