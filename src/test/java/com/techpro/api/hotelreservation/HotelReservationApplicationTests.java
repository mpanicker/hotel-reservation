package com.techpro.api.hotelreservation;

import com.techpro.api.hotelreservation.db.ReservationRepository;
import com.techpro.api.hotelreservation.domain.Reservation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelReservationApplicationTests {
	@Autowired
	ReservationRepository reservationRepo;

	Reservation firstBooking, secondBooking;

	@Before
	public void setUp() {

		reservationRepo.deleteAll();

		firstBooking = reservationRepo.save(new Reservation(2, 3));
		secondBooking = reservationRepo.save(new Reservation(4,4));

	}

	@Test
	public void contextLoads() {
	}

}
