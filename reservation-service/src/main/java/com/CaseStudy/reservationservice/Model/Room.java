package com.CaseStudy.reservationservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Room {

    private String id;
    private int roomNumber;
    private String roomType;
    private int occupancy;
    private boolean availability;

    private static final Map<String, Integer> roomTypes = Map.of("Deluxe", 2, "Twin", 2, "Executive", 3, "Suite", 4, "Presidential Suite", 5);
}