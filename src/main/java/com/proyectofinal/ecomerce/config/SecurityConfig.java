package com.proyectofinal.ecomerce.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/carrito/**", "/pedido/**").authenticated()
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll()
            );
		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService(DataSource dataSource) {
		JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager(dataSource);
		if (!userDetailsService.userExists("user")) {
			userDetailsService.createUser(
					User.withUsername("user")
					.password(passwordEncoder().encode("password"))
					.roles("USER")
					.build());
		}
		return userDetailsService;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}