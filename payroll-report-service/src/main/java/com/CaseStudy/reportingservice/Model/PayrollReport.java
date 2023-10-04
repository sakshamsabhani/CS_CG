package com.CaseStudy.reportingservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PayrollReport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String staffId;
    private String monthName;
    private BigDecimal payroll;
    private Date generationDate;

}
