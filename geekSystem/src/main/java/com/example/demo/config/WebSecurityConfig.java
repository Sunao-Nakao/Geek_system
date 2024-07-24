package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.constant.UrlConst;

import lombok.RequiredArgsConstructor;


/** Spring Security カスタマイズ用 **/
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	/** パスワードエンコーダー **/
	private final PasswordEncoder passwordEncoder;
	
	/** ユーザ情報取得Service **/
	private final UserDetailsService userDetailsService;
	
	/** メッセージ情報取得 **/
	private final MessageSource messageSource;
	
	/** メッセージ情報取得 **/
	private final String USERNAME_PARAMETER = "email";
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests(
				authorize -> authorize.requestMatchers(UrlConst.NO_AUTHENTICATION).permitAll()
					.anyRequest().authenticated())
		
		.formLogin(login -> login.loginPage(UrlConst.LOGIN)
				.usernameParameter(USERNAME_PARAMETER)
				.defaultSuccessUrl(UrlConst.TOP));
		
		return http.build();
	}
	
	@Bean
	AuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		provider.setMessageSource(messageSource);
		
		return provider;
	}
	
}
