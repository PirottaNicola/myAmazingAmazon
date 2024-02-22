package com.model.dto;

import java.io.Serializable;

import com.model.entity.VendorProductPK;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class InsertCartProductDTO implements Serializable {

	private static final long serialVersionUID = 643888335726514320L;

	private Integer customerId;

	private VendorProductPK vendorPorductId;

	private Integer quantity;

}
