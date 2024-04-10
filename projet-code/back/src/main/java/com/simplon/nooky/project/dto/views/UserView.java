package com.simplon.nooky.project.dto.views;

import java.sql.Timestamp;

public interface UserView {
	String getEmail();
	String getUsername();
	String getFirstname();
	String getLastname();
	String getPicture();
	Timestamp getCreatedAt();
}
