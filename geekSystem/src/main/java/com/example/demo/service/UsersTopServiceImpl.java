package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UsersRepository;
import com.example.demo.entity.Users;

@Service
public class UsersTopServiceImpl implements UsersTopService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}
	
}
