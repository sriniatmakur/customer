package com.ibm.customer.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ibm.customer.model.Customer;

class CustomerRepoTest {

	@Mock
	private CustomerRepo customerRepoMock;

    @BeforeEach
    public void init() {
       MockitoAnnotations.initMocks(this);
    }
  
    @DisplayName("Test CustomerRepo findByCustomerNumber method")
	@Test
	void testFindByCustomerNumber() {
		
		String customerNumber = "C1234";		
		Customer customer = new Customer("C1234", "Donald", "Duck", "donaldduck@gmail.com");				
		when(customerRepoMock.findByCustomerNumber(customerNumber)).thenReturn(customer);
		
		Customer repoCustomer = customerRepoMock.findByCustomerNumber(customerNumber);
		
		assertNotNull(repoCustomer, "Repo Customer should be not null");
		assertEquals(repoCustomer, customer, "Repo Customer should be equal to " + customer);

		verify(customerRepoMock).findByCustomerNumber(customerNumber);
		
	}

}
