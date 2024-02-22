package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.entity.Customer;
import com.repository.CustomerRepository;

@Service

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;

	@Override
	public Customer findById(Integer customerId) {
		return repo.findById(customerId).get();
	}

}
