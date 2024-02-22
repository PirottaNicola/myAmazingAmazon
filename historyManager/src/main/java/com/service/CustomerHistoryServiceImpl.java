package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.model.document.CustomerHistory;
import com.repository.CustomerHistoryRepository;

@Service
public class CustomerHistoryServiceImpl implements CustomerHistoryService {

	@Autowired
	private CustomerHistoryRepository repo;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public CustomerHistory insertCustomerHistory(CustomerHistory customerHistory) {
		return repo.insert(customerHistory);
	}

	@Override
	public CustomerHistory updateCustomerHistory(CustomerHistory customerHistory) {
		return repo.save(customerHistory);
	}

	@Override
	public List<CustomerHistory> readCustomersHistory() {
		return repo.findAll();
	}

	@Override
	public CustomerHistory findOneMongoTemplate(Integer customerId) {
		Query query = new Query(Criteria.where("customer.customerId").is(customerId));
		return mongoTemplate.findOne(query, CustomerHistory.class);
	}

	/*
	 * @Override public CustomerHistory findOneExampleMatcher(Integer customerId) {
	 * CustomerHistory example = new CustomerHistory(); example.setCustomer(new
	 * CustomerDTO()); example.getCustomer().setCustomerId(customerId);
	 * ExampleMatcher matcher = ExampleMatcher.matchingAny(); return
	 * repo.findOne(Example.of(example, matcher)).orElse(null); }
	 */

}
