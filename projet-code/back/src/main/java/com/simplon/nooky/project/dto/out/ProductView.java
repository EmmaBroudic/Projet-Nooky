package com.simplon.nooky.project.dto.out;

import java.sql.Timestamp;

public interface ProductView {
	String getId();
	String getName();
	String getDescription();
	String getCategoryLabel();
	String getSizeLabel();
	String getTypeLabel();
	String getPicture();
	Timestamp getAddedAt();
	String getWishlist();
	String getUserId();
	String getUserUsername();
}
