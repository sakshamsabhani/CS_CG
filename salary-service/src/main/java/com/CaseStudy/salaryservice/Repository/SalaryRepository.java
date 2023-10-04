package com.CaseStudy.salaryservice.Repository;

import com.CaseStudy.salaryservice.Model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {

    Salary findById(int id);
    Salary findByPosition(String position);
}
