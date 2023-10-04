package com.CaseStudy.billingservice.Service;

import com.CaseStudy.billingservice.Model.Bill;

import java.math.BigDecimal;

public interface BillService {

    public Bill generateBill(String bookingId);

    public BigDecimal calculateBill(BigDecimal amount, BigDecimal taxes);

    public BigDecimal calculateTaxes(BigDecimal amount);
}
