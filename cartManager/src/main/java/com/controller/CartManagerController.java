package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.model.dto.InsertCartProductDTO;
import com.model.entity.CartProduct;
import com.model.entity.CartProductPK;
import com.model.entity.Customer;
import com.model.vo.OrderVO;
import com.service.CartProductService;
import com.service.CustomerService;

@RestController
@RequestMapping("/cartManager")
public class CartManagerController {

	@Autowired
	private CartProductService cartProductService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ControllerHelper controllerHelper;

	@Value("${historymanager.url}")
	private String historyManagerUrl;

	//

	@PostMapping("/insertCartProduct")
	public ResponseEntity<?> insertCartProduct(@RequestBody InsertCartProductDTO insertCartProductDTO) {
		CartProduct body = cartProductService.insertCartProduct(insertCartProductDTO);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCartProduct")
	public ResponseEntity<?> deleteCartProduct(@RequestBody CartProductPK primaryKey) {
		cartProductService.deleteCartProduct(primaryKey);
		return new ResponseEntity<>("Cancellazione avvenuta con successo!", HttpStatus.OK);
	}

	@GetMapping("/readCartProductsById/{customerId}")
	public ResponseEntity<?> readCartProductsById(@PathVariable Integer customerId) {
		List<CartProduct> body = cartProductService.readCartProductsByCustomerId(customerId);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	@PostMapping("/sendOrder/{customerId}")
	public ResponseEntity<?> sendOrder(@PathVariable Integer customerId) {

		/*
		 * 1. Faccio la query per recuperare le info del customer,
		 * 
		 * 2. Faccio la query per recuperare tutto il carrello del customerId,
		 * 
		 * 3. Wrappo le informazioni che mi serve spedire dentro OrderVO (il customer e
		 * la lista di cartProduct) e mando il tutto all'historymanager,
		 * 
		 * 4. Opzionale : dopo che l'historymanager ha fatto il suo lavoro, posso
		 * pensare di restituire qualcosa di vagamente simile ad una fattura o mandare
		 * un'email o...
		 * 
		 * 5. Svuoto il carrello.
		 */

		Customer customer = customerService.findById(customerId);

		//

		List<CartProduct> cart = customer.getCartProduct();

		//

		OrderVO orderVO = controllerHelper.mapToOrderVO(customer);

		HttpEntity<OrderVO> request = new HttpEntity<>(orderVO);

		restTemplate.exchange(historyManagerUrl, HttpMethod.POST, request, Void.class);

		Double functionalTotal = cart.stream().mapToDouble(c -> c.getVendorProduct().getPrice() * c.getQuantity())
				.sum();

		String responseBody = "Totale da pagare: " + functionalTotal;

		//

		cartProductService.deleteCartByCustomerId(customerId);
		return new ResponseEntity<>(responseBody, HttpStatus.OK);
	}

}
