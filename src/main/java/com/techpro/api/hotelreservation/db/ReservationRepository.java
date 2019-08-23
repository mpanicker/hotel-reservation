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

    @Query("{'guestDetails.country': ?0}")
    public List<Reservation> findReservationByCountry(String country);

    @Query("{'guestDetails.full_name': ?0}")
    public List<Reservation> findReservationByFull_name(String full_name);

    @Query("{'roomDetails.room_id': ?0}")
    public List<Reservation> findReservationByRoomId(String roomId);


    //public Reservation createNewReservation(Reservation newReservation);

    //public Reservation createNewReservation(String alphaNumericString, int i, int i1, String s);

    //public void createNewReservation(Reservation r);
}

