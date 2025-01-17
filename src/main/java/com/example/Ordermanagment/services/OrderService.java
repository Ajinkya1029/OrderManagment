package com.example.Ordermanagment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ordermanagment.dto.OrderItemDto;
import com.example.Ordermanagment.dto.OrderListDto;
import com.example.Ordermanagment.dto.OrderListResponseDto;
import com.example.Ordermanagment.entity.ContactMech;
import com.example.Ordermanagment.entity.Customer;
import com.example.Ordermanagment.entity.OrderHeader;
import com.example.Ordermanagment.entity.OrderItem;
import com.example.Ordermanagment.entity.Product;
import com.example.Ordermanagment.respository.ContactMechRepo;
import com.example.Ordermanagment.respository.CustomerRepo;
import com.example.Ordermanagment.respository.OrderHeaderRepo;
import com.example.Ordermanagment.respository.OrderItemRepo;
import com.example.Ordermanagment.respository.ProductRepo;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	private OrderHeaderRepo headerRepo;
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private ContactMechRepo mechRepo;
	
	@Autowired
	private OrderItemRepo orderRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	public boolean createOrder(OrderListDto orderDto) {
		OrderHeader newHeader= new OrderHeader();
		newHeader.setOrderDate(orderDto.orderDate);
		Customer foundCustomer=customerRepo.getById(orderDto.customer);
		newHeader.setCustomer(foundCustomer);
		ContactMech foundMech=mechRepo.getById(orderDto.billingContactMech);
		newHeader.setBillingContactMech(foundMech);
		ContactMech shipMech=mechRepo.getById(orderDto.shippingContactMech);
		newHeader.setShippingContactMech(shipMech);
		
		headerRepo.save(newHeader);
		
		List<OrderItem>newItems=orderDto.orderItems;
		for(OrderItem item:newItems) {
			OrderItem items=new OrderItem();
			items.setOrder(newHeader);
			items.setProduct(item.getProduct());
			items.setQuantity(item.getQuantity());
			items.setStatus(item.getStatus());
			orderRepo.save(items);
		}
		
		return true;
	}
	public OrderListResponseDto getOrder(Integer orderHeader) {
		Optional<OrderHeader> foundHeader=headerRepo.findById(orderHeader);
		OrderListResponseDto newDto=new OrderListResponseDto();
		if(foundHeader.isPresent()) {
			newDto.orderDate=foundHeader.get().getOrderDate();
			newDto.customer=foundHeader.get().getCustomer();
		    newDto.shippingContactMech=foundHeader.get().getShippingContactMech();
		    newDto.billingContactMech=foundHeader.get().getBillingContactMech();
		    List<OrderItem>items=orderRepo.getItems(orderHeader);
		    
		    for(OrderItem item:items) {
		    	OrderItem newItem= new OrderItem();
		    	newItem.setProduct(item.getProduct());
		    	newItem.setQuantity(item.getQuantity());
		    	newItem.setStatus(item.getStatus());
		    	newItem.setOrder(item.getOrder());
		    	newDto.orderItems.add(newItem);
		    }
		    }
		return newDto;	
	}
	@Transactional
	public boolean deleteOrder(Integer orderId) {
		System.out.print(orderId);
		if(headerRepo.existsById(orderId)) {
			orderRepo.deleteItem(orderId);
			headerRepo.deleteById(orderId);
			return true;
		}
		return false;
	}
	
	public boolean updateOrder(Integer orderId,OrderListDto orderList) {
		Optional<OrderHeader> foundHeader=headerRepo.findById(orderId);
		if(foundHeader.isPresent()) {
			Optional<ContactMech>foundBillMech=mechRepo.findById(orderList.billingContactMech);
			Optional<ContactMech>foundShipMech=mechRepo.findById(orderList.shippingContactMech);
			if(foundBillMech.isPresent()&&foundShipMech.isPresent()) {
				OrderHeader header=foundHeader.get();
				System.out.println(orderList.billingContactMech);
				System.out.print(orderList.shippingContactMech);
				header.setBillingContactMech(foundBillMech.get());
				header.setShippingContactMech(foundShipMech.get());
				headerRepo.save(header);
				return true;
			}
		}
	return false;	
	}
	
	public boolean addItem(Integer orderId,OrderItemDto orderItem) {
		OrderItem newItem=new OrderItem();
		Optional<Product>foundProduct=productRepo.findById(orderItem.productId);
		Optional<OrderHeader>foundHeader=headerRepo.findById(orderId);
		if(foundProduct.isPresent()&&foundHeader.isPresent()) {
			newItem.setProduct(foundProduct.get());
			newItem.setQuantity(orderItem.quantity);
			newItem.setStatus(orderItem.status);
			newItem.setOrder(foundHeader.get());
			orderRepo.save(newItem);
			return true;
		}
		return false;
	}
	public boolean deleteItem(Integer orderId) {
		try {
			orderRepo.deleteById(orderId);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
}
