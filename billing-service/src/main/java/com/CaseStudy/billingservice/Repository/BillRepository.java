package com.CaseStudy.billingservice.Repository;

import com.CaseStudy.billingservice.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, String> {
    Bill findByBookingId(String bookingId);
}
