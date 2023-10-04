package com.CaseStudy.guestservice.Model;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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