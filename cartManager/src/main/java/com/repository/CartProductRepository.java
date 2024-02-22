package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.entity.CartProduct;
import com.model.entity.CartProductPK;

public interface CartProductRepository extends JpaRepository<CartProduct, CartProductPK> {

//	@Query("SELECT cp FROM CartProduct cp WHERE cp.customer.customerId = :customerId")
//	List<CartProduct> readCartProductsByCustomerId(Integer customerId);

	void deleteByCustomerCustomerId(Integer customerId);
}
