package com.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Embeddable
public class CartProductPK implements Serializable {

	private static final long serialVersionUID = -8044908215997581742L;

	@Embedded
	private VendorProductPK vendorProductPK;

	@Column(name = "customer_id", insertable = false, updatable = false)
	private Integer customerId;
}
