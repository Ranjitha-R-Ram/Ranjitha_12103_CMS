package com.atc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.atc.controller.CustomerController;
import com.atc.model.Customer;

@SpringBootTest
 class CustomerTest {

	@Autowired
	CustomerController customerController;

	@Test
	void test_addCustomer() {
		Customer customer = new Customer();
		customer.setCustomerName("Thamizh");
		customer.setEmailId("thamizh@gmail.com");
		customer.setPassword("Thamizh@1234");
		customer.setPhoneNumber("9867567876");
		customer.setAddress("Madurai");
		String msg = "Customer Object Saved";
		String result = customerController.addCustomer(customer);
		assertEquals(msg, result);
	}

	@Test
	void test_updateCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(13);
		customer.setCustomerName("Thamizharasan");
		customer.setEmailId("thamizh@gmail.com");
		customer.setPassword("Thamizh@1234");
		customer.setPhoneNumber("9867567876");
		customer.setAddress("Madurai");
		String msg = "Customer Object Updated";
		String result = customerController.updateCustomer(customer);
		assertEquals(msg, result);
	}

	@Test
	void test_performFind() {
		Customer customer = customerController.performFind(13);
		System.out.println(customer);
		assertNotNull(customer);

	}
}
