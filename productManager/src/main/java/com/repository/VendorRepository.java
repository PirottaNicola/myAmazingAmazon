package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, String> {

}
