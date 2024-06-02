package com.atc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.atc.model.Booking;
import com.atc.repo.BookingDAO;
import com.atc.service.BookingService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class BookingController {

	@Autowired
	BookingService service;

	@Autowired
	BookingDAO dao;

	@PostMapping("/AddBooking")
	public Booking addBooking(@RequestBody Booking booking) {
		booking.setStatus("pending");
		return service.addBooking(booking);

	}

	@GetMapping("/GetBooking/{bid}")
	public Booking performFind(@PathVariable("bid") int bid) {
		return service.getBooking(bid);

	}

	@GetMapping("/GetAllBooking")
	public List<Booking> getAllBooking() {
		return service.getAllBooking();
	}

	@PutMapping("/updateBooking")
	public Booking updateBooking(@RequestBody Booking booking) {
		booking.setStatus("Approved");
		return service.updateBooking(booking);

	}

	@PutMapping("/Approved/{bookingId}")
	public boolean approveRequest(@PathVariable("bookingId") int bookingId) {
		return service.approveRequest(bookingId);
	}

	@PutMapping("/rejected/{bookingId}")
	public boolean rejectRequest(@PathVariable("bookingId") int bookingId) {
		return service.rejectRequest(bookingId);
	}

	@GetMapping("/getCustomerById/{customerId}")
	public List<Booking> getCustomerById(@PathVariable("customerId") int customerId) {
		return service.getCustomerById(customerId);
	}

	@PutMapping("/updateBookingDetails")
	public Booking updateBookingDetails(@RequestBody Booking booking) {
		return service.updateBookingDetails(booking);

	}


	@GetMapping("/getBookingDetailsById/{customerId}")
	public Booking getBookingDetails(@PathVariable("customerId") int customerId) {
		return service.getBookingDetailsById(customerId);
	}

	@PostMapping("/sendMail/{bookingId}")
	public boolean sendMail(@PathVariable("bookingId") int bookingId) {

		return dao.updateEmailBooking(bookingId);

	}
}
