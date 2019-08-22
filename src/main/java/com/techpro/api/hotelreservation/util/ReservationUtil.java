package com.techpro.api.hotelreservation.util;

import com.techpro.api.hotelreservation.domain.Reservation;
import com.techpro.api.hotelreservation.exception.ReservationException;
import org.springframework.http.HttpStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationUtil {

    public static boolean isReservationValid(Reservation newReservation){
        String checkInDate = newReservation.getCheck_in_date();
        String checkOutDate = newReservation.getCheck_out_date();

        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(checkInDate);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(checkOutDate);
            if(date1.after(date2)){
                throw new ReservationException("Invalid Reservation: Start date is later than End Date", 4001, HttpStatus.BAD_REQUEST);
            }
        }
        catch(ParseException px) {
            throw new ReservationException("Invalid Reservation: Date needs to be format: yyyy-mm-dd", 4002, HttpStatus.BAD_REQUEST);
        }


        return false;
    }
}
