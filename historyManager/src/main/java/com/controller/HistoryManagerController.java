package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.document.CustomerHistory;
import com.model.dto.CustomerOrderDTO;
import com.model.dto.OrderHistoryEntryDTO;
import com.service.CustomerHistoryService;

@RequestMapping("/historyManager")
@RestController
public class HistoryManagerController {

	@Autowired
	private CustomerHistoryService service;

	@PostMapping("/processOrder")
	public void processOrder(@RequestBody CustomerOrderDTO customerOrderDTO) {

		Integer customerId = customerOrderDTO.getCustomer().getCustomerId();

		CustomerHistory customerHistory = service.findOneMongoTemplate(customerId);

		if (customerHistory == null) {

			customerHistory = mapToCustomerHistory(customerOrderDTO);
			service.insertCustomerHistory(customerHistory);
		} else {
			OrderHistoryEntryDTO newEntry = new OrderHistoryEntryDTO(customerOrderDTO.getOrders());
			service.updateCustomerHistory(customerHistory);
		}

		CustomerHistory mappedCustomerHistory = mapToCustomerHistory(customerOrderDTO);

		boolean esiste = true;

		if (esiste) {

		} else {
			CustomerHistory inserted = service.insertCustomerHistory(mappedCustomerHistory);
			System.err.println(inserted);
		}

	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		List<CustomerHistory> body = service.readCustomersHistory();
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	private CustomerHistory mapToCustomerHistory(CustomerOrderDTO customerOrderDTO) {
		OrderHistoryEntryDTO orderEntry = new OrderHistoryEntryDTO(customerOrderDTO.getOrders());

		List<OrderHistoryEntryDTO> customerHistory = new ArrayList<>();

		customerHistory.add(orderEntry);

		return new CustomerHistory(customerOrderDTO.getCustomer(), customerHistory);

	}

}
