package com.CaseStudy.rateservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private LocalDate date;

    public Holiday(LocalDate date) {
        this.date = date;
    }
}
