package com.example.Ordermanagment.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ordermanagment.entity.ContactMech;

@Repository
public interface ContactMechRepo extends JpaRepository<ContactMech,Integer>{

	
}
