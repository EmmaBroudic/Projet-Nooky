package com.simplon.nooky.project.dto.views;

import java.time.LocalDateTime;

public interface ProductView {
	String getName();
	String getDescription();
	String getPicture();
	LocalDateTime getAddedAt();
	String getWishlist();
}
