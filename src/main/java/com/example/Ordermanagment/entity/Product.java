package com.example.Ordermanagment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name", length = 100, nullable = false)
    private String productName;

    @Column(name = "color", length = 30)
    private String color;

    @Column(name = "size", length = 10)
    private String size;
    
    public Product() {
    	
    }

    public Product(Integer productId, String productName, String color, String size) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.color = color;
		this.size = size;
	}
    
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
