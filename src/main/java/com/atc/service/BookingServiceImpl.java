package com.atc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atc.model.Booking;
import com.atc.repo.BookingDAO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDAO dao;

	@Override
	public Booking addBooking(Booking booking) {
		return dao.addBooking(booking);
	}

	@Override
	public Booking updateBookingDetails(Booking booking) {
		return dao.updateBookingDetails(booking);
	}

	@Override
	public Booking getBooking(int bookingId) {
		return dao.getBooking(bookingId);
	}

	@Override
	public List<Booking> getAllBooking() {
		return dao.getAllBooking();
	}

	@Override
	public List<Integer> getBookingIds() {
		return dao.getBookingIds();
	}

	@Override
	public Booking updateBooking(Booking booking) {
		return dao.updateBooking(booking);
	}

	@Override
	public boolean approveRequest(int bookingId) {
		return dao.approveRequest(bookingId);
	}

	@Override
	public boolean rejectRequest(int bookingId) {
		return dao.rejectRequest(bookingId);
	}

	@Override
	public List<Booking> getCustomerById(int customerId) {
		return dao.getCustomerById(customerId);
	}

	@Override
	public Booking getBookingDetailsById(int customerId) {
		return dao.getBookingDetailsById(customerId);
	}

}
