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
import com.atc.model.Customer;
import com.atc.service.CustomerService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class CustomerController {
	@Autowired
	CustomerService service;

	@PostMapping("/AddCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		String msg = "";
		try {
			service.addCustomer(customer);
			msg = "Customer Object Saved";
		} catch (Exception e) {
			msg = "Customer Object Not Saved";
		}
		return msg;
	}

	@PutMapping("/UpdateCustomer")
	public String updateCustomer(@RequestBody Customer customer) {
		String msg = "";
		try {
			service.updateCustomer(customer);
			msg = "Customer Object Updated";
		} catch (Exception e) {
			msg = "Customer Object Not Updated";
		}
		return msg;
	}

	@GetMapping("/GetCustomer/{customerid}")
	public Customer performFind(@PathVariable("customerid") int customerid) {
		return service.getCustomer(customerid);

	}

	@GetMapping("/GetAllCustomer")
	public List<Customer> getAllCustomer() {
		return service.getAllCustomer();
	}

	@GetMapping("/GetEmailId/{emailId}")
	public List<Customer> getCustomerByEmail(@PathVariable("emailId") String emailId) {
		return service.getCustomerByEmail(emailId);
	}

	@GetMapping("/loginUser/{customerName}/{password}")
	public Customer loginUser(@PathVariable("customerName") String customerName,
			@PathVariable("password") String password) {

		return service.loginUser(customerName, password);

	}

}
