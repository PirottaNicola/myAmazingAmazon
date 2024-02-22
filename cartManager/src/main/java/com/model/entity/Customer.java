package com.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
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
@ToString(exclude = "cartProduct")

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "first_name")
	@Size(max = 45, min = 1)
	private String firstName;

	@Column(name = "last_name")
	@Size(max = 45, min = 1)
	private String lastName;

	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$")
	private String email;

	private String address;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	@JsonBackReference("customer")
	private List<CartProduct> cartProduct = new ArrayList<>();

	public Customer(@Size(max = 45, min = 1) String firstName, @Size(max = 45, min = 1) String lastName,
			@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$") String email, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}

}
