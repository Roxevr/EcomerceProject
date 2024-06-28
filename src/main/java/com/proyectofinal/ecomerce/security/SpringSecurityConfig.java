package com.proyectofinal.ecomerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

	/*
	@Autowired
	private JpaUserDetailsService userDetailService;
	
	@Autowired
	private LogginSuccessHandler successHandler;
	 */

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests( (authz) -> authz
						.requestMatchers(HttpMethod.GET, "/", "/css/**", "/js/**", "/images/**", "/productos").permitAll()
						.requestMatchers("/ver/**").hasAnyRole("USER")
						.requestMatchers("/uploads/**").hasAnyRole("USER")
						.requestMatchers("/form/**").hasAnyRole("ADMIN")
						.requestMatchers("/eliminar/**").hasAnyRole("ADMIN")
						.requestMatchers("/factura/**").hasAnyRole("ADMIN")
						.anyRequest().authenticated())
				.formLogin(login -> login
						// .successHandler(successHandler)
						.loginPage("/login").permitAll())
				.logout(logout -> logout.permitAll()).exceptionHandling(ex -> ex.accessDeniedPage("/error_404"))
				.build();

	}

	/*
	@Autowired
	public void userDetailsService(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
	}
	*/
}
