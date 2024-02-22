package com.model.dto;

import java.io.Serializable;

import com.model.entity.VendorProductPK;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestockProductDTO implements Serializable {

	private static final long serialVersionUID = 1946283426917509030L;

	@NotNull
	@Positive
	private Integer qnt;

	@NotNull
	private Boolean available;

	private VendorProductPK vendorProductPK;
}
