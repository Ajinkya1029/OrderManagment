package com.example.Ordermanagment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ordermanagment.entity.Product;
import com.example.Ordermanagment.respository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public boolean createProduct(Product product) {
		Product newProduct=new Product();
		newProduct.setProductName(product.getProductName());
		newProduct.setColor((product.getColor()));
		newProduct.setSize(product.getSize());
		productRepo.save(newProduct);
		return true;
	}
}
