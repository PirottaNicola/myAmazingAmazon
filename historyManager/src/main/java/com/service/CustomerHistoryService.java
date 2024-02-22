package com.service;

import java.util.List;

import com.model.document.CustomerHistory;

public interface CustomerHistoryService {

	CustomerHistory insertCustomerHistory(CustomerHistory customerHistory);

	CustomerHistory updateCustomerHistory(CustomerHistory customerHistory);

	List<CustomerHistory> readCustomersHistory();

	CustomerHistory findOneMongoTemplate(Integer customerId);

	// CustomerHistory findOneExampleMatcher(Integer customerId);
}
