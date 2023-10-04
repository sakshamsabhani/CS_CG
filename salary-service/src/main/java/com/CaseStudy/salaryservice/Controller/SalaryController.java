package com.CaseStudy.salaryservice.Controller;

import com.CaseStudy.salaryservice.Model.Salary;
import com.CaseStudy.salaryservice.Service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalaryController {

    @Autowired
    SalaryService service;

    @PostMapping("/salary/add")
    void addSalary(@RequestBody Salary salary) {
        service.addSalary(salary);
    }

    @GetMapping("/salary/get/{position}")
    Salary getSalary(@PathVariable String position) {
        return service.getSalary(position);
    }

    @PutMapping("/salary/update")
    void updateSalary(@RequestBody Salary salary) {
        service.updateSalary(salary);
    }

    @DeleteMapping("/salary/delete/{position}")
    void deleteSalary(@PathVariable String position) {
        service.deleteSalary(position);
    }
}
