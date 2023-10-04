package com.CaseStudy.staffservice.Service;

import com.CaseStudy.staffservice.Repository.StaffRepository;
import com.CaseStudy.staffservice.Service.StaffService;
import com.CaseStudy.staffservice.Staff.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository repository;


    @Override
    public Staff getStaff(String staffId) {
        return repository.findStaffByStaffId(staffId);
    }

    @Override
    public List<Staff> getAllStaff() {
        return repository.findAll();
    }

    @Override
    public List<Staff> getStaffByExperience(int experience) {
        return repository.findStaffByExperience(experience);
    }

    @Override
    public void addStaff(Staff staff) {
        repository.save(staff);
    }

    @Override
    public void updateStaff(String staffId, Staff staff) {
        repository.deleteById(staffId);
        repository.save(staff);
    }

    @Override
    public void deleteStaff(String staffId) {
        repository.deleteById(staffId);
    }
}
