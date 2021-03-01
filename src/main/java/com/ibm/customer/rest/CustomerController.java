package com.ibm.customer.rest;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.customer.model.Customer;
import com.ibm.customer.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;

	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/customers")
	public ResponseEntity<?> getCustomers() {
		
		logger.info(" Entering CustomerController getCustomers() method ");		
		Collection<Customer> customers = this.customerService.getCustomers();		
		for(Customer c:customers) {
			logger.debug(" CustomerController getCustomers Debug Data: {}", c);
		}		
		ResponseEntity<Collection<Customer>> responseEntity = 
				new ResponseEntity<Collection<Customer>>(customers, HttpStatus.OK);		
		logger.info(" Leaving CustomerController getCustomers() method ");
		
		return responseEntity;		
	}

	@RequestMapping(value = "/customer/{customerNumber}")
	public ResponseEntity<?> getCustomer(@PathVariable(value = "customerNumber") String customerNumber) {
		
		logger.info(" Entering CustomerController getCustomer() method with Customer Number: {}", customerNumber);		
		Customer customer = this.customerService.getCustomer(customerNumber);		
		logger.debug(" CustomerController getCustomer Debug Data: {}", customer);		
		ResponseEntity<Customer> responseEntity = 
				new ResponseEntity<Customer>(customer, HttpStatus.OK);		
		logger.info(" Leaving CustomerController getCustomer() method with Customer Number: {}", customerNumber);
		
		return responseEntity;		
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		
		logger.info(" Entering CustomerController addCustomer() method with Input Customer: {}", customer);		
		Customer newCustomer = this.customerService.addCustomer(customer);		
		logger.debug(" CustomerController addCustomer Debug Data: {}", newCustomer);		
		ResponseEntity<Customer> responseEntity = 
				new ResponseEntity<Customer>(customer, HttpStatus.OK);		
		logger.info(" Leaving CustomerController addCustomer() method with Saved Customer: {}", newCustomer);
		
		return responseEntity;
	}
}
