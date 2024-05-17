package com.simplon.nooky.project.config;

import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtIssuerValidator;
import org.springframework.security.oauth2.jwt.JwtTimestampValidator;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import com.auth0.jwt.algorithms.Algorithm;

@Configuration
public class SpringSecurityConfig {
	
	@Value("${nooky.security.jwt.issuer}")
    private String issuer;

    @Value("${nooky.security.jwt.expiration}")
    private long expiration;

    @Value("${nooky.security.jwt.zoneId}")
    private String zoneId;

    @Value("${nooky.security.jwt.secret}")
    private String secret;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors(Customizer.withDefaults()).csrf(csrf -> csrf.disable())
			.logout(logout -> logout.disable())
			.sessionManagement(management -> management
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/products/all")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/products/{id}")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/products/all/user/{id}")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/users/id/{id}")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/categories/all")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/categories/id/{id}")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/categories/label/{label}")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/types/all")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/types/id/{id}")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/types/label/{label}")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/sizes/all")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/sizes/id/{id}")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/sizes/label/{label}")
				.permitAll())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.POST, "/users")
				.anonymous())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.POST, "/users/auth")
				.anonymous())
			.authorizeHttpRequests(req -> req
				.requestMatchers(HttpMethod.GET, "/users/email/{email}")
				.anonymous())
			.authorizeHttpRequests(
				reqs -> reqs.anyRequest().fullyAuthenticated())
			.oauth2ResourceServer(
				srv -> srv.jwt(Customizer.withDefaults()));
		return http.build();
    }

    private OAuth2TokenValidator<Jwt> tokenValidator() {
		List<OAuth2TokenValidator<Jwt>> validators = List.of(
			new JwtTimestampValidator(), new JwtIssuerValidator(issuer));
		return new DelegatingOAuth2TokenValidator<>(validators);
    }

    @Bean
    JwtDecoder jwtDecoder() {
		SecretKey secretKey = new SecretKeySpec(secret.getBytes(),
			"HMACSHA256");
		NimbusJwtDecoder decoder = NimbusJwtDecoder.withSecretKey(secretKey)
			.macAlgorithm(MacAlgorithm.HS256).build();
		decoder.setJwtValidator(tokenValidator());
		return decoder;
    }

    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
		authoritiesConverter.setAuthorityPrefix("");
		JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
		authenticationConverter
			.setJwtGrantedAuthoritiesConverter(authoritiesConverter);
		return authenticationConverter;
    }

    @Bean
    SecurityHelper securityHelper() {
		Algorithm algorithm = Algorithm.HMAC256(secret);
		JwtProvider provider = new JwtProvider(issuer, expiration, zoneId,
			algorithm);
		return new SecurityHelper(provider, new BCryptPasswordEncoder());
    }

}
