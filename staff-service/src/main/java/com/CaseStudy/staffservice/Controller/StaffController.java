package com.CaseStudy.staffservice.Controller;

import com.CaseStudy.staffservice.Staff.Staff;
import com.CaseStudy.staffservice.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController {

    @Autowired
    StaffService service;

    @GetMapping("/staff/get")
    public Staff getStaff(String staffId) {
        return service.getStaff(staffId);
    }

    @GetMapping("/staff/getAll")
    public List<Staff> getAllStaff() {
        return service.getAllStaff();
    }

    @PostMapping("/staff/add")
    public void addStaff(Staff staff) {
        service.addStaff(staff);
    }

    @PutMapping("/staff/update")
    public void updateStaff(String staffId, Staff staff) {
        service.updateStaff(staffId, staff);
    }

    @DeleteMapping("/staff/delete")
    public void deleteStaff(String staffId) {
        service.deleteStaff(staffId);
    }
}