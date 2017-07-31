package com.mon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mon.pojo.Customer;
import com.mon.pojo.CustomerRepository;
import com.mon.pojo.UserEntity;
@Service
public class receiveServiceImpl implements receiveService{
	@Autowired
	private CustomerRepository customerRepository;  
	@Override
	
	public void receive(String content) {
		// TODO Auto-generated method stub
		 Gson gson = new GsonBuilder().create();
		 UserEntity user = gson.fromJson(content, UserEntity.class);
		 System.out.println(user.toString());
		 System.out.println(user.getEmail());
		 if(user.getEmail().equals("114")){
			 customerRepository.deleteAll();

				// save a couple of customers
				customerRepository.save(new Customer("Alice", "Smith"));
				customerRepository.save(new Customer("Bob", "Smith"));

				// fetch all customers
				System.out.println("Customers found with findAll():");
				System.out.println("-------------------------------");
				for (Customer customer : customerRepository.findAll()) {
					System.out.println(customer);
				}
				System.out.println();

				// fetch an individual customer
				System.out.println("Customer found with findByFirstName('Alice'):");
				System.out.println("--------------------------------");
				System.out.println(customerRepository.findByFirstName("Alice"));

				System.out.println("Customers found with findByLastName('Smith'):");
				System.out.println("--------------------------------");
				for (Customer customer : customerRepository.findByLastName("Smith")) {
					System.out.println(customer);
				}
		 }
		

	   
	}

	
    
}
