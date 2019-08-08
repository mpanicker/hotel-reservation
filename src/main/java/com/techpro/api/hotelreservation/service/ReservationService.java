package com.techpro.api.hotelreservation.service;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    public String getReservation(String bookingNumber) {
        return "{\"booking_number\": \"1234567\"}";
    }
}
