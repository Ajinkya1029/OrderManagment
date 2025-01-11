package com.example.Ordermanagment.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.Ordermanagment.entity.ContactMech;
import com.example.Ordermanagment.entity.Customer;
import com.example.Ordermanagment.entity.OrderItem;

public class OrderListResponseDto {

	 public LocalDate orderDate;
	 public Customer customer;
	 public ContactMech shippingContactMech;
	 public ContactMech billingContactMech;
	 public List<OrderItem>orderItems;

	 public OrderListResponseDto() {
	        this.orderItems = new ArrayList<>();  
	    }
}
