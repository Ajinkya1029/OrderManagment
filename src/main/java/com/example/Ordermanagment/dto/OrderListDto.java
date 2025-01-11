package com.example.Ordermanagment.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.Ordermanagment.entity.ContactMech;
import com.example.Ordermanagment.entity.Customer;
import com.example.Ordermanagment.entity.OrderItem;

public class OrderListDto {

	 public LocalDate orderDate;
	 public int customer;
	 public int shippingContactMech;
	 public int billingContactMech;
	 public List<OrderItem>orderItems;
}
