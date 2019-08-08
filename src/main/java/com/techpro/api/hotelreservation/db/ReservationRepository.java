package com.techpro.api.hotelreservation.db;

import com.techpro.api.hotelreservation.domain.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by manoj on 8/8/2019.
 */
public interface ReservationRepository extends MongoRepository<Reservation,String>{

    public Reservation findByBookingNumber(String bookingNumber);

    public List<Reservation> findByEmail(String email);
}
