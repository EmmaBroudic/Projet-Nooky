package com.simplon.nooky.project.dto.out;

import java.sql.Timestamp;

public interface ProductView {
	Long getId();
	String getName();
	String getDescription();
	String getCategoryLabel();
	String getSizeLabel();
	String getTypeLabel();
	String getPicture();
	Timestamp getAddedAt();
	String getWishlist();
	Long getUserId();
	String getUserUsername();
}
