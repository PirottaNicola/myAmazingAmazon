package com.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@ToString(exclude = { "cartProduct" })

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

	@OneToMany(mappedBy = "vendorProduct")
	@JsonBackReference("vendorProduct")
	private List<CartProduct> cartProduct = new ArrayList<>();

//	@ManyToOne
//	@JsonBackReference
//	@JoinColumn(name = "vat_number")
//	@MapsId("vatNumber")
//	private Vendor vendor;
//
//	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JsonBackReference
//	@JoinColumn(name = "product_id")
//	@MapsId("productId")
//	private Product product;

}
