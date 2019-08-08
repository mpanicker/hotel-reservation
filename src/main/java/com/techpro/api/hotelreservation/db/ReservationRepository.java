package com.techpro.api.hotelreservation.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by manoj on 8/8/2019.
 */
public interface ReservationRepository extends MongoRepository<ReservationRepository,String>{

    public ReservationRepository findByBookingNumber(String booking_number);

    public List<ReservationRepository> findByEmail(String email);
}
