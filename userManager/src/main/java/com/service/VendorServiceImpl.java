package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.entity.Vendor;
import com.repo.VendorRepo;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepo repo;

	@Override
	public Vendor insertVendor(Vendor vendor) {

		return repo.save(vendor);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		return repo.save(vendor);
	}

	@Override
	public List<Vendor> readVendors() {
		return repo.findAll();
	}

	@Override
	public Vendor readVendorByVatNumber(String vatNumber) {
		return repo.findById(vatNumber).get();
	}

}
