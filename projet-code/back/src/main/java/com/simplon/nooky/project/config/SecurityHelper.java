package com.simplon.nooky.project.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityHelper {
	private final JwtProvider jwt;

    private final PasswordEncoder encoder;

    SecurityHelper(JwtProvider jwt, PasswordEncoder encoder) {
    	this.jwt = jwt;
    	this.encoder = encoder;
    }

    public String createToken(String subject) {
    	return jwt.create(subject);
    }

    public String encode(String rawPassword) {
    	return encoder.encode(rawPassword);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
    	return encoder.matches(rawPassword, encodedPassword);
    }
}
