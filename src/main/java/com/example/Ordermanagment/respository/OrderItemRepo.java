package com.example.Ordermanagment.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Ordermanagment.entity.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem,Integer> {
  @Query("select u from OrderItem u where u.order.orderId=:orderId")
	List<OrderItem>getItems(Integer orderId);
  
  @Modifying
  @Query("delete  from OrderItem u where u.order.orderId=:orderId")
    void deleteItem(@Param("orderId")Integer orderId);
}
