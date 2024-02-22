package com.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
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
@ToString(exclude = { "customer", "vendorProduct" })

@Entity
@Table(name = "cart_product")
public class CartProduct {

	@EmbeddedId
	private CartProductPK pk;

	private Integer quantity;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	@MapsId("customerId")
	private Customer customer;

	@ManyToOne
	@JsonBackReference
	@JoinColumns({
			@JoinColumn(name = "vat_number", referencedColumnName = "vat_number", insertable = false, updatable = false),
			@JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false) })
	@MapsId("vendorProductId")
	private VendorProduct vendorProduct;

	public CartProduct(Integer quantity, Customer customer, VendorProduct vendorProduct) {
		super();
		this.quantity = quantity;
		this.customer = customer;
		this.vendorProduct = vendorProduct;
	}

}
