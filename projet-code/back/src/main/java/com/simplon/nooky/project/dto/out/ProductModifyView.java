package com.simplon.nooky.project.dto.out;

import java.sql.Timestamp;

public interface ProductModifyView {
	Long getId();
	String getName();
	String getDescription();
	String getCategoryId();
	String getSizeId();
	String getTypeId();
	String getPicture();
	Timestamp getAddedAt();
	String getWishlist();
	Long getUserId();
	String getUserUsername();
}
