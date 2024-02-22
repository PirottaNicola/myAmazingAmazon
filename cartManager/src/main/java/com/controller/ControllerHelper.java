package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.model.entity.CartProduct;
import com.model.entity.Customer;
import com.model.vo.CustomerVO;
import com.model.vo.OrderVO;
import com.model.vo.ProductInfoDTO;

@Component
public class ControllerHelper {

	public OrderVO mapToOrderVO(Customer customer) {

		CustomerVO customerVO = mapCustomerVO(customer);
		List<ProductInfoDTO> orders = new ArrayList<>();

		for (CartProduct cp : customer.getCartProduct()) {
			ProductInfoDTO singleOrderVO = mapToSingleOrderVO(cp);
			orders.add(singleOrderVO);
		}

		return new OrderVO(customerVO, orders);
	}

	private CustomerVO mapCustomerVO(Customer customer) {
		CustomerVO result = new CustomerVO();
		result.setFirstName(customer.getFirstName());
		result.setLastName(customer.getLastName());
		result.setEmail(customer.getEmail());
		result.setAddress(customer.getAddress());
		result.setCustomerId(customer.getCustomerId());

		return result;
	}

	private ProductInfoDTO mapToSingleOrderVO(CartProduct cartProduct) {
		ProductInfoDTO result = new ProductInfoDTO();
		result.setPrice(cartProduct.getVendorProduct().getPrice());
		result.setQuantity(cartProduct.getQuantity());
		result.setProductId(cartProduct.getVendorProduct().getId().getProductId());
		result.setVatNumber(cartProduct.getVendorProduct().getId().getVatNumber());
		return result;
	}
}
