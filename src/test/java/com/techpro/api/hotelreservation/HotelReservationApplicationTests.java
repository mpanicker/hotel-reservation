package com.techpro.api.hotelreservation;

import com.techpro.api.hotelreservation.db.ReservationRepository;
import com.techpro.api.hotelreservation.domain.Reservation;
import com.techpro.api.hotelreservation.util.RandomString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelReservationApplicationTests {
	@Autowired
	ReservationRepository reservationRepo;

	Reservation firstBooking, secondBooking;

	@Before
	public void setUp() {

		reservationRepo.deleteAll();

		firstBooking = reservationRepo.save(new Reservation(RandomString.getAlphaNumericString(8), 2, 3));
		secondBooking = reservationRepo.save(new Reservation(RandomString.getAlphaNumericString(8),4,4));

	}

	@Test
	public void setsIdOnSave() {

		Reservation manoj_reservation = reservationRepo.save(new Reservation(RandomString.getAlphaNumericString(8),2, 3));
		assertThat(manoj_reservation.id).isNotNull();

	}

	@Test
	public void findById() {

		Optional<Reservation> result = reservationRepo.findById(firstBooking.id);


		//assertThat(result).extracting("email").isEqualTo("manoj@yahoo.com");
		//Assert.assertEquals(result.get().getEmail(),"manoj@yahoo.com");
	}


/*	@Test
	public void findByEmail() {

		List<Reservation> result = reservationRepo.findByEmail("manoj@yahoo.com");

		for(Reservation r:result) {
			//Assert.assertEquals(r.getEmail(),"manoj@yahoo.com");
		}
	}*/

	@Test
	public void findByBookingNumber() {

		Reservation result = reservationRepo.findByBookingNumber(firstBooking.getBookingNumber());
		Assert.assertEquals(firstBooking.getBookingNumber(),result.getBookingNumber());

	}

/*	@Test
	public void createNewReservationTest(){
		//Reservation  r = new Reservation(RandomString.getAlphaNumericString(8),2, 3,"masong18@gmail.com");
		Reservation r = reservationRepo.createNewReservation(RandomString.getAlphaNumericString(8),2, 3,"masong18@gmail.com");
		//Reservation result = createNewReservation(RandomString.getAlphaNumericString(8), 2, 3, "masong18@gmail.com");
		Assert.assertEquals(r.getEmail(), "masong18@gmail.com");
	}*/

}
