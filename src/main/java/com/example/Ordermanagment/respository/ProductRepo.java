package com.example.Ordermanagment.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ordermanagment.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

}
