package com.service;

import java.util.List;

import com.model.dto.InsertProductDTO;
import com.model.dto.ProductInfoDTO;
import com.model.dto.RestockProductDTO;
import com.model.entity.Category;
import com.model.entity.Product;
import com.model.entity.VendorProduct;

public interface ProductService {

	VendorProduct insertProduct(InsertProductDTO insertProductDTO);

	Category insertCategory(Category category);

	Product updateProduct(Product product);

	VendorProduct restockProduct(RestockProductDTO restockProductDTO);

	List<Product> readProducts();

	Product readProductById(Integer productId);

	ProductInfoDTO getProductInfo(Integer productId);
}
