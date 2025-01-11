package com.example.Ordermanagment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int id;
	
	@Column(name="first_name",nullable=true,length=50)
	private String firstname;
	
	@Column(name="last_name",nullable=true,length=50)
	private String lastname;
	
	public Customer() {
		
	}
	
	public Customer(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
