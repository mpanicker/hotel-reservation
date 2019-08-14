package com.techpro.api.hotelreservation.service;

import com.techpro.api.hotelreservation.db.ReservationRepository;
import com.techpro.api.hotelreservation.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepo;

    public Reservation getReservation(String bookingNumber) {
        Reservation r = reservationRepo.findByBookingNumber(bookingNumber);

        return r;
    }
}
