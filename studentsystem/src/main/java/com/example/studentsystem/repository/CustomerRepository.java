package com.example.studentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentsystem.models.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	

}
