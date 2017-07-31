package com.mon.pojo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {
	public Customer findByFirstName(String firstname);
    public List<Customer> findByLastName(String lastName);
}
