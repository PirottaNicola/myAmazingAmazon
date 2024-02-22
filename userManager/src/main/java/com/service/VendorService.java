package com.service;

import java.util.List;

import com.model.entity.Vendor;

public interface VendorService {

	Vendor insertVendor(Vendor vendor);

	Vendor updateVendor(Vendor vendor);

	List<Vendor> readVendors();

	Vendor readVendorByVatNumber(String vatNumber);

}
