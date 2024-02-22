package com.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderHistoryEntryDTO implements Serializable {

	private static final long serialVersionUID = 661977227845739078L;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime createdAt;

	private List<ProductInfoDTO> cart;

	public OrderHistoryEntryDTO(List<ProductInfoDTO> cart) {
		createdAt = LocalDateTime.now();
		this.cart = cart;
	}
}
