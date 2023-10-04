package com.CaseStudy.reservationservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Guest {

    private int guestId;

    private String guestName;
    private String email;
    private String phoneNumber;
    private String address;
    private int roomNumber;

    public Guest(String guestName, String email, String phoneNumber, String address, int roomNumber) {
        this.guestName = guestName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.roomNumber = roomNumber;
    }
}