package com.CaseStudy.reportingservice.Proxy;

import com.CaseStudy.reportingservice.Model.Staff;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "staff-service")
public interface StaffProxy {

    @GetMapping("/staff/get")
    public Staff getStaff(String staffId);

    @GetMapping("/staff/getAll")
    public List<Staff> getAllStaff();
}
