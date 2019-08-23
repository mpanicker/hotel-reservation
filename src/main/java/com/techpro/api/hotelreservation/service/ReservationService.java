package com.techpro.api.hotelreservation.service;

import com.techpro.api.hotelreservation.db.ReservationRepository;
import com.techpro.api.hotelreservation.domain.Reservation;
import com.techpro.api.hotelreservation.util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepo;

    public Reservation getReservation(String bookingNumber) {
        Reservation r = reservationRepo.findByBookingNumber(bookingNumber);
        return r;
    }

    public List<Reservation> getReservationEmail(String email){
        List<Reservation> reservationList = reservationRepo.findReservationByEmail(email);
        return reservationList;
    }

    public List<Reservation> getReservationCountry(String country){
        List<Reservation> reservationList = reservationRepo.findReservationByCountry(country);
        return reservationList;
    }

    public List<Reservation> getReservationFullName(String fullName){
        List<Reservation> reservationList = reservationRepo.findReservationByFull_name(fullName);
        return reservationList;
    }

    public List<Reservation> getReservationRoomId(String roomId){
        List<Reservation> reservationList = reservationRepo.findReservationByRoomId(roomId);
        return reservationList;
    }

    public Reservation createNewReservation(Reservation newReservation) {
        String bookingNumber = RandomString.getAlphaNumericString(8);
        newReservation.setBookingNumber(bookingNumber);
        Reservation r = reservationRepo.save(newReservation);
        return r;
    }

    //Need to fix updating individual detail map items
    public void updateReservation( String bookingNumber, Reservation newReservation){
        Reservation r = reservationRepo.findByBookingNumber(bookingNumber);

        if (newReservation.getCheck_in_date() != null){
            r.setCheck_in_date(newReservation.getCheck_in_date());
        }
        if (newReservation.getCheck_out_date() != null){
            r.setCheck_out_date(newReservation.getCheck_out_date());
        }
        if (newReservation.getNum_of_guest() != null){
            r.setNum_of_guest(newReservation.getNum_of_guest());
        }
        if (newReservation.getNum_of_rooms() != null){
            r.setNum_of_rooms(newReservation.getNum_of_rooms());
        }
        if (newReservation.getReservation_total_price() != null){
            r.setReservation_total_price(newReservation.getReservation_total_price());
        }
        if (newReservation.getReservation_currency() != null){
            r.setReservation_currency(newReservation.getReservation_currency());
        }
        if (newReservation.getReservation_tax() != null){
            r.setReservation_tax(newReservation.getReservation_tax());
        }
        if (newReservation.getPayment_method() != null){
            r.setPayment_method(newReservation.getPayment_method());
        }
        if (newReservation.getHotelDetails() != null){
            r.setHotelDetails(newReservation.getHotelDetails());
        }
        if (newReservation.getPaymentDetails() != null){
            r.setPaymentDetails(newReservation.getPaymentDetails());
        }
        if (newReservation.getRoomDetails() != null){
            r.setRoomDetails(newReservation.getRoomDetails());
        }
        if (newReservation.getGuestDetails() != null){
            r.setGuestDetails(newReservation.getGuestDetails());
        }
        reservationRepo.save(r);
    }

    public void deleteReservation ( String bookingNumber){
        Reservation r = reservationRepo.findByBookingNumber(bookingNumber);
        reservationRepo.delete(r);
    }
}
