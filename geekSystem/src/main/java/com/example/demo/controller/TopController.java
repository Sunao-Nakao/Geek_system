package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**トップコントローラー**/
@Controller
@RequestMapping("/geek")
public class TopController {
	
	@GetMapping("/top")
	public String view() {
		
		return "top";
	}

}
