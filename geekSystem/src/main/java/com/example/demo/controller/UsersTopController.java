package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.constant.UrlConst;
import com.example.demo.entity.Users;
import com.example.demo.service.UsersTopService;


/**トップコントローラー**/
@Controller
public class UsersTopController {
	
	@Autowired
	private UsersTopService usersTopService;
	
	@GetMapping(UrlConst.USERS_TOP)
	public String view(Model model) {
		 List<Users> users = usersTopService.getAllUsers();
		model.addAttribute("users", usersTopService.getAllUsers());
		
		return "users-top";
	}

}