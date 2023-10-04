package com.CaseStudy.staffservice.Service;

import com.CaseStudy.staffservice.Staff.Staff;

import java.util.List;

public interface StaffService {

    Staff getStaff(String staffId);

    List<Staff> getAllStaff();

    List<Staff> getStaffByExperience(int experience);

    void addStaff(Staff staff);

    void updateStaff(String staffId, Staff staff);

    void deleteStaff(String staffId);
}
