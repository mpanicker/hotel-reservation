package com.techpro.api.hotelreservation.controller;

import com.mongodb.util.JSON;
import com.techpro.api.hotelreservation.domain.Reservation;
import com.techpro.api.hotelreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/reservation")
    public List<?> getReservationByEmail(@RequestParam final String email){
        List<Reservation> reservationList = reservationService.getReservationEmail(email);
        return reservationList;
    }
    //change contract email_address

    @PostMapping( "/reservation")
    @ResponseBody
    public Reservation createReservation(@RequestBody Reservation newReservation){
        Reservation r = reservationService.createNewReservation(newReservation);
        return r;
    }

    @PutMapping("/reservation/{bookingNumber}")
    public void updateReservation(@PathVariable final String bookingNumber, @RequestBody Reservation newReservation){
        reservationService.updateReservation(bookingNumber, newReservation);
    }

    @DeleteMapping("/reservation/{bookingNumber}")
    public void deleteReservation(@PathVariable final String bookingNumber) {
        reservationService.deleteReservation(bookingNumber);
    }

}
