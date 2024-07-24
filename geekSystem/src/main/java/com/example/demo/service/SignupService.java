package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Users;
import com.example.demo.form.SignupForm;

public interface SignupService {
	
	public Optional<Users> resistUsers(SignupForm form);

}
