package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.entity.Customer;
import com.model.entity.Vendor;
import com.service.CustomerService;
import com.service.VendorService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/userManager")
public class UserManagerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private VendorService vendorService;

	@PostMapping("/insertCustomer")
	public ResponseEntity<?> insertCustomer(@RequestBody @Valid Customer customer) {

		Customer body = customerService.insertCustomer(customer);

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@PostMapping("/insertVendor")
	public ResponseEntity<?> insertVendor(@RequestBody @Valid Vendor vendor) {

		Vendor body = vendorService.insertVendor(vendor);

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@PostMapping("/updateCustomer")
	public ResponseEntity<?> updateCustomer(@RequestBody @Valid Customer customer) {

		Customer body = customerService.insertCustomer(customer);

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@PostMapping("/updateVendor")
	public ResponseEntity<?> updateVendor(@RequestBody @Valid Vendor vendor) {

		Vendor body = vendorService.insertVendor(vendor);

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@GetMapping("/readCustomers")
	public ResponseEntity<?> readCustomers() {

		List<Customer> body = customerService.readCustomers();

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@GetMapping("/readVendors")
	public ResponseEntity<?> readVendors() {

		List<Vendor> body = vendorService.readVendors();

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@GetMapping("/readCustomer/{customerId}")
	public ResponseEntity<?> readCustomer(@PathVariable Integer customerId) {

		Customer body = customerService.readCustomerById(customerId);

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@GetMapping("/readVendor/{vatNumber}")
	public ResponseEntity<?> readVendor(@Valid @PathVariable @Size(min = 9, max = 15) String vatNumber) {

		Vendor body = vendorService.readVendorByVatNumber(vatNumber);

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

}
