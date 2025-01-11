package com.example.Ordermanagment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.CodecConfigurer.CustomCodecs;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ordermanagment.dto.ResponseDto;
import com.example.Ordermanagment.entity.Customer;
import com.example.Ordermanagment.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
  
	@Autowired
	private CustomerService customerService;
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createCustomer(@RequestBody Customer customer) {
	  boolean res=customerService.createCustomer(customer);
	  if(res) {
			ResponseDto response=new ResponseDto(true,customer);
			return ResponseEntity.ok(response);
	  }else {
			ResponseDto response=new ResponseDto(false,"");
			return ResponseEntity.badRequest()	.body(response);
			}
	}
	
}
