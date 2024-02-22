package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.document.CustomerHistory;

public interface CustomerHistoryRepository extends MongoRepository<CustomerHistory, String> {

}
