package com.CaseStudy.salaryservice.Service;

import com.CaseStudy.salaryservice.Model.Salary;

public interface SalaryService {
    void addSalary(Salary salary);

    Salary getSalary(String position);

    void updateSalary(Salary salary);

    void deleteSalary(String position);
}
