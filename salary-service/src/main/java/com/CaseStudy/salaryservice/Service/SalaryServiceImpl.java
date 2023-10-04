package com.CaseStudy.salaryservice.Service;

import com.CaseStudy.salaryservice.Model.Salary;
import com.CaseStudy.salaryservice.Repository.SalaryRepository;
import com.CaseStudy.salaryservice.Service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    SalaryRepository repository;

    @Override
    public void addSalary(Salary salary) {
        repository.save(salary);
    }

    @Override
    public Salary getSalary(String position) {
        return repository.findByPosition(position);
    }

    @Override
    public void updateSalary(Salary salary) {
        repository.delete(repository.findById(salary.getId()));
        repository.save(salary);

    }

    @Override
    public void deleteSalary(String position) {
        repository.delete(repository.findByPosition(position));
    }
}
