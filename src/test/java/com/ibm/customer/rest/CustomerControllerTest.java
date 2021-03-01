package com.ibm.customer.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ibm.customer.model.Customer;
import com.ibm.customer.service.CustomerService;

class CustomerControllerTest {

	@Mock
	private CustomerService customerServiceMock;
	
	@InjectMocks
	private CustomerController customerController;
	
    @BeforeEach
    public void init() {
       MockitoAnnotations.initMocks(this);
    }
    
    @DisplayName("Test CustomerController getCustomers method")
	@Test
	void testGetCustomers() {

    	Collection<Customer> customersMock = new ArrayList<Customer>();	
    	customersMock.add(new Customer("C1234", "Donald", "Duck", "donaldduck@gmail.com"));		
    	customersMock.add(new Customer("C5678", "Mickey", "Mouse", "mickeymouse@gmail.com"));		
		ResponseEntity<?> responseEntityMock = new ResponseEntity<Collection<Customer>>(customersMock, HttpStatus.OK);
    	when(customerServiceMock.getCustomers()).thenReturn((List<Customer>)customersMock);
				
		ResponseEntity<?> customers = customerController.getCustomers();
		
		assertNotNull(customers, "Customers should not be null");		
		assertEquals(customers, responseEntityMock, "customers should be equal to " + customersMock);
		
		verify(customerServiceMock).getCustomers();
		
	}

    @DisplayName("Test CustomerController getCustomer method with Valid Customer Number")
	@Test
	void testGetCustomerwithValidCustomerNumber() {
    	
		String customerNumber = "C1234";		
		Customer customerMock = new Customer(customerNumber, "Donald", "Duck", "donaldduck@gmail.com");		
		ResponseEntity<?> responseEntityMock = new ResponseEntity<Customer>(customerMock, HttpStatus.OK);
		when(customerServiceMock.getCustomer(customerNumber)).thenReturn(customerMock);		
		
		ResponseEntity<?> customer = customerController.getCustomer(customerNumber);
		
		assertNotNull(customer,"Customer should not be null");		
		assertEquals(customer, responseEntityMock, "customer should be equal to " + customerMock);
		
		verify(customerServiceMock).getCustomer(customerNumber);
		
	}

    @DisplayName("Test CustomerController getCustomer method with Invalid Customer Number")
	@Test
	void testGetCustomerwithInvalidCustomerNumber() {
		
		String customerNumber = "X9999";
		Customer customerMock = null;
		ResponseEntity<?> responseEntityMock = new ResponseEntity<Customer>(customerMock, HttpStatus.OK);
		when(customerServiceMock.getCustomer(customerNumber)).thenReturn(customerMock);
		
		ResponseEntity<?> customer = customerController.getCustomer(customerNumber);
		
		assertNotNull(customer,"Customer should not be null as the new Response Entity will be created even for no results");		
		assertEquals(customer, responseEntityMock, "customer should be same as {}" + customerMock);
		
		verify(customerServiceMock).getCustomer(customerNumber);

	}

    @DisplayName("Test CustomerController addCustomer method")
	@Test
	void testAddCustomer() {
       	
    	Customer customerMock = new Customer("C1234", "Donald", "Duck", "donaldduck@gmail.com");	
    	ResponseEntity<?> responseEntityMock = new ResponseEntity<Customer>(customerMock, HttpStatus.OK);
    	when(customerServiceMock.addCustomer(customerMock)).thenReturn(customerMock);    		
    		
    	ResponseEntity<?> customer = customerController.addCustomer(customerMock);
    		
    	assertNotNull(customer,"Customer should not be null");	
    	assertEquals(customer, responseEntityMock, "customer should be same as {}" + customerMock);
    		
    	verify(customerServiceMock).addCustomer(customerMock);

	}

}
