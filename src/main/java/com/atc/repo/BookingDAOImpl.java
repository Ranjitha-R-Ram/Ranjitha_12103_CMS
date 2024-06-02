package com.atc.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;
import com.atc.model.Booking;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class BookingDAOImpl implements BookingDAO {

	@Autowired
	EntityManager entityMan;

	@Autowired
	MailSender mailSender;

	@Override
	public Booking addBooking(Booking booking) {
		entityMan.persist(booking);
		return booking;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getAllBooking() {
		return entityMan.createQuery("from Booking").getResultList();
	}

	@Override
	public Booking getBooking(int bookingId) {
		return entityMan.find(Booking.class, bookingId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getBookingIds() {
		Query q = entityMan.createQuery("SELECT c.bookingId FROM Booking c");
		return q.getResultList();

	}

	@Override
	public Booking updateBooking(Booking booking) {
		return entityMan.merge(booking);
	}

	@Override
	public boolean approveRequest(int bookingId) {
		Query qr = entityMan.createQuery("UPDATE Booking b SET b.status = :newStatus WHERE b.bookingId = :bookingId");
		qr.setParameter("bookingId", bookingId);
		qr.setParameter("newStatus", "Approved");
		updateEmailBooking(bookingId);
		qr.executeUpdate();

		return true;
	}

	@Override
	public boolean rejectRequest(int bookingId) {
		Query qr = entityMan.createQuery("UPDATE Booking b SET b.status = :newStatus WHERE b.bookingId = :bookingId");
		qr.setParameter("bookingId", bookingId);
		qr.setParameter("newStatus", "Rejected");
		qr.executeUpdate();
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Booking> getCustomerById(int customerId) {
		Query query2 = entityMan.createQuery("FROM Booking b WHERE b.customer.customerId = :customerId");
		query2.setParameter("customerId", customerId);
		return query2.getResultList();

	}

	@Override
	public Booking updateBookingDetails(Booking booking) {
		return entityMan.merge(booking);
	}

	@Override
	public Booking getBookingDetailsById(int customerId) {
		Query query3 = entityMan.createQuery("FROM Booking b WHERE b.customer.customerId = :customerId");
		query3.setParameter("customerId", customerId);
		return (Booking) query3.getSingleResult();
	}

	@Override
	public boolean updateEmailBooking(int bookingId) {
		Query query = entityMan.createQuery("from Booking c where c. bookingId=?1");
		query.setParameter(1, bookingId);
		Booking book = (Booking) query.getSingleResult();
		String customerEmail = book.getCustomer().getEmailId();
		String customerName = book.getCustomer().getCustomerName();
		String projectType = book.getProjectType();
		String totalCost = book.getTotalCost();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("cmscontruction9876@gmail.com");
		message.setTo(customerEmail);
		message.setText("Dear " + customerName + "\r\n I Arun from CMS Construction." + "\r\nYour booking project "
				+ projectType + " is approved." + "\r\n please pay your amount Rupees " + totalCost
				+ " for the booking package"

				+ "\r\n In case of any queries, please reach out to us  \r\n Thank you");
		message.setSubject("Regarding Booking confrmation - CMS Construction");

		mailSender.send(message);

		return true;
	}

}
