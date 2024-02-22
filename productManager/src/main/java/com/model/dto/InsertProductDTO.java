package com.model.dto;

import java.io.Serializable;

import com.model.entity.Product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InsertProductDTO implements Serializable {

	private static final long serialVersionUID = -206849275297645315L;

	@NotNull
	@Size(min = 9, max = 15)
	private String vatNumber;

	@NotNull
	private Integer qnt;

	@NotNull
	@Positive
	private Double price;

	@NotNull
	private Boolean available;

	@Valid
	private Product product;
}
