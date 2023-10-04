package com.CaseStudy.salaryservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String position;
    private BigDecimal salary;

    public Salary(String  position, BigDecimal salary) {
        this.position = position;
        this.salary = salary;
    }
}
