package com.simplon.nooky.project.dto.out;

import java.sql.Timestamp;

public interface UserView {
	String getEmail();
	String getUsername();
	String getFirstname();
	String getLastname();
	String getDescription();
	String getPicture();
	Timestamp getCreatedAt();
	String getAddressRoad();
	String getAddressZipCode();
	String getAddressCity();
}
