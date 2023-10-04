package com.CaseStudy.reportingservice.Proxy;

import com.CaseStudy.reportingservice.Model.Salary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "salary-service")
public interface SalaryProxy {

    @GetMapping("/salary/get/{position}")
    Salary getSalary(@PathVariable String position);
}
