package com.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString()

@Entity
@Table(name = "vendor_product")
public class VendorProduct {

	@EmbeddedId
	private VendorProductPK id;

	@NotNull
	private Integer quantity;

	@NotNull
	@Positive
	private Double price;

	@NotNull
	private Boolean available;

//	@ManyToOne
//	@JsonBackReference
//	@JoinColumn(name = "vat_number")
//	@MapsId("vatNumber")
//	private Vendor vendor;
//
//	@ManyToOne
//	@JsonBackReference
//	@JoinColumn(name = "product_id")
//	@MapsId("productId")
//	private Product product;

}
