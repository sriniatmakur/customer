package com.ibm.customer.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.customer.model.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long> {

	public Customer findByCustomerNumber(String customerNumber);
}
