package com.techpro.api.hotelreservation;

import com.techpro.api.hotelreservation.db.ReservationRepository;
import com.techpro.api.hotelreservation.domain.Reservation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelReservationApplicationTests {
	@Autowired
	ReservationRepository reservationRepo;

	Reservation firstBooking, secondBooking;

	@Before
	public void setUp() {

		reservationRepo.deleteAll();

		firstBooking = reservationRepo.save(new Reservation(2, 3, "manoj@yahoo.com"));
		secondBooking = reservationRepo.save(new Reservation(4,4,"manoj@yahoo.com"));

	}

	@Test
	public void setsIdOnSave() {

		Reservation manoj_reservation = reservationRepo.save(new Reservation(2, 3,"manoj@yahoo.com"));
		assertThat(manoj_reservation.bookingNumber).isNotNull();

	}

	@Test
	public void findByBookingNum() {

		Reservation result = reservationRepo.findByBookingNumber(firstBooking.bookingNumber);


		//assertThat(result).extracting("email").isEqualTo("manoj@yahoo.com");
		Assert.assertEquals(result.email,"manoj@yahoo.com");
	}


	@Test
	public void findByEmail() {

		List<Reservation> result = reservationRepo.findByEmail("manoj@yahoo.com");

		for(Reservation r:result) {
			System.out.println("Reservation = "+r.toString());
		}
	}

}
