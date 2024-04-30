package com.simplon.nooky.project.dto.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AuthUser {
	
	@NotNull
	@Email
	@Size(max= 254)
	private String email;
	
	@NotNull
	@Size(max= 100)
	private String password;
	
	public AuthUser() {
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
