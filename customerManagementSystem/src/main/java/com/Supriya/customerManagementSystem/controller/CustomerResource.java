package com.Supriya.customerManagementSystem.controller;

import com.Supriya.customerManagementSystem.model.Customer;
import com.Supriya.customerManagementSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerResource {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public Customer addCustomer(@RequestBody Customer c){
        return customerService.addCustomer(c);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{customer_id}")
    public Customer getCustomerById(@PathVariable int customer_id){
        return customerService.getCustomerById(customer_id);
    }

    @PutMapping("/{customer_id}")
    public Customer updatecustomer(@PathVariable int customer_id,@RequestBody Customer customer){
        return customerService.updateCustomer(customer_id,customer);
    }

    @DeleteMapping("/{customer_id}")
    public void deleteCustomer(@PathVariable int customer_id){
        customerService.deleteCustomer(customer_id);
    }

}
