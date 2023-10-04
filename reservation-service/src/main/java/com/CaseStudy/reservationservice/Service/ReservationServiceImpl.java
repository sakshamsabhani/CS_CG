package com.CaseStudy.reservationservice.Service;

import com.CaseStudy.reservationservice.Model.Email;
import com.CaseStudy.reservationservice.Model.Guest;
import com.CaseStudy.reservationservice.Model.Reservation;
import com.CaseStudy.reservationservice.Model.Room;
import com.CaseStudy.reservationservice.Proxy.EmailProxy;
import com.CaseStudy.reservationservice.Proxy.GuestProxy;
import com.CaseStudy.reservationservice.Proxy.RoomProxy;
import com.CaseStudy.reservationservice.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository repository;

    @Autowired
    private RoomProxy roomProxy;
    
    @Autowired
    private GuestProxy guestProxy;

    @Autowired
    private EmailProxy emailProxy;


    @Override
    public String reserveRoom(Reservation reservation) {
        if(roomProxy.roomAvailability(reservation.getRoomNumber())) {
            repository.save(reservation);
            Room room = roomProxy.retrieveRoomDetails(reservation.getRoomNumber());
            room.setAvailability(false);
            roomProxy.updateRoom(room);

            Guest primaryGuest = guestProxy.getGuest(reservation.getGuestId());
            String guestEmail = primaryGuest.getEmail();
            String subject = "Reservation for booking id " + reservation.getBookingId() + " confirmed.";
            String body = "We are delighted to inform you that your reservation at The Plaza has been successfully confirmed.\n\n" +
                    "Here are the details of your reservation:\n\n" + reservation + "\n\n" + "We've upgraded your room to "+ roomProxy.retrieveRoomDetails(reservation.getRoomNumber());

            emailProxy.sendEmail(new Email(guestEmail, body, subject));
            System.out.println("Booking Successful");
        }
        else {
        System.out.println("Room Already Booked");
        }
        return "";
    }

    @Override
    public Reservation getReservation(String bookingId) {
        return repository.findByBookingId(bookingId);
    }

    @Override
    public Reservation getReservationByGuestId(int guestId) {
        return repository.findByGuestId(guestId);
    }

    @Override
    public Reservation getReservationByRoomNumber(int roomNumber) {
        return repository.findByRoomNumber(roomNumber);
    }

    @Override
    public String getRoomTypeByBookingId(String bookingId) {
        return roomProxy.retrieveRoomDetails(getReservation(bookingId).getRoomNumber()).getRoomType();
    }

    @Override
    public void updateReservation(Reservation reservation) {
        Reservation reservationOLD = repository.findByRoomNumber(reservation.getRoomNumber());
        repository.delete(reservationOLD);
        repository.save(reservation);
    }

    @Override
    public void cancelReservation(int roomNumber) {
        repository.delete(repository.findByRoomNumber(roomNumber));
    }

    @Override
    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

//    public Reservation findByGuestId(int guestId) {
//        List<Reservation> reservationList = getAllReservations();
//
//        for (Reservation reservation : reservationList) {
//            if(reservation.getGuests().contains(guestProxy.getGuest(guestId))) {
//                return reservation;
//            }
//        }
//
//        throw new RuntimeException("No reservation for Guest Id " + guestId + " found.");
//    }
}
