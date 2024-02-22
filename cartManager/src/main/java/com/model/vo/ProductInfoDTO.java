package com.model.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductInfoDTO implements Serializable {

	private static final long serialVersionUID = 411768570962030239L;

	private String vatNumber;

	private Integer productId;

	private Integer quantity;

	private Double price;

}
