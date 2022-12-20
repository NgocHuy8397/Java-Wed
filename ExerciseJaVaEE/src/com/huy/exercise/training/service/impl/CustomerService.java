package com.huy.exercise.training.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huy.exercise.training.database.CustomerDAO;
import com.huy.exercise.training.model.Customer;
import com.huy.exercise.training.service.ICustomerService;

public class CustomerService implements ICustomerService{
    CustomerDAO customerDAO = new CustomerDAO();
    
    private static List<Customer> customer = new ArrayList<>();
    
    static {
        for (int i = 0; i < 10; i++) {
            Customer c = new Customer();
            c.setId(i);
            c.setName("Nguyen Van " + i);
            customer.add(c);
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer); 
    }

    @Override
    public List<Customer> getCustomer() {
        return customerDAO.info();
    }

    @Override
    public void deleteCustomerById(int id) {
        Iterator<Customer> iterator = customer.iterator();
        while (iterator.hasNext()) {
            Customer c = iterator.next();
            if (c.getId() == id) {
                iterator.remove();
                break;
            }
        }
        
        customerDAO.delete(id);
        
    }

    @Override
    public Customer getCustomerById(int id) {
        
        return customerDAO.getCustomerById(id);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerDAO.editCustomer(customer); 
    }

    @Override
    public List<Customer> searchCustomer(String name , String gender, String phone, String membershipLevel) {
        return customerDAO.searchCustomer(name,gender,phone,membershipLevel);
        
    }
    
}
