package com.CaseStudy.reportingservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Staff {

    private String staffId;
    private String name;
    private String position;
    private int experience;
    private String emailId;
    private String phoneNumber;
}
