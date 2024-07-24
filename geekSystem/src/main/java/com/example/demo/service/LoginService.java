package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.UsersRepository;
import com.example.demo.entity.Users;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	
	private final UsersRepository repository;
	
	public Optional <Users> searchUserByEmail(String email) {
		return repository.findByEmail(email);
	}
	
}