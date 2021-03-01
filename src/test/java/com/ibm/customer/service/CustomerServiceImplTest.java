package com.ibm.customer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ibm.customer.model.Customer;
import com.ibm.customer.repo.CustomerRepo;

class CustomerServiceImplTest {

	@Mock
	private CustomerRepo customerRepoMock;
	
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
    @BeforeEach
    public void init() {
       MockitoAnnotations.initMocks(this);
    }
  
    @DisplayName("Test CustomerServiceImpl getCustomers method")
	@Test
	void testGetCustomersReturnsCustomers() {
		
    	Collection<Customer> customersMock = new ArrayList<Customer>();		
    	customersMock.add(new Customer("C1234", "Donald", "Duck", "donaldduck@gmail.com"));		
    	customersMock.add(new Customer("C5678", "Mickey", "Mouse", "mickeymouse@gmail.com"));		
		when(customerRepoMock.findAll()).thenReturn((List<Customer>) customersMock);
		
		Collection<Customer> customers = customerServiceImpl.getCustomers();
		
		assertNotNull(customers, "Customers should not be null");		
		assertEquals(customers, customersMock, "customers should be equal to " + customersMock);
		
		verify(customerRepoMock).findAll();
		
	}

    @DisplayName("Test CustomerServiceImpl getCustomer method with Valid Customer Number")
	@Test
	void testGetCustomerValidCustomerNumber() {
		
		String customerNumber = "C1234";		
		Customer customerMock = new Customer(customerNumber, "Donald", "Duck", "donaldduck@gmail.com");		
		when(customerRepoMock.findByCustomerNumber(customerNumber)).thenReturn(customerMock);
		
		Customer customer = customerServiceImpl.getCustomer(customerNumber);
		
		assertNotNull(customer,"Customer should not be null");		
		assertEquals(customer, customerMock, "customer should be same as {}" + customerMock);
		
		verify(customerRepoMock).findByCustomerNumber(customerNumber);
		
	}

	@DisplayName("Test CustomerServiceImpl getCustomer method with Invalid Customer Number")
	@Test
	void testGetCustomerInvalidCustomerNumber() {
		
		String customerNumber = "X9999";		
		Customer customerMock = null;		
		when(customerRepoMock.findByCustomerNumber(customerNumber)).thenReturn(customerMock);
		
		Customer customer = customerServiceImpl.getCustomer(customerNumber);
		
		assertNull(customer,"Customer should be null");		
		assertEquals(customer, customerMock, "customer should be same as {}" + customerMock);
		
		verify(customerRepoMock).findByCustomerNumber(customerNumber);
		
	}

    @DisplayName("Test CustomerServiceImpl addCustomer method")
	@Test
	void testAddCustomer() {
    	
		Customer customerMock = new Customer("C1234", "Donald", "Duck", "donaldduck@gmail.com");		
		when(customerRepoMock.save(customerMock)).thenReturn(customerMock);
		
		Customer customer = customerServiceImpl.addCustomer(customerMock);
		
		assertNotNull(customer,"Customer should not be null");		
		assertEquals(customer, customerMock, "customer should be same as {}" + customerMock);
		
		verify(customerRepoMock).save(customer);

	}

}
