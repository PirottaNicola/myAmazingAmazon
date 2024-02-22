package com.service;

import java.util.List;

import com.model.dto.InsertCartProductDTO;
import com.model.entity.CartProduct;
import com.model.entity.CartProductPK;

public interface CartProductService {

	CartProduct insertCartProduct(InsertCartProductDTO dto);

	void deleteCartProduct(CartProductPK vendorPorductId);

	void deleteCartByCustomerId(Integer customerID);

	List<CartProduct> readCartProductsByCustomerId(Integer customerId);

	void deleteCustomerCart(Integer customerId);
}
