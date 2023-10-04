package com.CaseStudy.staffservice.Repository;

import com.CaseStudy.staffservice.Staff.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {

    Staff findStaffByStaffId(String staffId);
    List<Staff> findStaffByExperience(int experience);
}
