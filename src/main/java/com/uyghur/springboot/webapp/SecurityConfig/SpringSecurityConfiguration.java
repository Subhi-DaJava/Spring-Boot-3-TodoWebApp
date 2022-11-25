package com.uyghur.springboot.webapp.SecurityConfig;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	// InMemoryUserDetailsManager
	// InMemoryUserDetailManager(UserDetails...users)

	@Bean
	public InMemoryUserDetailsManager userDatailsManager() {

		UserDetails userDetails1 = createNewUser("uyghurjava.com", "12345");
		UserDetails userDetails2 = createNewUser("uyghur", "12345");

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

		UserDetails userDetails =
				User.builder().passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER", "ADMIN")
				.build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// by default
	// All URLs are protected
	// A login form is shown for unauthorized requests

	// configuration SecurityFilterChain: defines a filter chain matched against every request
	// CSRF disable for enable h2
	// Frames for h2 
	
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { 
		
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		
		http.formLogin(withDefaults()); // redirect to login page for unauthorized request
		
		http.csrf().disable();
		
		// X-Frame-Options enabled => Frames Cannot be used h2-console uses frames => Disable X-Frame-Options header
		http.headers().frameOptions().disable();
		
		return http.build();	
		
	}
}
