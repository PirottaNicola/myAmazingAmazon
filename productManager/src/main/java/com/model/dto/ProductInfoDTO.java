package com.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ProductInfoDTO {

	private Integer productId;
	private String productName;
	private String categoryName;
	private int totalQuantity;
	private boolean availableForRestock;
}
