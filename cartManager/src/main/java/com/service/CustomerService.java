package com.service;

import com.model.entity.Customer;

public interface CustomerService {

	Customer findById(Integer customerId);

}
