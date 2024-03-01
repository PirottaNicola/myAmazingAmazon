package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dto.InsertProductDTO;
import com.model.dto.ProductInfoDTO;
import com.model.dto.RestockProductDTO;
import com.model.entity.Category;
import com.model.entity.Product;
import com.model.entity.Vendor;
import com.model.entity.VendorProduct;
import com.model.entity.VendorProductPK;
import com.repository.CategoryRepository;
import com.repository.ProductRepository;
import com.repository.VendorProductRepository;
import com.repository.VendorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private VendorRepository vendorRepo;

	@Autowired
	private VendorProductRepository vendorProductRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public VendorProduct insertProduct(InsertProductDTO insertProductDTO) {
		Product product = insertProductDTO.getProduct();
		productRepo.save(product);

		Vendor vendor = vendorRepo.findById(insertProductDTO.getVatNumber())
				.orElseThrow(() -> new RuntimeException("Vendor non trovato!"));

		VendorProduct vendorProduct = new VendorProduct();
		vendorProduct.setId(new VendorProductPK(vendor.getVatNumber(), product.getProductId()));
		vendorProduct.setQuantity(insertProductDTO.getQnt());
		vendorProduct.setPrice(insertProductDTO.getPrice());
		vendorProduct.setAvailable(true);
		vendorProduct.setVendor(vendor);
		vendorProduct.setProduct(product);

		return vendorProductRepo.save(vendorProduct);
	}

	@Override
	public Category insertCategory(Category category) {
		String formattedCategory = capitalizeFirstLetter(category.getCategory());
		category.setCategory(formattedCategory);
		if (categoryRepo.findById(formattedCategory).isPresent()) {
			throw new RuntimeException("Category già esistente");
		}

		return categoryRepo.save(category);
	}

	private String capitalizeFirstLetter(String category) {
		if (category == null || category.isEmpty()) {
			return category;
		}
		return category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase();
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public VendorProduct restockProduct(RestockProductDTO restockProductDTO) {
		Integer qnt = restockProductDTO.getQnt();
		Boolean available = restockProductDTO.getAvailable();
		VendorProductPK id = restockProductDTO.getVendorProductPK();
		VendorProduct relation = vendorProductRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("VendorProduct non trovato!"));

		relation.setQuantity(relation.getQuantity() + qnt);
		if (available != null) {
			relation.setAvailable(available);
		}

		return vendorProductRepo.save(relation);
	}

	@Override
	public List<Product> readProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product readProductById(Integer productId) {
		return productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product non trovato!"));
	}

	@Override
	public ProductInfoDTO getProductInfo(Integer productId) {
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new RuntimeException("Product non trovato!"));

		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		productInfoDTO.setProductId(product.getProductId());
		productInfoDTO.setProductName(product.getProductName());
		productInfoDTO.setCategoryName(product.getCategory().getCategory());
		productInfoDTO
				.setTotalQuantity(product.getVendorProducts().stream().mapToInt(VendorProduct::getQuantity).sum());
		productInfoDTO
				.setAvailableForRestock(product.getVendorProducts().stream().anyMatch(VendorProduct::getAvailable));

		return productInfoDTO;
	}
}
