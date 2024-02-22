package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.entity.Customer;
import com.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo repo;

	@Override
	public Customer insertCustomer(Customer customer) {

		return repo.save(customer);

	}

	@Override
	public Customer updateCustomer(Customer customer) {

		return repo.save(customer);

	}

	@Override
	public List<Customer> readCustomers() {

		return repo.findAll();
	}

	@Override
	public Customer readCustomerById(Integer customerId) {

		return repo.findById(customerId).get();
	}

}
