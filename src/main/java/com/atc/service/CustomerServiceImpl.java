package com.atc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atc.model.Customer;
import com.atc.repo.CustomerDAO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO dao;

	@Override
	public Customer addCustomer(Customer customer) {
		return dao.addCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return dao.updateCustomer(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		return dao.getCustomer(customerId);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return dao.getAllCustomer();
	}

	@Override
	public Customer loginUser(String customerName, String password) {
		return dao.loginUser(customerName, password);
	}

	@Override
	public List<Customer> getCustomerByEmail(String emailId) {
		return dao.getCustomerByEmail(emailId);
	}

}
