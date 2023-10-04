package com.CaseStudy.incomereportservice.Service;

import com.CaseStudy.incomereportservice.Repository.IncomeReportRepository;
import com.CaseStudy.incomereportservice.Model.IncomeReport;
import com.CaseStudy.incomereportservice.Model.Rate;
import com.CaseStudy.incomereportservice.Model.Reservation;
import com.CaseStudy.incomereportservice.Proxy.RateProxy;
import com.CaseStudy.incomereportservice.Proxy.ReservationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class IncomeReportServiceImpl implements IncomeReportService{

    @Autowired
    ReservationProxy reservationProxy;

    @Autowired
    RateProxy rateProxy;

    @Autowired
    IncomeReportRepository repository;

        public static final Map<String, BigDecimal> roomTypePriceMap = Map.of("Deluxe", new BigDecimal("1000"), "Twin", new BigDecimal("1200"), "Executive", new BigDecimal("2500"), "Suite", new BigDecimal("5000"), "Presidential Suite", new BigDecimal("8000"));
    @Override
    public IncomeReport calculateIncome() {
        IncomeReport report = new IncomeReport();
        List<Reservation> reservationList = reservationProxy.getAllReservations();
        BigDecimal revenue = new BigDecimal("0");
        BigDecimal totalCost = new BigDecimal("0");
        BigDecimal netProfit;
        String roomType;
        BigDecimal roomPrice;
        BigDecimal roomCost;
        Rate rate;

        for (Reservation reservation : reservationList) {
            roomType = reservationProxy.getRoomTypeByBookingId(reservation.getBookingId());
            rate = rateProxy.getRoomRate(reservation.getBookingDate(), reservation.getCheckInDate(), roomType);
            roomPrice = rate.getAmount();
            roomCost = roomTypePriceMap.get(roomType);

            revenue = revenue.add(roomPrice);
            totalCost = totalCost.add(roomCost);
        }

        netProfit = revenue.subtract(totalCost);

        Date date = new Date();
        report.setGenerationDate(date);
        report.setMonth(extractMonthFromDate(date));

        report.setTotalBookings(reservationList.size());

        report.setRevenue(revenue);
        report.setTotalCost(totalCost);

        report.setNetProfit(netProfit);

        return repository.save(report);
    }

    @Override
    public IncomeReport getIncomeReport(String month) {
        return repository.findByMonth(month);
    }

    @Override
    public List<IncomeReport> getAllIncomeReports() {
        return repository.findAll();
    }

    public String extractMonthFromDate(Date date) {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        return monthFormat.format(date);
    }
}
