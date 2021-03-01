package com.ibm.customer.service;

import java.util.Collection;

import com.ibm.customer.model.Customer;

public interface CustomerService {
	
	public Collection<Customer> getCustomers();	
	public Customer getCustomer(String customerNumber);	
	public Customer addCustomer(Customer customer);
}
