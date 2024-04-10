package com.simplon.nooky.project.dto.views;

import java.sql.Timestamp;

public interface ProductView {
	String getName();
	String getDescription();
	String getCategoryLabel();
	String getSizeLabel();
	String getTypeLabel();
	String getPicture();
	Timestamp getAddedAt();
	String getWishlist();
	String getUserUsername();
}
