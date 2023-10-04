package com.CaseStudy.reportingservice.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Salary {
    private int id;

    private String position;
    private BigDecimal salary;

    public Salary(String position, BigDecimal salary) {
        this.position = position;
        this.salary = salary;
    }
}
