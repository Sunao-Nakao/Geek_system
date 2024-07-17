package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constant.MessageConst;
import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;
import com.example.demo.util.AppUtil;

import lombok.RequiredArgsConstructor;

/**ログイン コントローラー **/
@Controller
@RequiredArgsConstructor
@RequestMapping("/geek")
public class LoginController {
	
	/** ログイン画面 サービス **/
	private final LoginService service;
	
	/** PasswordEncoder **/
	private final PasswordEncoder passwordEncoder;
	
	/** メッセージソース **/
	private final MessageSource messageSource;
	
	@GetMapping("/login")
	public String view(Model model, LoginForm form) {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Model model, LoginForm form) {
		var users = service.searchUserByEmail(form.getEmail());
		var isCorrectUserAuth = users.isPresent() 
				&& passwordEncoder.matches(form.getPassword(), users.get().getPassword());
		
		if(isCorrectUserAuth) {
			return "redirect:/geek/top"; 
			
		} else {
			var errorMsg = AppUtil.getMessage(messageSource, MessageConst.LOGIN_WRONG_INPUT);
			model.addAttribute("errorMsg",errorMsg);
			return "login";
		}
	}
}
