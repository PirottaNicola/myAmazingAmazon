package com.model.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class OrderVO implements Serializable {

	private static final long serialVersionUID = 3317180288873392264L;

	private CustomerVO customer;

	private List<ProductInfoDTO> orders;

}
