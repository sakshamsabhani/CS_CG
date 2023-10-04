package com.CaseStudy.guestservice.Controller;

import com.CaseStudy.guestservice.Repository.GuestRepository;
import com.CaseStudy.guestservice.Model.Guest;
import com.CaseStudy.guestservice.Model.Room;
import com.CaseStudy.guestservice.Proxy.RoomProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestController {


    @Autowired
    private RoomProxy proxy;

    @Autowired
    private GuestRepository repository;

    @GetMapping("/guests/find/{id}")
        public Guest getGuest(@PathVariable int id) {
        return repository.findByGuestId(id);
    }

    @GetMapping("/guests/inRoom/{roomNumber}")
    public List<Guest> getGuestByRoomNumber(@PathVariable int roomNumber) {
        return repository.findByRoomNumber(roomNumber);
    }

//    @GetMapping("/guests/{roomNumber}")
//    public List<Guest> getGuestsInRoom(@PathVariable int roomNumber) {
//        List<Guest> guests = repository.findAll();
//        List<Guest> guestInRoom = new ArrayList<>();
//        for(Guest guest : guests) {
//            if(guest.getRoomNumber() == roomNumber) {
//                guestInRoom.add(guest);
//            }
//        }
//        return guestInRoom;
//    }

    @GetMapping("/guests/findAll")
    public List<Guest> getAllGuests() {
        return repository.findAll();
    }

    @PostMapping("/guests/add/{roomNumber}")
    public void addGuest(@PathVariable int roomNumber, @RequestBody List<Guest> guests) {

        Room room = proxy.retrieveRoomDetails(roomNumber);

        if(guests.size() <= room.getOccupancy()) {
            repository.saveAll(guests);
        }
        else {
            throw new RuntimeException("Maximum occupancy of room" + roomNumber + "is " + room.getOccupancy());
        }
    }

    @PostMapping("/guests/update")
    public void updateGuest(@RequestBody Guest guest) {
        repository.save(guest);
    }

    @DeleteMapping("/guests/delete/{id}")
    public void deleteGuest(@PathVariable int id) {
        repository.deleteById(id);
    }
    
}
