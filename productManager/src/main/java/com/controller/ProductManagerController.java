package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.dto.InsertProductDTO;
import com.model.dto.ProductInfoDTO;
import com.model.dto.RestockProductDTO;
import com.model.entity.Category;
import com.model.entity.Product;
import com.model.entity.VendorProduct;
import com.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productManager")
public class ProductManagerController {

	@Autowired
	private ProductService service;

	@PostMapping("/insertProduct")
	public ResponseEntity<?> insertProduct(@RequestBody @Valid InsertProductDTO insertProductDTO) {

		VendorProduct body = service.insertProduct(insertProductDTO);

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@PostMapping("/insertCategory")
	public ResponseEntity<?> insertCategory(@RequestBody @Valid Category category) {

		Category body = service.insertCategory(category);

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@PostMapping("/updateProduct")
	public ResponseEntity<?> updateProduct(@RequestBody @Valid Product product) {

		Product body = service.updateProduct(product);

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@PostMapping("/restockProduct")
	public ResponseEntity<?> restockProduct(@RequestBody @Valid RestockProductDTO restockProductDTO) {
		VendorProduct body = service.restockProduct(restockProductDTO);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	@GetMapping("/readProducts")
	public ResponseEntity<?> readProducts() {

		List<Product> body = service.readProducts();

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@GetMapping("/readProduct/{productId}")
	public ResponseEntity<?> readProduct(@PathVariable Integer productId) {

		Product body = service.readProductById(productId);

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@GetMapping("/getProductInfo/{productId}")
	public ResponseEntity<?> getProductInfo(@PathVariable Integer productId) {

		ProductInfoDTO body = service.getProductInfo(productId);

		return new ResponseEntity<>(body, HttpStatus.OK);

	}
}
