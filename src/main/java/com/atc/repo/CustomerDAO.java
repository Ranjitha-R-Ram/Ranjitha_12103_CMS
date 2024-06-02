package com.atc.repo;

import java.util.List;

import com.atc.model.Customer;

public interface CustomerDAO {

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public List<Customer> getAllCustomer();

	public Customer loginUser(String customerName, String password);

	public List<Customer> getCustomerByEmail(String emailId);

}
