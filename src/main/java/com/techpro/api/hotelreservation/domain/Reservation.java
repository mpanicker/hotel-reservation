package com.techpro.api.hotelreservation.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by manoj on 8/8/2019.
 */
public class Reservation {

    @Id
    public String bookingNumber;

    public Integer num_of_guest;

    public Integer num_of_rooms;

    public String email;


    public Reservation(Integer num_of_guest, Integer num_of_rooms, String email) {
        this.num_of_guest = num_of_guest;
        this.num_of_rooms = num_of_rooms;
        this.email = email;
    }

    public Reservation(){

    }

    @Override
    public String toString() {
        return String.format(
                "Reservation[id=%s, Number of Rooms='%s', Number of Guests='%s', Email ='%s']",
                bookingNumber, num_of_rooms, num_of_guest, email);
    }


}
