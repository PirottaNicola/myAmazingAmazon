package com.model.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerVO implements Serializable {

	private static final long serialVersionUID = 6102488652861718811L;

	private Integer customerId;

	private String firstName;

	private String lastName;

	private String email;

	private String address;

}
