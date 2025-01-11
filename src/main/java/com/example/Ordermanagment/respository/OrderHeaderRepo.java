package com.example.Ordermanagment.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ordermanagment.entity.OrderHeader;

@Repository
public interface OrderHeaderRepo extends JpaRepository<OrderHeader,Integer>{

}
