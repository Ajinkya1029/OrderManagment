package com.example.Ordermanagment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ordermanagment.entity.Customer;
import com.example.Ordermanagment.respository.CustomerRepo;

@Service

public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;
	
	public boolean createCustomer(Customer customer) {
		Customer newCustomer= new Customer();
		newCustomer.setFirstname(customer.getFirstname());
		newCustomer.setLastname(customer.getLastname());
		customerRepo.save(newCustomer);
		return true;
	}

}
