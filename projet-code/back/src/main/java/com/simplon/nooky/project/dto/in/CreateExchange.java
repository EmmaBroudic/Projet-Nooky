package com.simplon.nooky.project.dto.in;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateExchange {
	
	@NotNull
	@Positive
	private Long ownerId;
	
	@NotNull
	@Positive
	private Long exchangerId;
	
	@NotNull
	@Positive
	private Long productOfferedId;
	
	@NotNull
	@Positive
	private Long productExchangedId;
	
	@NotNull
	@Positive
	private Long statusProdOfferedId;
	
	@NotNull
	@Positive
	private Long statusProdExchangedId;
	
	public CreateExchange() {
	}
	
	public Long getOwnerId() {
		return this.ownerId;
	}
	
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	
	public Long getExchangerId() {
		return this.exchangerId;
	}
	
	public void setExchangerId(Long exchangerId) {
		this.exchangerId = exchangerId;
	}
	
	public Long getProductOfferedId() {
		return this.productOfferedId;
	}
	
	public void setProductOfferedId(Long productOfferedId) {
		this.productOfferedId = productOfferedId;
	}
	
	public Long getProductExchangedId() {
		return this.productExchangedId;
	}
	
	public void setProductExchangedId(Long productExchangedId) {
		this.productExchangedId = productExchangedId;
	}
	
	public Long getStatusProdOfferedId() {
		return this.statusProdOfferedId;
	}
	
	public void setStatusProdOfferedId(Long statusProdOfferedId) {
		this.statusProdOfferedId = statusProdOfferedId;
	}
	
	public Long getStatusProdExchangedId() {
		return this.statusProdExchangedId;
	}
	
	public void setStatusProdExchangedId(Long statusProdExchangedId) {
		this.statusProdExchangedId = statusProdExchangedId;
	}
}
