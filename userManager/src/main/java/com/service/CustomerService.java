package com.service;

import java.util.List;

import com.model.entity.Customer;

public interface CustomerService {

	Customer insertCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	List<Customer> readCustomers();

	Customer readCustomerById(Integer customerId);

}
