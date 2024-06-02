package com.atc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.atc.controller.BookingController;
import com.atc.model.Booking;
import com.atc.model.Customer;

@SpringBootTest
class BookingTest {

	@Autowired
	BookingController bookingController;

	@Test
	void test_addBooking() {
		Booking booking = new Booking();
		booking.setProjectType("SK Project");
		booking.setRoomSize("Three");
		booking.setParking("Yes");
		booking.setKitchen("Two");
		booking.setStoreRoom("yes");
		booking.setInteriorDesign("Yes");
		booking.setSwimmingPool("Yes");
		booking.setStatus("pending");
		booking.setSquareFeet("2890");
		booking.setPackageType("Silver");
		booking.setTotalCost("460000");
		Customer customer = new Customer();
		customer.setCustomerId(2);
		booking.setCustomer(customer);
		Booking result = bookingController.addBooking(booking);
		assertEquals(result, booking);

	}

	@Test
	void test_getBooking() {
		Booking booking = bookingController.performFind(15);
		assertNotNull(booking);
	}

	@Test
	void test_getAllBooking() {
		List<Booking> booking = bookingController.getAllBooking();
		assertNotNull(booking);
	}

	@Test
	void test_approveRequest() {
		boolean booking = bookingController.approveRequest(16);
		assertEquals(true, booking);
	}

	@Test
	void test_rejectRequest() {
		boolean booking = bookingController.rejectRequest(16);
		assertEquals(true, booking);
	}

	@Test
	void test_getCustomerById() {
		List<Booking> booking = bookingController.getCustomerById(2);
		assertNotNull(booking);
	}

	@Test
	void test_sendMail() {
		boolean booking = bookingController.sendMail(16);
		assertEquals(true, booking);
	}
}
