package com.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter

@Embeddable
public class VendorProductPK implements Serializable {

	private static final long serialVersionUID = -5150562976768159214L;

	@Column(name = "vat_number", insertable = false, updatable = false)
	private String vatNumber;

	@Column(name = "product_id", insertable = false, updatable = false)
	private Integer productId;

}
