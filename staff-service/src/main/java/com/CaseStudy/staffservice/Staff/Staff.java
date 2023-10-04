package com.CaseStudy.staffservice.Staff;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String staffId;

    private String name;
    private String position;
    private int experience;
    private String emailId;
    private String phoneNumber;
}
