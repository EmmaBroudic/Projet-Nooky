package com.simplon.nooky.project.dto.views;

import com.simplon.nooky.project.entities.Product;
import com.simplon.nooky.project.entities.Status;
import com.simplon.nooky.project.entities.User;

public interface ExchangeView {
	User getOwner();
	User getExchanger();
	Product getProductOffered();
	Product getProductExchanged();
	Status getStatus();
}
