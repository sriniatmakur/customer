package com.ibm.customer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

class CustomerTest {

    @BeforeEach
    public void init() {
       MockitoAnnotations.initMocks(this);
    }
    
    @DisplayName("Test Customer getCustomerNumber method")
	@Test
	void testGetCustomerNumber() {

    	String customerNumber = "C1234";    	
    	Customer customer = new Customer(customerNumber, "Donald", "Duck'", "donaldduck@gmail.com");
    	
    	assertEquals(customer.getCustomerNumber(), customerNumber, 
    			"Customer Number should be equal to " + customerNumber);
    	
	}

    @DisplayName("Test Customer setCustomerNumber method")
	@Test
	void testSetCustomerNumber() {

    	String customerNumber = "C1234";    	
    	Customer customer = new Customer("X9999", "Donald", "Duck'", "donaldduck@gmail.com"); 
    	
    	customer.setCustomerNumber(customerNumber);
    	
    	assertEquals(customer.getCustomerNumber(), customerNumber, 
    			"Customer Number should be equal to " + customerNumber);
    	
	}

    @DisplayName("Test Customer getFirstName method")
	@Test
	void testGetFirstName() {

		String firstName = "Donald";    	
    	Customer customer = new Customer("C1234", firstName, "Duck'", "donaldduck@gmail.com");
    	
    	assertEquals(customer.getFirstName(), firstName, 
    			"First Name should be equal to " + firstName);
    	
	}

    @DisplayName("Test Customer setFirstName method")
	@Test
	void testSetFirstName() {

    	String firstName = "Donald";    	
    	Customer customer = new Customer("C1234", "FirstName", "Duck'", "donaldduck@gmail.com");
    	
    	customer.setFirstName(firstName);
    	
    	assertEquals(customer.getFirstName(), firstName, 
    			"First Name should be equal to " + firstName);
    	
	}

    @DisplayName("Test Customer getLastName method")
	@Test
	void testGetLastName() {

		String lastName = "Duck";    	
    	Customer customer = new Customer("C1234", "Donald", lastName, "donaldduck@gmail.com");
    	
    	assertEquals(customer.getLastName(), lastName, 
    			"Last Name should be equal to " + lastName);
    	
	}

    @DisplayName("Test Customer setLastName method")
	@Test
	void testSetLastName() {

    	String lastName = "Duck";    	
    	Customer customer = new Customer("C1234", "Donald", "LastName'", "donaldduck@gmail.com");
    	
    	customer.setLastName(lastName);
    	
    	assertEquals(customer.getLastName(), lastName, 
    			"Last Name should be equal to " + lastName);
    	
	}

    @DisplayName("Test Customer getEmailAddress method")
	@Test
	void testGetEmailAddress() {

		String emailAddress = "donaldduck@gmail.com";    	
    	Customer customer = new Customer("C1234", "Donald", "Duck", emailAddress);
    	
    	assertEquals(customer.getEmailAddress(), emailAddress, 
    			"Email Address should be equal to " + emailAddress);
    	
	}

    @DisplayName("Test Customer setEmailAddress method")
	@Test
	void testSetEmailAddress() {

    	String emailAddress = "donaldduck@gmail.com";    	
    	Customer customer = new Customer("C1234", "Donald", "Duck'", "Email_Address");
    	
    	customer.setEmailAddress(emailAddress);
    	
    	assertEquals(customer.getEmailAddress(), emailAddress, 
    			"Email Address should be equal to " + emailAddress);
    	
	}

}
