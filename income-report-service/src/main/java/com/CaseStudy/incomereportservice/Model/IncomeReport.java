package com.CaseStudy.incomereportservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class IncomeReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String month;
    private Date generationDate;
    private int totalBookings;
    private BigDecimal revenue;
    private BigDecimal totalCost;
    private BigDecimal netProfit;

}
