package com.CaseStudy.rateservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String rateId;

    private BigDecimal amount;
    private String roomType;
    private LocalDate bookingDate;
    private LocalDate checkInDate;

    public Rate(BigDecimal amount, String roomType, LocalDate bookingDate, LocalDate checkInDate) {
        this.amount = amount;
        this.roomType = roomType;
        this.bookingDate = bookingDate;
        this.checkInDate = checkInDate;
    }
}
