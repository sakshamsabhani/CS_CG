package com.CaseStudy.billingservice.Service;

import com.CaseStudy.billingservice.Repository.BillRepository;
import com.CaseStudy.billingservice.Model.Bill;
import com.CaseStudy.billingservice.Model.Rate;
import com.CaseStudy.billingservice.Model.Reservation;
import com.CaseStudy.billingservice.Proxy.RateProxy;
import com.CaseStudy.billingservice.Proxy.ReservationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BillServiceImpl implements BillService{

    @Autowired
    BillRepository repository;

    @Autowired
    ReservationProxy reservationProxy;

    @Autowired
    RateProxy rateProxy;

    @Override
    public Bill generateBill(String bookingId) {
        BigDecimal amount, taxes, total;

        Bill bill = repository.findByBookingId(bookingId);
        Reservation reservation = reservationProxy.getReservation(bookingId);
        Rate rate = rateProxy.getRoomRate(reservation.getBookingDate(), reservation.getCheckInDate(), reservationProxy.getRoomTypeByBookingId(bookingId));

        amount = rate.getAmount();
        bill.setAmount(amount);

        taxes = calculateTaxes(amount);
        bill.setTaxes(taxes);

        total = calculateBill(amount, taxes);
        bill.setTotal(total);

        return bill;
    }

    @Override
    public BigDecimal calculateBill(BigDecimal amount, BigDecimal taxes) {
        return amount.add(taxes);

    }

    @Override
    public BigDecimal calculateTaxes(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(1.18));
    }
}