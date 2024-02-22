package com.model.dto;

import java.io.Serializable;

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

public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = -5806833395713782386L;

	private Integer customerId;

	private String firstName;

	private String lastName;

	private String email;

	private String address;

}
