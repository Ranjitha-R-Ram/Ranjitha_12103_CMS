package com.atc.repo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.atc.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	EntityManager entityMan;

	@Override
	public Customer addCustomer(Customer customer) {
		entityMan.persist(customer);
		return customer;

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		entityMan.merge(customer);
		return customer;
	}

	@Override
	public Customer getCustomer(int customerId) {
		return entityMan.find(Customer.class, customerId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		return entityMan.createQuery("from Customer").getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerByEmail(String emailId) {
		Query qry2 = entityMan.createQuery("from Customer u where u.emailId=?1");
		qry2.setParameter(1, emailId);
		return qry2.getResultList();

	}

	public Customer loginUser(String customerName, String password) {
		Query query1 = entityMan.createQuery("from Customer u where u.customerName =?1 and u.password=?2");
		query1.setParameter(1, customerName);
		query1.setParameter(2, password);
		return (Customer) query1.getSingleResult();
	

	}

}
