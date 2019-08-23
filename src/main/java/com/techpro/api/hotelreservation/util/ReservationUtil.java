package com.techpro.api.hotelreservation.util;

import com.techpro.api.hotelreservation.domain.Reservation;
import com.techpro.api.hotelreservation.exception.ReservationException;
import org.springframework.http.HttpStatus;

import javax.xml.bind.ValidationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ReservationUtil {

    public static boolean isReservationValid(Reservation newReservation){
        String checkInDate = newReservation.getCheck_in_date();
        String checkOutDate = newReservation.getCheck_out_date();
        Date currentDate = new Date();


        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(checkInDate);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(checkOutDate);
            if(date1.after(date2)){
                throw new ReservationException("Invalid Reservation: Start date is later than End Date", 4001, HttpStatus.BAD_REQUEST);
            }

            if(date1.before(currentDate)){
                throw new ReservationException("Invalid Reservation: Start date is in the past", 4001, HttpStatus.BAD_REQUEST);
            }
            if(date2.before(currentDate)){
                throw new ReservationException("Invalid Reservation: End date is in the past", 4001, HttpStatus.BAD_REQUEST);
            }

        }
        catch(ParseException px) {
            throw new ReservationException("Invalid Reservation: Date needs to be format: yyyy-mm-dd", 4002, HttpStatus.BAD_REQUEST);
        }

        int numGuests = newReservation.getNum_of_guest();
        int numRooms = newReservation.getNum_of_rooms();
        try {
            if(numGuests < 1){
               throw new ReservationException("Invalid Reservation: Number of guests must be greater than 0", 4003, HttpStatus.BAD_REQUEST);
            }
            if(numRooms < 1){
                throw new ReservationException("Invalid Reservation: Number of rooms must be greater than 0", 4003, HttpStatus.BAD_REQUEST);
            }
        }
        catch (ArithmeticException ae){
            throw new ReservationException("Invalid Reservation: Must enter number of guests and rooms", 4004, HttpStatus.BAD_REQUEST);
        }

        double totalPrice = newReservation.getReservation_total_price();
        double tax = newReservation.getReservation_tax();
        try {
            if(totalPrice < 0.0){
                throw new ReservationException("Invalid Reservation: Total price must be greater than or equal to 0", 4003, HttpStatus.BAD_REQUEST);
            }
            if(tax < 0.0){
                throw new ReservationException("Invalid Reservation: Tax must be greater than or equal to 0", 4003, HttpStatus.BAD_REQUEST);
            }
        }
        catch (NumberFormatException ne) {
            throw new ReservationException("Invalid Reservation: Total price and tax must be a valid currency number", 4004, HttpStatus.BAD_REQUEST);
        }

        return false;
    }

}
