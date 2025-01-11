package com.example.Ordermanagment.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ordermanagment.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer>{

	
}
