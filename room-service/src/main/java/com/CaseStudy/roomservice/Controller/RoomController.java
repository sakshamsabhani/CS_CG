package com.CaseStudy.roomservice.Controller;

import com.CaseStudy.roomservice.Model.Guest;
import com.CaseStudy.roomservice.Model.Room;
import com.CaseStudy.roomservice.Proxy.GuestProxy;
import com.CaseStudy.roomservice.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomRepository repository;

    @Autowired
    GuestProxy proxy;

    @GetMapping("/rooms")
    public List<Room> retrieveAllRooms() {
        List<Room> rooms = repository.findAll();
        if(rooms.isEmpty()) {
            throw new RuntimeException("No Rooms found");
        }

        return rooms;
    }

    @GetMapping("/rooms/{roomNumber}")
    public Room retrieveRoomDetails(@PathVariable int roomNumber) {
        Room room = repository.findByRoomNumber(roomNumber);

        if(room == null) {
            throw new RuntimeException("Unable to Find data for room number " + roomNumber);
        }

        return room;
    }

    @GetMapping("/rooms/available/{roomType}")
    public List<Room> retrieveAvailableRoomsOfType(@PathVariable String roomType) {
        List<Room> rooms = repository.findByRoomType(roomType);
        List<Room> availableRooms = new ArrayList<>();
        int totalRoomsOfType = rooms.size();
        if(rooms.isEmpty()) {
            throw new RuntimeException("Invalid Type");
        }

        for (Room room: rooms) {
            if(room.isAvailability()) {
                availableRooms.add(room);
            }
        }

        if(availableRooms.isEmpty()) {
            throw new RuntimeException("All Rooms of type " + roomType + " are Booked");
        }

        int numberOfAvailableRooms = availableRooms.size();
        System.out.println(numberOfAvailableRooms + "/" + totalRoomsOfType + " Rooms Available");
        return availableRooms;
    }

    @GetMapping("/rooms/check/{roomNumber}")
    public boolean roomAvailability(@PathVariable int roomNumber) {
        List<Guest> guests = proxy.getGuestByRoomNumber(roomNumber);
        return guests.isEmpty();
    }

    @PostMapping("/rooms/add")
    public void addRoom(@RequestBody Room room) {
        repository.save(room);
    }

    @PutMapping("/rooms/update")
    public void updateRoom(@RequestBody Room room) {
        repository.save(room);
    }

    @DeleteMapping("/rooms/delete")
    public void deleteRoom(@RequestBody Room room) {
        repository.save(room);
    }

}
