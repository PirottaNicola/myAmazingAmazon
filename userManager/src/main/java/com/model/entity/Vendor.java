package com.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@ToString

@Entity
public class Vendor {

	@Id
	@Size(min = 9, max = 15)
	@NotNull
	@Column(name = "vat_number")
	private String vatNumber;

	@NotNull
	@Size(min = 1, max = 45)
	private String company;

}
