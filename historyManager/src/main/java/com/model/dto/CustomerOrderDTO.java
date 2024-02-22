package com.model.dto;

import java.io.Serializable;
import java.util.List;

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

public class CustomerOrderDTO implements Serializable {

	private static final long serialVersionUID = 7780497472968733166L;

	private CustomerDTO customer;

	private List<ProductInfoDTO> orders;

}
