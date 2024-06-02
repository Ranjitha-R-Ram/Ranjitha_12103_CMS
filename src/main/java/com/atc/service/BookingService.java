package com.atc.service;

import java.util.List;
import com.atc.model.Booking;

public interface BookingService {

	public Booking addBooking(Booking booking);

	public Booking updateBookingDetails(Booking booking);

	public Booking getBooking(int bookingId);

	public List<Booking> getAllBooking();

	List<Integer> getBookingIds();

	public Booking updateBooking(Booking booking);

	public boolean approveRequest(int bookingId);

	public boolean rejectRequest(int bookingId);

	public List<Booking> getCustomerById(int customerId);
	
	public Booking getBookingDetailsById(int customerId);
}
