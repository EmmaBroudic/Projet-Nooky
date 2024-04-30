package com.simplon.nooky.project.dto.in;

public class CreateExchange {
	
	private Long ownerId;
	
	private Long exchangerId;
	
	private Long productOfferedId;
	
	private Long productExchangedId;
	
	private Long statusProdOfferedId;
	
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
