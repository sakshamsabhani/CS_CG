package com.CaseStudy.roomservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private int roomNumber;
    private String roomType;
    private int occupancy;
    private boolean availability;

    private static final Map<String, Integer> roomTypes = Map.of("Deluxe", 2, "Twin", 2, "Executive", 3, "Suite", 4, "Presidential Suite", 5);

    public Room(int roomNumber, String roomType, boolean availability) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.occupancy = roomTypes.get(roomType);
        this.availability = availability;
    }
}
