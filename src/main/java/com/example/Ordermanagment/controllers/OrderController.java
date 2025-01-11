package com.example.Ordermanagment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ordermanagment.dto.OrderItemDto;
import com.example.Ordermanagment.dto.OrderListDto;
import com.example.Ordermanagment.dto.OrderListResponseDto;
import com.example.Ordermanagment.dto.ResponseDto;
import com.example.Ordermanagment.entity.OrderItem;
import com.example.Ordermanagment.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/create")
	public ResponseEntity<ResponseDto>createOrder(@RequestBody OrderListDto orderDto){
		boolean res=orderService.createOrder(orderDto);
		if(res) {
			ResponseDto response=new ResponseDto(true,orderDto);
			return ResponseEntity.ok(response);
	  }else {
			ResponseDto response=new ResponseDto(false,"");
			return ResponseEntity.badRequest()	.body(response);
			}
		
	}
	@GetMapping("/get")
	public ResponseEntity<ResponseDto>fetchOrder(@RequestParam(name="orderHeader",required=true)Integer orderHeader){
		OrderListResponseDto response=orderService.getOrder(orderHeader);
		if(response!=null) {
			ResponseDto data=new ResponseDto(true,response);
			return ResponseEntity.ok(data);
		}else {
			ResponseDto data=new ResponseDto(false,"");
			return ResponseEntity.badRequest().body(data);
		}
	}
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<ResponseDto>deleteOrder(@PathVariable Integer orderId){
		System.out.print(orderId);
		boolean response=orderService.deleteOrder(orderId);
		if(response) {
			ResponseDto data=new ResponseDto(true,"");
			return ResponseEntity.ok(data);
		}else {
			ResponseDto data=new ResponseDto(false,"");
			return ResponseEntity.badRequest().body(data);		}
		
	}
	@PutMapping("/update/{orderId}")
	public ResponseEntity<ResponseDto>updateOrder(@PathVariable Integer orderId,@RequestBody OrderListDto orderList){
		boolean res=orderService.updateOrder(orderId, orderList);
		if(res) {
			ResponseDto data=new ResponseDto(true,"Updated");
			return ResponseEntity.ok(data);
		}else {

			ResponseDto data=new ResponseDto(false,"Updated");
			return ResponseEntity.badRequest().body(data);
		}
	}
	
	@PostMapping("/addItem")
	public ResponseEntity<ResponseDto>addItem(@RequestParam (name="orderId",required=true)Integer orderId,@RequestBody OrderItemDto orderItem){
	boolean res=orderService.addItem(orderId, orderItem);
	if(res) {
		ResponseDto data=new ResponseDto(true,"Saved");
		return ResponseEntity.ok(data);
	}else {
		ResponseDto data=new ResponseDto(false,"Failed");
		return ResponseEntity.badRequest().body(data);
		}
	}
	
	@DeleteMapping("/deleteItem/{orderItemId}")
	public ResponseEntity<ResponseDto>deleteItem(@PathVariable Integer orderItemId){
		
		boolean res=orderService.deleteItem(orderItemId);
		if(res) {
			ResponseDto data=new ResponseDto(true,"Deleted");
			return ResponseEntity.ok(data);
		}else {
			ResponseDto data=new ResponseDto(false,"Failed");
			return ResponseEntity.badRequest().body(data);
			}
	}
	
}
