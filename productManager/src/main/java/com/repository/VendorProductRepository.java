package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.entity.VendorProduct;
import com.model.entity.VendorProductPK;

public interface VendorProductRepository extends JpaRepository<VendorProduct, VendorProductPK> {

}
