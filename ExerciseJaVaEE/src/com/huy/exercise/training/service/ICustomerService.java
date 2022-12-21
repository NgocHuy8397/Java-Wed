package com.huy.exercise.training.service;

import java.util.List;

import com.huy.exercise.training.model.Customer;

public interface ICustomerService {
    public List<Customer> searchCustomers(String name , String gender, String phone, String membershipLevel);
    public void editCustomer(Customer customer);
    public void addCustomer(Customer customer);
    public List<Customer> getCustomer();
    public void deleteCustomerById(int id);
    public Customer getCustomerById(int id);
       
}
