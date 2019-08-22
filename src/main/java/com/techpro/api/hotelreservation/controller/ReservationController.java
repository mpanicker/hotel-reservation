package com.techpro.api.hotelreservation.controller;

import com.mongodb.util.JSON;
import com.techpro.api.hotelreservation.domain.Reservation;
import com.techpro.api.hotelreservation.exception.ReservationException;
import com.techpro.api.hotelreservation.service.ReservationService;
import com.techpro.api.hotelreservation.util.ReservationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/reservation/country")
    public List<?> getReservationByCountry(@RequestParam final String country) {
        List<Reservation> reservationList = reservationService.getReservationCountry(country);
        return reservationList;
    }

    @GetMapping("/reservation/fullName")
    public List<?> getReservationByFullName(@RequestParam final String fullName) {
        List<Reservation> reservationList = reservationService.getReservationFullName(fullName);
        return reservationList;
    }

    @PostMapping( "/reservation")
    @ResponseBody
    public ResponseEntity<?> createReservation(@RequestBody Reservation newReservation){
        try {
            ReservationUtil.isReservationValid(newReservation);
        }
        catch(ReservationException re){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(re.getJsonMessage());
        }
        Reservation r = reservationService.createNewReservation(newReservation);
        return new ResponseEntity<Reservation>(HttpStatus.CREATED);
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
