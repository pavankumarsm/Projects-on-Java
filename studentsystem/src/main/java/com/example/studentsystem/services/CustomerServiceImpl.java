package com.example.studentsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentsystem.models.Customer;
import com.example.studentsystem.repository.CustomerRepository;

@Service
public class CustomerServiceImpl  implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}


	@Override
	public List<Customer> getAllCustomer() {
		
		return customerRepository.findAll();
	}


	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
