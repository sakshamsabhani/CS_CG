package com.CaseStudy.guestservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Map;

public class Room {

    private Long id;
    private int roomNumber;
    private String roomType;
    private int occupancy;
    private boolean availability;

    private static final Map<String, Integer> roomTypes = Map.of("Deluxe", 2, "Twin", 2, "Executive", 3, "Suite", 4, "Presidential Suite", 5);

    public Room() {
    }

    public Room(int roomNumber, String roomType, boolean availability) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.occupancy = roomTypes.get(roomType);
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", occupancy=" + occupancy +
                ", availability=" + availability +
                '}';
    }
}
