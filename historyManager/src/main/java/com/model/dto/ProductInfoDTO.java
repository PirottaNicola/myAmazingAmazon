package com.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ProductInfoDTO implements Serializable {

	private static final long serialVersionUID = -8273061946220264941L;

	private String vatNumber;

	private Integer productId;

	private Integer qnt;

	private Double price;

}
