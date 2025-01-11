package com.example.Ordermanagment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ordermanagment.dto.ResponseDto;
import com.example.Ordermanagment.entity.Product;
import com.example.Ordermanagment.services.ProductService;

@RestController
@RequestMapping("/product")

public class ProductController {
	@Autowired
	private ProductService productService;
	
   @PostMapping("/create")
	public ResponseEntity<ResponseDto>createProduct(@RequestBody Product product){
		boolean res=productService.createProduct(product);
		  if(res) {
				ResponseDto response=new ResponseDto(true,product);
				return ResponseEntity.ok(response);
		  }else {
				ResponseDto response=new ResponseDto(false,"");
				return ResponseEntity.badRequest()	.body(response);
				}
	}
}
