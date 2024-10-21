package com.example.studentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentsystem.models.Customer;
import com.example.studentsystem.services.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public String add(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return "New customer is added";
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer != null) {
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            customerService.saveCustomer(existingCustomer);
            return "Customer updated successfully";
        } else {
            return "Customer not found";
        }
    }

    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            customerService.deleteCustomer(id);
            return "Customer deleted successfully";
        } else {
            return "Customer not found";
        }
    }
}
