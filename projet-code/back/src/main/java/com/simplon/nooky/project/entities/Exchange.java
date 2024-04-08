package com.simplon.nooky.project.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Exchange extends EntityAbstract {

	@ManyToOne
	@JoinColumn(name = "from_a_user_id")
	private Long fromUserId;
	
	@ManyToOne
	@JoinColumn(name = "to_another_user_id")
	private Long toUserId;
	
	@ManyToOne
	@JoinColumn(name = "product_offered_id")
	private Long productOfferedId;
	
	@ManyToOne
	@JoinColumn(name = "product_exchanged_id")
	private Long productExchangedId;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Long statusId;
	
	public Exchange() {
	}
	
	public Long getFromUserId() {
		return this.fromUserId;
	}
	
	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}
	
	public Long getToUserId() {
		return this.toUserId;
	}
	
	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
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
}
