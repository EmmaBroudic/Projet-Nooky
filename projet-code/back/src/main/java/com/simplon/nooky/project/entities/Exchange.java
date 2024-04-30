package com.simplon.nooky.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "exchanges")
public class Exchange extends EntityAbstract {
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	User owner;
	
	@ManyToOne
	@JoinColumn(name = "exchanger_id")
	User exchanger;
	
	@ManyToOne
	@JoinColumn(name = "product_offered_id")
	Product productOffered;
	
	@ManyToOne
	@JoinColumn(name = "product_exchanged_id")
	Product productExchanged;
	
	@ManyToOne
	@JoinColumn(name = "status_prod_offered_id")
	Status statusProdOffered;
	
	@ManyToOne
	@JoinColumn(name = "status_prod_exchanged_id")
	Status statusProdExchanged;
	
	public Exchange() {
	}
	
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    
    public User getExchanger() {
        return exchanger;
    }

    public void setExchanger(User exchanger) {
        this.exchanger = exchanger;
    }
    
    public Product getProductOffered() {
        return productOffered;
    }

    public void setProductOffered(Product productOffered) {
        this.productOffered = productOffered;
    }
    
    public Product getProductExchanged() {
        return productExchanged;
    }

    public void setProductExchanged(Product productExchanged) {
        this.productExchanged = productExchanged;
    }
    
    public Status getStatusProdOffered() {
    	return statusProdOffered;
    }
    
    public void setStatusProdOffered(Status statusProdOffered) {
    	this.statusProdOffered = statusProdOffered;
    }
    
    public Status getStatusProdExchanged() {
    	return statusProdExchanged;
    }
    
    public void setStatusProdExchanged(Status statusProdExchanged) {
    	this.statusProdExchanged = statusProdExchanged;
    }
}
