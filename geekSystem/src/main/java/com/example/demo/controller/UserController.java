package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.constant.UrlConst;


/**トップコントローラー**/
@Controller
public class UserController {
	
	@GetMapping(UrlConst.USERS_TOP)
	public String view() {
		
		return "users";
	}

}