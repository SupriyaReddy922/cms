package com.Supriya.customerManagementSystem.service;

import com.Supriya.customerManagementSystem.exception.CustomerNotFoundException;
import com.Supriya.customerManagementSystem.dao.CustomerDAO;
import com.Supriya.customerManagementSystem.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;


    public Customer addCustomer(Customer c){

        return customerDAO.save(c);
    }

    public List<Customer> getAllCustomers(){

        return customerDAO.findAll();
    }

    public Customer getCustomerById(int Customer_id){

        Optional<Customer> optionalCustomer=customerDAO.findById(Customer_id);
        if(!optionalCustomer.isPresent()){
            throw new CustomerNotFoundException("Record not available");
        }

        return optionalCustomer.get();

    }
    public Customer updateCustomer(int Customer_id,Customer c){
        Customer customer=customerDAO.findById(Customer_id).get();
        customer.setCustomer_lastName(c.getCustomer_lastName());
        customer.setCustomer_email(c.getCustomer_email());
        customer.setCustomer_firstName(c.getCustomer_firstName());
        return  customer;

    }

   public  void deleteCustomer(int Customer_id){

       customerDAO.deleteById(Customer_id);
   }




}
