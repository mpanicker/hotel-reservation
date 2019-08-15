package com.techpro.api.hotelreservation.db;

import com.techpro.api.hotelreservation.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by manoj on 8/8/2019.
 */
public interface ReservationRepository extends MongoRepository<Reservation,String>{

    public Reservation findByBookingNumber(String bookingNumber);

    @Query("{'guestDetails.email': ?0}")
    public List<Reservation> findReservationByEmail(String email);

    //public Reservation createNewReservation(Reservation newReservation);

    //public Reservation createNewReservation(String alphaNumericString, int i, int i1, String s);

    //public void createNewReservation(Reservation r);
}

