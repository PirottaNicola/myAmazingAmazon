package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dto.InsertCartProductDTO;
import com.model.entity.CartProduct;
import com.model.entity.CartProductPK;
import com.model.entity.Customer;
import com.model.entity.VendorProduct;
import com.model.entity.VendorProductPK;
import com.repository.CartProductRepository;
import com.repository.CustomerRepository;
import com.repository.VendorProductRepository;

import jakarta.transaction.Transactional;

@Service
public class CartProductServiceImpl implements CartProductService {

	@Autowired
	private CartProductRepository repo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private VendorProductRepository vendorProductRepo;

	@Override
	public CartProduct insertCartProduct(InsertCartProductDTO dto) {

		Customer customer = customerRepo.findById(dto.getCustomerId()).get();

		VendorProductPK vendorProductId = dto.getVendorPorductId();

		VendorProduct vendorProduct = vendorProductRepo.findById(vendorProductId).get();

		CartProductPK cartProductPK = new CartProductPK(vendorProductId, customer.getCustomerId());

		CartProduct cartProduct = new CartProduct(cartProductPK, dto.getQuantity(), customer, vendorProduct);

		return repo.save(cartProduct);
	}

	@Override
	public void deleteCartProduct(CartProductPK primaryKey) {
		repo.deleteById(primaryKey);
	}

	@Override
	public List<CartProduct> readCartProductsByCustomerId(Integer customerId) {
		return customerRepo.findById(customerId).get().getCartProduct();
	}

	@Override
	@Transactional
	public void deleteCartByCustomerId(Integer customerID) {
		repo.deleteByCustomerCustomerId(customerID);

	}

	@Override
	@Transactional
	public void deleteCustomerCart(Integer customerId) {
		Customer customer = customerRepo.findById(customerId).get();

	}

}
