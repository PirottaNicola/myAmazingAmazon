package com.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = { "vendorProducts" })

@Entity
public class Vendor {

	@Id
	@NotNull
	@Size(min = 9, max = 15)
	@Column(name = "vat_number")
	private String vatNumber;

	@NotNull
	@Size(min = 1, max = 45)
	private String company;

	@NotNull
	private Boolean isActive;

	@JsonManagedReference(value = "product")
	@OneToMany(mappedBy = "vendor")
	private List<VendorProduct> vendorProducts = new ArrayList<>();

}
