package com.CaseStudy.billingservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String billId;

    private String bookingId;
    private BigDecimal amount;
    private BigDecimal taxes;
    private BigDecimal total;

}
