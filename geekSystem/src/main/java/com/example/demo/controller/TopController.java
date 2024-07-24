package com.example.demo.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.constant.Permissions;
import com.example.demo.constant.UrlConst;


/** トップコントローラー **/
@Controller
public class TopController {
	
	@GetMapping(UrlConst.TOP)
	public String view(@AuthenticationPrincipal User user, Model model) {
		var hasUserManageAuth = user.getAuthorities().stream()
				.allMatch(authority -> authority.getAuthority()
					.equals(Permissions.ITEM_AND_USER_MANAGER.getPermissions()));
		model.addAttribute("hasUserManageAuth", hasUserManageAuth);
		return "top";
	}

}