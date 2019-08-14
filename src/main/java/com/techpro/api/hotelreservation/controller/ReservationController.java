package com.techpro.api.hotelreservation.controller;

import com.techpro.api.hotelreservation.domain.Reservation;
import com.techpro.api.hotelreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping("/reservation/{bookingNumber}")
    public ResponseEntity<?> getReservationByBookingNumber(@PathVariable final String bookingNumber) {
        Reservation r = reservationService.getReservation(bookingNumber);
        return ResponseEntity.ok().body(r);
    }
}
