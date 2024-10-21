package com.example.studentsystem.services;

import java.util.List;

import com.example.studentsystem.models.Customer;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomer();
    Customer getCustomerById(Long id);
    void deleteCustomer(Long id);
}
