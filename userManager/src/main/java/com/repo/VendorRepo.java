package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.entity.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, String> {

}
