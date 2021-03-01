package com.ibm.customer.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.customer.model.Customer;
import com.ibm.customer.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public CustomerServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Customer> getCustomers() {
		
		logger.info(" Entering CustomerServiceImpl getCustomers() method ");		
		Collection<Customer> customers = this.customerRepo.findAll();
		for(Customer c:customers) {
			logger.debug(" CustomerServiceImpl getCustomers Debug Data: {}", c);
		}
		logger.info(" Leaving CustomerServiceImpl getCustomers() method ");		
		
		return customers;		
	}

	@Override
	public Customer getCustomer(String customerNumber) {

		logger.info(" Entering CustomerServiceImpl getCustomer() method with Customer Number: {}", customerNumber);		
		Customer customer = this.customerRepo.findByCustomerNumber(customerNumber);		
		logger.debug(" CustomerServiceImpl getCustomer Debug Data for customerNumber {} : {}", customerNumber, customer);		
		logger.info(" Leaving CustomerServiceImpl getCustomer() method with Customer Number: {}", customerNumber);
		
		return customer;		
	}

	@Override
	public Customer addCustomer(Customer customer) {

		logger.info(" Entering CustomerServiceImpl AddCustomer() method with Input Customer: {}", customer);		
		Customer newCustomer = this.customerRepo.save(customer);		
		logger.debug(" CustomerServiceImpl addCustomer Debug Data: {}", newCustomer);		
		logger.info(" Leaving CustomerServiceImpl AddCustomer() method with Saved Customer: {}", customer);
		
		return newCustomer;		
	}
}
