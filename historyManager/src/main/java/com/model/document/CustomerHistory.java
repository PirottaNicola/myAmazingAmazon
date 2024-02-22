package com.model.document;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.model.dto.CustomerDTO;
import com.model.dto.OrderHistoryEntryDTO;

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

@Document(collection = "customer_history")
public class CustomerHistory {

	@MongoId
	private String id;

	private CustomerDTO customer;

	private List<OrderHistoryEntryDTO> cartWithTime;

	public CustomerHistory(CustomerDTO customer, List<OrderHistoryEntryDTO> cartWithTime) {
		super();
		this.customer = customer;
		this.cartWithTime = cartWithTime;
	}

}
